import { useEffect, useState } from "react";

function PassengerList() {
  const [passengers, setPassengers] = useState([]);

  useEffect(() => {
    fetch("http://localhost:5001/ats/passengers/all")
      .then((res) => res.json())
      .then((data) => setPassengers(data))
      .catch((err) => console.error("Error fetching passengers:", err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h2>All Passengers</h2>
      <ul>
        {passengers.map((p) => (
          <li key={p.passengerId}>
            {p.passengerId} - {p.firstName} {p.lastName} ({p.email})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default PassengerList;
