import { useState } from 'react';
import './App.css';
import Header from './components/Header';
import LeagueSearch from './components/LeagueSearch';
import LeagueInfo from './components/LeagueInfo';
import TeamCard from './components/TeamCard';
import Modal from './components/Modal';
import Footer from './components/Footer';
import Legend from './components/Legend';

function App() {
  const [league, setLeague] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [selectedTeam, setSelectedTeam] = useState(null);
  const [selectedPlayer, setSelectedPlayer] = useState(null);

  const handleSearch = async (leagueId) => {
    setError('');
    setLeague(null);
    setLoading(true);

    try {
      const response = await fetch(`/api/league/${leagueId}`);
      if (!response.ok) {
        throw new Error('League not found');
      }
      const data = await response.json();
      setLeague(data);
    } catch (err) {
      setError('Could not load league data. Please check the League ID and try again.');
    } finally {
      setLoading(false);
    }
  };

  const handleCloseModal = () => {
    setSelectedTeam(null);
    setSelectedPlayer(null);
  };

  return (
    <div className="app">
      <Header />
      <main className="main-content">
        <div className="container">
          <LeagueSearch onSearch={handleSearch} loading={loading} />
          
          {error && (
            <div className="error-message">
              <span className="error-icon">⚠️</span>
              {error}
            </div>
          )}

          {loading && (
            <div className="loading-container">
              <div className="spinner"></div>
              <p>Loading league data...</p>
            </div>
          )}

          {league && !loading && (
            <>
              <LeagueInfo league={league} />
              
              <section className="teams-section">
                <h2 className="section-title">Teams</h2>
                <div className="teams-grid">
                  {league.teams && league.teams.length > 0 ? (
                    league.teams.map((team, idx) => (
                      <TeamCard
                        key={idx}
                        team={team}
                        onTeamClick={() => setSelectedTeam(team)}
                        onPlayerClick={(player) => setSelectedPlayer(player)}
                      />
                    ))
                  ) : (
                    <p className="no-data">No teams found in this league.</p>
                  )}
                </div>
              </section>

              <Legend />
            </>
          )}
        </div>
      </main>
      <Footer />

      {(selectedTeam || selectedPlayer) && (
        <Modal
          team={selectedTeam}
          player={selectedPlayer}
          onClose={handleCloseModal}
        />
      )}
    </div>
  );
}

export default App;
