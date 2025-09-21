document.addEventListener('DOMContentLoaded', function() {
    const leagueForm = document.getElementById('leagueForm');
    const leagueIdInput = document.getElementById('leagueId');
    const leagueSection = document.getElementById('leagueSection');
    const teamsSection = document.getElementById('teamsSection');
    const errorSection = document.getElementById('errorSection');
    const loadingSection = document.getElementById('loadingSection');
    const modal = document.getElementById('modal');
    const modalBody = document.getElementById('modalBody');
    const closeModalBtn = document.getElementById('closeModal');

    let lastFocusedElement = null;

    leagueForm.addEventListener('submit', function(e) {
        e.preventDefault();
        const leagueId = leagueIdInput.value.trim();
        if (!leagueId) {
            showError('Please enter a League ID.');
            return;
        }
        clearSections();
        showLoading('Loading league data...');
        fetch(`/api/league/${leagueId}`)
            .then(res => {
                if (!res.ok) throw new Error('League not found');
                return res.json();
            })
            .then(data => {
                hideLoading();
                renderLeague(data);
            })
            .catch(err => {
                hideLoading();
                showError('Could not load league data.');
            });
    });

    function renderLeague(league) {
        if (!league || !league.teams || league.teams.length === 0) {
            showError('No teams found in this league.');
            return;
        }
        // Compose a single line for season and sport
        let seasonSport = '';
        if (league.season && league.sport) {
            seasonSport = `${league.season} ${league.sport} Season`;
        } else if (league.season) {
            seasonSport = `${league.season} Season`;
        } else if (league.sport) {
            seasonSport = `${league.sport} Season`;
        }
        leagueSection.innerHTML = `
            <h2>${league.name || 'League'}</h2>
            <p><strong>${seasonSport}</strong></p>
        `;
        teamsSection.innerHTML = '<h2>Teams</h2>' + league.teams.map((team, idx) => renderTeam(team, idx)).join('');
        // Add click listeners for team cards and player items
        document.querySelectorAll('.team-card').forEach((el, idx) => {
            el.addEventListener('click', () => openTeamModal(league.teams[idx]));
        });
        document.querySelectorAll('.player-list li').forEach((el, idx) => {
            el.addEventListener('click', (e) => {
                e.stopPropagation();
                const teamIdx = el.closest('.team-card').getAttribute('data-team-idx');
                const playerIdx = el.getAttribute('data-player-idx');
                openPlayerModal(league.teams[teamIdx].starters[playerIdx]);
            });
        });
    }

    function renderTeam(team, idx) {
        let startersHtml = '';
        if (team.starters && team.starters.length > 0) {
            startersHtml = `<ul class="player-list">${team.starters.map((p, pidx) => `<li data-player-idx="${pidx}">${p.firstName || ''} ${p.lastName || ''} <span style='color:#888'>(${(p.positions||[]).join(', ')})</span></li>`).join('')}</ul>`;
        } else {
            startersHtml = '<p>No starters found.</p>';
        }
        return `
            <div class="team-card" data-team-idx="${idx}" tabindex="0" aria-label="View team details">
                <h3>${team.name || 'Team'}</h3>
                <p><strong>Wins:</strong> ${team.wins ?? '-'} | <strong>Losses:</strong> ${team.losses ?? '-'} | <strong>Ties:</strong> ${team.ties ?? '-'}</p>
                <div><strong>Starters:</strong> ${startersHtml}</div>
            </div>
        `;
    }

    function openTeamModal(team) {
        lastFocusedElement = document.activeElement;
        modalBody.innerHTML = `
            <h2>${team.name || 'Team Details'}</h2>
            <p><strong>Wins:</strong> ${team.wins ?? '-'} | <strong>Losses:</strong> ${team.losses ?? '-'} | <strong>Ties:</strong> ${team.ties ?? '-'}</p>
            <h3>Starters</h3>
            ${team.starters && team.starters.length > 0 ? `<ul>${team.starters.map(p => `<li>${p.firstName || ''} ${p.lastName || ''} (${(p.positions||[]).join(', ')})</li>`).join('')}</ul>` : '<p>No starters found.</p>'}
        `;
        showModal();
    }

    function openPlayerModal(player) {
        lastFocusedElement = document.activeElement;
        modalBody.innerHTML = `
            <h2>${player.firstName || ''} ${player.lastName || ''}</h2>
            <p><strong>Positions:</strong> ${(player.positions||[]).join(', ')}</p>
            <p><strong>Team:</strong> ${player.team || '-'}</p>
            <p><strong>Number:</strong> ${player.number ?? '-'}</p>
        `;
        showModal();
    }

    function showModal() {
        modal.style.display = 'flex';
        closeModalBtn.focus();
    }
    function closeModal() {
        modal.style.display = 'none';
        if (lastFocusedElement) lastFocusedElement.focus();
    }
    closeModalBtn.addEventListener('click', closeModal);
    closeModalBtn.addEventListener('keydown', function(e) {
        if (e.key === 'Enter' || e.key === ' ') closeModal();
    });
    window.addEventListener('keydown', function(e) {
        if (e.key === 'Escape' && modal.style.display === 'flex') closeModal();
    });
    modal.addEventListener('click', function(e) {
        if (e.target === modal) closeModal();
    });

    function showError(msg) {
        errorSection.textContent = msg;
        errorSection.style.display = 'block';
    }
    function showLoading(msg) {
        loadingSection.textContent = msg;
        loadingSection.style.display = 'block';
    }
    function hideLoading() {
        loadingSection.textContent = '';
        loadingSection.style.display = 'none';
    }
    function clearSections() {
        leagueSection.innerHTML = '';
        teamsSection.innerHTML = '';
        errorSection.textContent = '';
        errorSection.style.display = 'none';
        hideLoading();
    }
});
