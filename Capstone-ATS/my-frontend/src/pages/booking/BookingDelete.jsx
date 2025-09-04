import { useState } from "react";

function BookingDelete() {
  const [id, setId] = useState("");
  const [message, setMessage] = useState("");

  const handleDelete = () => {
    fetch(`http://localhost:7001/ats/bookings/${id}`, {
      method: "DELETE",
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to delete booking");
        return res.text();
      })
      .then(() => setMessage("Booking deleted successfully"))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Delete Booking</h3>
      <input type="text" placeholder="Enter Booking ID" value={id} onChange={(e) => setId(e.target.value)} />
      <button onClick={handleDelete}>Delete</button>
      {message && <p>{message}</p>}
    </div>
  );
}

export default BookingDelete;
