import { Link, Outlet } from "react-router-dom";
import "./PlaneDashboard.css";

function PlaneDashboard() {
  return (
    <div className="plane-container">
      {/* Sidebar */}
      <aside className="plane-sidebar">
        <h2 className="plane-logo">✈️ Plane Panel</h2>
        <nav className="plane-nav">
          <Link to="list" className="plane-link">📋 List Planes</Link>
          <Link to="add" className="plane-link">➕ Add Plane</Link>
          <Link to="detail/1" className="plane-link">🔍 Get Plane by ID</Link>
          <Link to="update/1" className="plane-link">✏️ Update Plane</Link>
          <Link to="delete/1" className="plane-link">❌ Delete Plane</Link>
        </nav>
      </aside>

      {/* Main Content */}
      <main className="plane-main">
        <h2 className="plane-title">Welcome to Plane Dashboard</h2>
        <Outlet /> {/* Child routes render here */}
      </main>
    </div>
  );
}

export default PlaneDashboard;
