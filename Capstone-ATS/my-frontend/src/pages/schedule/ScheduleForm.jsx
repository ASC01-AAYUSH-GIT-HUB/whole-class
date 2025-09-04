import { useState } from "react";

function ScheduleForm() {
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

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch("http://localhost:6001/ats/schedules/create", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to create schedule");
        return res.json();
      })
      .then((data) => setMessage("Schedule created with ID: " + data.scheduleId))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Create Schedule</h3>
      <form onSubmit={handleSubmit}>
        <input name="planeId" placeholder="Plane ID" value={form.planeId} onChange={handleChange} required /><br /><br />
        <input name="departureAirportId" placeholder="Departure Airport ID" value={form.departureAirportId} onChange={handleChange} required /><br /><br />
        <input name="arrivalAirportId" placeholder="Arrival Airport ID" value={form.arrivalAirportId} onChange={handleChange} required /><br /><br />
        <input type="datetime-local" name="departureTime" value={form.departureTime} onChange={handleChange} required /><br /><br />
        <input type="datetime-local" name="arrivalTime" value={form.arrivalTime} onChange={handleChange} required /><br /><br />
        <button type="submit">Create</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

export default ScheduleForm;
