import { useState } from "react";

function ScheduleDetail() {
  const [id, setId] = useState("");
  const [schedule, setSchedule] = useState(null);
  const [message, setMessage] = useState("");

  const handleFetch = () => {
    fetch(`http://localhost:6001/ats/schedules/${id}`)
      .then((res) => {
        if (!res.ok) throw new Error("Schedule not found");
        return res.json();
      })
      .then((data) => setSchedule(data))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Get Schedule by ID</h3>
      <input type="text" placeholder="Enter Schedule ID" value={id} onChange={(e) => setId(e.target.value)} />
      <button onClick={handleFetch}>Fetch</button>

      {schedule && (
        <div>
          <p><b>ID:</b> {schedule.scheduleId}</p>
          <p><b>Plane:</b> {schedule.planeId}</p>
          <p><b>From:</b> {schedule.departureAirportId} → {schedule.arrivalAirportId}</p>
          <p><b>Departure:</b> {schedule.departureTime}</p>
          <p><b>Arrival:</b> {schedule.arrivalTime}</p>
        </div>
      )}
      {message && <p>{message}</p>}
    </div>
  );
}

export default ScheduleDetail;
