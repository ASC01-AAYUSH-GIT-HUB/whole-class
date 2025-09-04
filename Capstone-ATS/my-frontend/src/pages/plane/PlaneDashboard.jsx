import { Link, Outlet } from "react-router-dom";

function PlaneDashboard() {
  return (
    <div>
      <h2>Plane Dashboard</h2>
      <nav style={{ marginBottom: "20px" }}>
        <Link to="list" style={{ marginRight: "15px" }}>List Planes</Link>
        <Link to="add" style={{ marginRight: "15px" }}>Add Plane</Link>
        <Link to="detail/1" style={{ marginRight: "15px" }}>Get Plane by ID</Link>
        <Link to="update/1" style={{ marginRight: "15px" }}>Update Plane</Link>
        <Link to="delete/1">Delete Plane</Link>
      </nav>

      <Outlet />
    </div>
  );
}

export default PlaneDashboard;
