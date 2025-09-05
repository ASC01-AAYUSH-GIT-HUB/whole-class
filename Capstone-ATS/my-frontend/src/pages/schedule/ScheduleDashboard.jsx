import { Link, Outlet } from "react-router-dom";
import "./ScheduleDashboard.css";

function ScheduleDashboard() {
  return (
    <div className="schedule-container">
      {/* Sidebar */}
      <aside className="schedule-sidebar">
        <h2 className="schedule-logo">📅 Schedule Panel</h2>
        <nav className="schedule-nav">
          <Link to="list" className="schedule-link">📋 List Schedules</Link>
          <Link to="create" className="schedule-link">➕ Create Schedule</Link>
          <Link to="detail/1" className="schedule-link">🔍 Get Schedule by ID</Link>
          <Link to="update/1" className="schedule-link">✏️ Update Schedule</Link>
          <Link to="delete/1" className="schedule-link">❌ Delete Schedule</Link>
        </nav>
      </aside>

      {/* Main content */}
      <main className="schedule-main">
        <h2 className="schedule-title">Welcome to Schedule Dashboard</h2>
        <Outlet /> {/* Child routes render here */}
      </main>
    </div>
  );
}

export default ScheduleDashboard;
