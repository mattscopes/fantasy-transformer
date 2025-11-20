import './Footer.css';

function Footer() {
  const currentYear = new Date().getFullYear();
  
  return (
    <footer className="footer">
      <div className="footer-content">
        <p>© {currentYear} Fantasy Transformer</p>
        <p className="footer-tagline">Transforming fantasy sports data into insights</p>
      </div>
    </footer>
  );
}

export default Footer;
