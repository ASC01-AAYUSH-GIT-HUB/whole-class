import { useEffect, useState } from "react";

function ScheduleList() {
  const [schedules, setSchedules] = useState([]);

  useEffect(() => {
    fetch("http://localhost:6001/ats/schedules/all")
      .then((res) => res.json())
      .then((data) => setSchedules(data))
      .catch((err) => console.error("Error fetching schedules:", err));
  }, []);

  return (
    <div>
      <h3>All Schedules</h3>
      <ul>
        {schedules.map((sch) => (
          <li key={sch.scheduleId}>
            <b>{sch.scheduleId}</b> | Plane: {sch.planeId} | From: {sch.departureAirportId} → To: {sch.arrivalAirportId}  
            <br /> Departure: {sch.departureTime} | Arrival: {sch.arrivalTime}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ScheduleList;
