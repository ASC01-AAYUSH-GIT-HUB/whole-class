import { Link, Outlet } from "react-router-dom";
import "./PassengerDashboard.css";

function PassengerDashboard() {
  return (
    <div className="passenger-container">
      {/* Sidebar */}
      <aside className="passenger-sidebar">
        <h2 className="passenger-logo">Passenger Panel</h2>
        <nav className="passenger-nav">
          <Link to="list" className="passenger-link">📋 List Passengers</Link>
          <Link to="create" className="passenger-link">➕ Create Passenger</Link>
          {/* Future expansion: Update/Delete */}
        </nav>
      </aside>

      {/* Main Content */}
      <main className="passenger-main">
        <h2 className="passenger-title">Welcome to Passenger Dashboard</h2>
        <Outlet /> {/* Child routes will render here */}
      </main>
    </div>
  );
}

export default PassengerDashboard;
