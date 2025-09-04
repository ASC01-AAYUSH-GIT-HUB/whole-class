import { Link, Outlet } from "react-router-dom";

function ScheduleDashboard() {
  return (
    <div>
      <h2>Schedule Dashboard</h2>
      <nav style={{ marginBottom: "20px" }}>
        <Link to="list" style={{ marginRight: "15px" }}>List Schedules</Link>
        <Link to="create" style={{ marginRight: "15px" }}>Create Schedule</Link>
        <Link to="detail/1" style={{ marginRight: "15px" }}>Get Schedule by ID</Link>
        <Link to="update/1" style={{ marginRight: "15px" }}>Update Schedule</Link>
        <Link to="delete/1">Delete Schedule</Link>
      </nav>
      <Outlet />
    </div>
  );
}

export default ScheduleDashboard;
