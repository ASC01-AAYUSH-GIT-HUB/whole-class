import { Link, Outlet } from "react-router-dom";
import "./AirportDashboard.css";

function AirportDashboard() {
  return (
    <div className="airport-container">
      {/* Sidebar */}
      <aside className="airport-sidebar">
        <h2 className="airport-logo">Airport Panel</h2>
        <nav className="airport-nav">
          <Link to="list" className="airport-link">🛫 List Airports</Link>
          <Link to="create" className="airport-link">➕ Create Airport</Link>
          <Link to="detail/1" className="airport-link">🔍 Get Airport by ID</Link>
          <Link to="delete/1" className="airport-link">❌ Delete Airport</Link>
        </nav>
      </aside>

      {/* Main Content */}
      <main className="airport-main">
        <h2 className="airport-title">Welcome to Airport Dashboard</h2>
        <Outlet /> {/* Child routes render here */}
      </main>
    </div>
  );
}

export default AirportDashboard;
