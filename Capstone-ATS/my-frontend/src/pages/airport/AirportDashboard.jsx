import { Link, Outlet } from "react-router-dom";

function AirportDashboard() {
  return (
    <div>
      <h2>Airport Dashboard</h2>
      <nav style={{ marginBottom: "20px" }}>
        <Link to="list" style={{ marginRight: "15px" }}>List Airports</Link>
        <Link to="create" style={{ marginRight: "15px" }}>Create Airport</Link>
        <Link to="detail/1" style={{ marginRight: "15px" }}>Get Airport by ID</Link>
        <Link to="delete/1">Delete Airport</Link>
      </nav>

      <Outlet />
    </div>
  );
}

export default AirportDashboard;
