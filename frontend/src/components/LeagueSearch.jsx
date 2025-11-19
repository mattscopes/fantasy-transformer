import { useState } from 'react';
import './LeagueSearch.css';

function LeagueSearch({ onSearch, loading }) {
  const [leagueId, setLeagueId] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (leagueId.trim()) {
      onSearch(leagueId.trim());
    }
  };

  return (
    <div className="league-search">
      <form onSubmit={handleSubmit} className="search-form">
        <div className="form-group">
          <label htmlFor="leagueId" className="form-label">
            League ID
          </label>
          <div className="input-group">
            <input
              type="text"
              id="leagueId"
              className="form-input"
              placeholder="Enter your league ID"
              value={leagueId}
              onChange={(e) => setLeagueId(e.target.value)}
              disabled={loading}
              required
            />
            <button
              type="submit"
              className="search-button"
              disabled={loading || !leagueId.trim()}
            >
              {loading ? 'Loading...' : 'Load League'}
            </button>
          </div>
        </div>
      </form>
    </div>
  );
}

export default LeagueSearch;
