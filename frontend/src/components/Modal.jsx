import { useEffect } from 'react';
import './Modal.css';

function Modal({ team, player, onClose }) {
  useEffect(() => {
    const handleEscape = (e) => {
      if (e.key === 'Escape') {
        onClose();
      }
    };

    document.addEventListener('keydown', handleEscape);
    document.body.style.overflow = 'hidden';

    return () => {
      document.removeEventListener('keydown', handleEscape);
      document.body.style.overflow = 'unset';
    };
  }, [onClose]);

  const renderPlayerSection = (players, title) => {
    if (!players || players.length === 0) {
      return <p className="no-data">No {title.toLowerCase()} found.</p>;
    }

    return (
      <ul className="modal-player-list">
        {players.map((p, idx) => (
          <li key={idx}>
            {p.firstName || ''} {p.lastName || ''}{' '}
            <span className="player-pos">({(p.positions || []).join(', ')})</span>
          </li>
        ))}
      </ul>
    );
  };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        <button className="modal-close" onClick={onClose} aria-label="Close">
          ×
        </button>

        {team && (
          <div className="modal-body">
            <h2 className="modal-title">{team.name || 'Team Details'}</h2>
            <div className="modal-stats">
              <div className="stat">
                <span className="stat-label">Wins:</span>
                <span className="stat-value">{team.wins ?? '-'}</span>
              </div>
              <div className="stat">
                <span className="stat-label">Losses:</span>
                <span className="stat-value">{team.losses ?? '-'}</span>
              </div>
              <div className="stat">
                <span className="stat-label">Ties:</span>
                <span className="stat-value">{team.ties ?? '-'}</span>
              </div>
            </div>

            <div className="modal-section">
              <h3 className="modal-section-title">Starters</h3>
              {renderPlayerSection(team.starters, 'Starters')}
            </div>

            <div className="modal-section">
              <h3 className="modal-section-title">Bench</h3>
              {renderPlayerSection(team.bench, 'Bench')}
            </div>

            {team.reserves && team.reserves.length > 0 && (
              <div className="modal-section">
                <h3 className="modal-section-title">Reserves</h3>
                {renderPlayerSection(team.reserves, 'Reserves')}
              </div>
            )}

            {team.taxis && team.taxis.length > 0 && (
              <div className="modal-section">
                <h3 className="modal-section-title">Taxis</h3>
                {renderPlayerSection(team.taxis, 'Taxis')}
              </div>
            )}
          </div>
        )}

        {player && (
          <div className="modal-body">
            <h2 className="modal-title">
              {player.firstName || ''} {player.lastName || ''}
            </h2>
            <div className="player-details">
              <div className="detail-row">
                <span className="detail-label">Positions:</span>
                <span className="detail-value">
                  {(player.positions || []).join(', ') || '-'}
                </span>
              </div>
              <div className="detail-row">
                <span className="detail-label">Team:</span>
                <span className="detail-value">{player.team || '-'}</span>
              </div>
              <div className="detail-row">
                <span className="detail-label">Number:</span>
                <span className="detail-value">{player.number ?? '-'}</span>
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
}

export default Modal;
