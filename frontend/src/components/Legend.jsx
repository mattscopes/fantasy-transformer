import './Legend.css';

function Legend() {
  return (
    <div className="legend">
      <h3 className="legend-title">Legend</h3>
      <div className="legend-grid">
        <div className="legend-item">
          <div className="legend-icon starters">S</div>
          <div className="legend-content">
            <strong>Starters</strong>
            <p>Players in your starting lineup</p>
          </div>
        </div>
        <div className="legend-item">
          <div className="legend-icon bench">B</div>
          <div className="legend-content">
            <strong>Bench</strong>
            <p>Players not in starting lineup, reserves, or taxi</p>
          </div>
        </div>
        <div className="legend-item">
          <div className="legend-icon reserves">R</div>
          <div className="legend-content">
            <strong>Reserves</strong>
            <p>Players designated as reserves (IR, out, etc.)</p>
          </div>
        </div>
        <div className="legend-item">
          <div className="legend-icon taxis">T</div>
          <div className="legend-content">
            <strong>Taxis</strong>
            <p>Players on taxi squad (rookies, prospects)</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Legend;
