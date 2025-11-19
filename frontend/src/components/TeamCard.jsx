import './TeamCard.css';

function TeamCard({ team, onTeamClick, onPlayerClick }) {
  const renderPlayerList = (players, category) => {
    if (!players || players.length === 0) {
      return <p className="no-players">No {category.toLowerCase()} found</p>;
    }

    return (
      <ul className="player-list">
        {players.slice(0, 5).map((player, idx) => (
          <li
            key={idx}
            className="player-item"
            onClick={(e) => {
              e.stopPropagation();
              onPlayerClick(player);
            }}
          >
            <span className="player-name">
              {player.firstName || ''} {player.lastName || ''}
            </span>
            <span className="player-position">
              {(player.positions || []).join(', ')}
            </span>
          </li>
        ))}
        {players.length > 5 && (
          <li className="player-more">
            +{players.length - 5} more
          </li>
        )}
      </ul>
    );
  };

  return (
    <div className="team-card" onClick={onTeamClick}>
      <div className="team-header">
        <h3 className="team-name">{team.name || 'Team'}</h3>
        <div className="team-record">
          <span className="record-item">
            <span className="record-label">W:</span> {team.wins ?? '-'}
          </span>
          <span className="record-item">
            <span className="record-label">L:</span> {team.losses ?? '-'}
          </span>
          <span className="record-item">
            <span className="record-label">T:</span> {team.ties ?? '-'}
          </span>
        </div>
      </div>

      <div className="team-section">
        <h4 className="section-title">Starters</h4>
        {renderPlayerList(team.starters, 'Starters')}
      </div>

      <div className="team-section">
        <h4 className="section-title">Bench</h4>
        {renderPlayerList(team.bench, 'Bench')}
      </div>

      {team.reserves && team.reserves.length > 0 && (
        <div className="team-section">
          <h4 className="section-title">Reserves</h4>
          {renderPlayerList(team.reserves, 'Reserves')}
        </div>
      )}

      {team.taxis && team.taxis.length > 0 && (
        <div className="team-section">
          <h4 className="section-title">Taxis</h4>
          {renderPlayerList(team.taxis, 'Taxis')}
        </div>
      )}

      <div className="team-footer">
        <button className="view-details-btn">View Full Details</button>
      </div>
    </div>
  );
}

export default TeamCard;
