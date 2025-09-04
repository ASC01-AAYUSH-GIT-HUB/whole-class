import { useState } from "react";

function BookingForm() {
  const [form, setForm] = useState({
    scheduleId: "",
    passengerId: "",
    seatNumber: "",
    status: ""
  });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch("http://localhost:7001/ats/bookings/initiate", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to create booking");
        return res.json();
      })
      .then((data) => setMessage("Booking created with ID: " + data.bookingId))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Create Booking</h3>
      <form onSubmit={handleSubmit}>
        <input name="scheduleId" placeholder="Schedule ID" value={form.scheduleId} onChange={handleChange} required /><br /><br />
        <input name="passengerId" placeholder="Passenger ID" value={form.passengerId} onChange={handleChange} required /><br /><br />
        <input name="seatNumber" placeholder="Seat Number" value={form.seatNumber} onChange={handleChange} required /><br /><br />
        <input name="status" placeholder="Status (e.g. CONFIRMED)" value={form.status} onChange={handleChange} required /><br /><br />
        <button type="submit">Create</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

export default BookingForm;
