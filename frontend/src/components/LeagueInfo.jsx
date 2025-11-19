import './LeagueInfo.css';

function LeagueInfo({ league }) {
  const getSeasonInfo = () => {
    if (league.season && league.sport) {
      return `${league.season} ${league.sport} Season`;
    } else if (league.season) {
      return `${league.season} Season`;
    } else if (league.sport) {
      return `${league.sport} Season`;
    }
    return '';
  };

  return (
    <div className="league-info">
      <div className="league-info-content">
        <h2 className="league-name">{league.name || 'League'}</h2>
        {getSeasonInfo() && (
          <p className="league-season">{getSeasonInfo()}</p>
        )}
      </div>
    </div>
  );
}

export default LeagueInfo;
