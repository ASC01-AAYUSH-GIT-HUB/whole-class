import { useState } from "react";

function BookingDetail() {
  const [id, setId] = useState("");
  const [booking, setBooking] = useState(null);
  const [message, setMessage] = useState("");

  const handleFetch = () => {
    fetch(`http://localhost:7001/ats/bookings/${id}`)
      .then((res) => {
        if (!res.ok) throw new Error("Booking not found");
        return res.json();
      })
      .then((data) => setBooking(data))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Get Booking by ID</h3>
      <input type="text" placeholder="Enter Booking ID" value={id} onChange={(e) => setId(e.target.value)} />
      <button onClick={handleFetch}>Fetch</button>

      {booking && (
        <div>
          <p><b>ID:</b> {booking.bookingId}</p>
          <p><b>Schedule:</b> {booking.scheduleId}</p>
          <p><b>Passenger:</b> {booking.passengerId}</p>
          <p><b>Seat:</b> {booking.seatNumber}</p>
          <p><b>Status:</b> {booking.status}</p>
        </div>
      )}
      {message && <p>{message}</p>}
    </div>
  );
}

export default BookingDetail;
