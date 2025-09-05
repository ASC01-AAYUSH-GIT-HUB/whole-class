import { Link, Outlet } from "react-router-dom";
import "./BookingDashboard.css";

function BookingDashboard() {
  return (
    <div className="booking-container">
      {/* Sidebar */}
      <aside className="booking-sidebar">
        <h2 className="booking-logo">📖 Booking Panel</h2>
        <nav className="booking-nav">
          <Link to="list" className="booking-link">📋 List Bookings</Link>
          <Link to="create" className="booking-link">➕ Create Booking</Link>
          <Link to="detail/1" className="booking-link">🔍 Get Booking by ID</Link>
          <Link to="delete/1" className="booking-link">❌ Delete Booking</Link>
        </nav>
      </aside>

      {/* Main content */}
      <main className="booking-main">
        <h2 className="booking-title">Welcome to Booking Dashboard</h2>
        <Outlet /> {/* Child routes render here */}
      </main>
    </div>
  );
}

export default BookingDashboard;
