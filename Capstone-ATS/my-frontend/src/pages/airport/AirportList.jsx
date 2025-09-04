import { useEffect, useState } from "react";

function AirportList() {
  const [airports, setAirports] = useState([]);

  useEffect(() => {
    fetch("http://localhost:3001/ats/airport/all")
      .then((res) => res.json())
      .then((data) => setAirports(data))
      .catch((err) => console.error("Error fetching airports:", err));
  }, []);

  return (
    <div>
      <h3>All Airports</h3>
      <ul>
        {airports.map((airport) => (
          <li key={airport.code}>
            {airport.name} ({airport.code}) - {airport.city}, {airport.country}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AirportList;
