import { Link, Outlet } from "react-router-dom";
import "./AdminDashboard.css"; // import styles

function AdminDashboard() {
  return (
    <div className="admin-container">
      {/* Sidebar */}
      <aside className="admin-sidebar">
        <h2 className="admin-logo">Admin Panel</h2>
        <nav className="admin-nav">
          <Link to="list" className="admin-link">📋 List Admins</Link>
          <Link to="login" className="admin-link">🔑 Login</Link>
          <Link to="register" className="admin-link">➕ Register</Link>
        </nav>
      </aside>

      {/* Main Content */}
      <main className="admin-main">
        <h2 className="admin-title">Welcome to Admin Dashboard</h2>
        <Outlet /> {/* Child routes render here */}
      </main>
    </div>
  );
}

export default AdminDashboard;
