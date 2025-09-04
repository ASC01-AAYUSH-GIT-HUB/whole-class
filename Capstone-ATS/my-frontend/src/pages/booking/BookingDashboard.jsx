import { Link, Outlet } from "react-router-dom";

function BookingDashboard() {
  return (
    <div>
      <h2>Booking Dashboard</h2>
      <nav style={{ marginBottom: "20px" }}>
        <Link to="list" style={{ marginRight: "15px" }}>List Bookings</Link>
        <Link to="create" style={{ marginRight: "15px" }}>Create Booking</Link>
        <Link to="detail/1" style={{ marginRight: "15px" }}>Get Booking by ID</Link>
        <Link to="delete/1">Delete Booking</Link>
      </nav>
      <Outlet />
    </div>
  );
}

export default BookingDashboard;
