import { Link } from "react-router-dom";
import { useAuth } from "../AuthContext";

function Navbar() {
  const { isAdminLoggedIn, logout } = useAuth();

  return (
    <nav
      style={{
        display: "flex",
        alignItems: "center",
        gap: "15px",
        padding: "10px 20px",
        background: "#333",
        color: "white",
      }}
    >
      <Link to="/" style={{ color: "white", textDecoration: "none" }}>
        Home
      </Link>

      <Link to="/admin/login" style={{ color: "white", textDecoration: "none" }}>
        Admin
      </Link>
      {/* <Link to="/admin/list" style={{ color: "white", textDecoration: "none" }}>
        Admin List
      </Link> */}

      {isAdminLoggedIn && (
        <>
          <Link to="/passenger" style={{ color: "white", textDecoration: "none" }}>
            Passenger
          </Link>
          <Link to="/airport" style={{ color: "white", textDecoration: "none" }}>
            Airport
          </Link>
          <Link to="/plane" style={{ color: "white", textDecoration: "none" }}>
            Plane
          </Link>
          <Link to="/schedule" style={{ color: "white", textDecoration: "none" }}>
            Schedule
          </Link>
          <Link to="/booking" style={{ color: "white", textDecoration: "none" }}>
            Booking
          </Link>
          <button
            onClick={logout}
            style={{
              marginLeft: "auto",
              background: "#dc3545",
              color: "white",
              border: "none",
              padding: "6px 12px",
              borderRadius: "5px",
              cursor: "pointer",
            }}
          >
            Logout
          </button>
        </>
      )}
    </nav>
  );
}

export default Navbar;
