import { useEffect, useState } from "react";

function BookingList() {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    fetch("http://localhost:7001/ats/bookings/all")
      .then((res) => res.json())
      .then((data) => setBookings(data))
      .catch((err) => console.error("Error fetching bookings:", err));
  }, []);

  return (
    <div>
      <h3>All Bookings</h3>
      <ul>
        {bookings.map((b) => (
          <li key={b.bookingId}>
            <b>ID:</b> {b.bookingId} | Schedule: {b.scheduleId} | Passenger: {b.passengerId}  
            <br /> Seat: {b.seatNumber} | Status: {b.status}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookingList;
