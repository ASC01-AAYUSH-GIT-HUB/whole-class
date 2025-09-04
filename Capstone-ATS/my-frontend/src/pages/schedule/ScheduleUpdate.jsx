import { useState } from "react";

function ScheduleUpdate() {
  const [id, setId] = useState("");
  const [form, setForm] = useState({
    planeId: "",
    departureAirportId: "",
    arrivalAirportId: "",
    departureTime: "",
    arrivalTime: ""
  });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleUpdate = (e) => {
    e.preventDefault();

    fetch(`http://localhost:6001/ats/schedules/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to update schedule");
        return res.json();
      })
      .then((data) => setMessage("Schedule updated: " + data.scheduleId))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Update Schedule</h3>
      <input type="text" placeholder="Enter Schedule ID" value={id} onChange={(e) => setId(e.target.value)} /><br /><br />
      <form onSubmit={handleUpdate}>
        <input name="planeId" placeholder="Plane ID" value={form.planeId} onChange={handleChange} required /><br /><br />
        <input name="departureAirportId" placeholder="Departure Airport ID" value={form.departureAirportId} onChange={handleChange} required /><br /><br />
        <input name="arrivalAirportId" placeholder="Arrival Airport ID" value={form.arrivalAirportId} onChange={handleChange} required /><br /><br />
        <input type="datetime-local" name="departureTime" value={form.departureTime} onChange={handleChange} required /><br /><br />
        <input type="datetime-local" name="arrivalTime" value={form.arrivalTime} onChange={handleChange} required /><br /><br />
        <button type="submit">Update</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

export default ScheduleUpdate;
