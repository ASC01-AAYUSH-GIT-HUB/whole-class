import { Link, Outlet } from "react-router-dom";

function AdminDashboard() {
  return (
    <div>
      <h2>Admin Dashboard</h2>
      <nav style={{ marginBottom: "20px" }}>
        <Link to="list" style={{ marginRight: "15px" }}>List Admins</Link>
        <Link to="login" style={{ marginRight: "15px" }}>Login</Link>
        <Link to="register">Register</Link>
      </nav>

      {/* This is where child routes render */}
      <Outlet />
    </div>
  );
}

export default AdminDashboard;
