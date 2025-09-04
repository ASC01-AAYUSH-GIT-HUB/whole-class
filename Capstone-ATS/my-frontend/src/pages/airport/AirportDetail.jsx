import { useState } from "react";

function AirportDetail() {
  const [id, setId] = useState("");
  const [airport, setAirport] = useState(null);
  const [message, setMessage] = useState("");

  const handleFetch = () => {
    fetch(`http://localhost:3001/ats/airport/${id}`)
      .then((res) => {
        if (!res.ok) throw new Error("Airport not found");
        return res.json();
      })
      .then((data) => setAirport(data))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Get Airport by ID</h3>
      <input
        type="text"
        placeholder="Enter airport ID"
        value={id}
        onChange={(e) => setId(e.target.value)}
      />
      <button onClick={handleFetch}>Fetch</button>

      {airport && (
        <div>
          <p><b>{airport.name}</b> ({airport.code})</p>
          <p>{airport.city}, {airport.country}</p>
        </div>
      )}
      {message && <p>{message}</p>}
    </div>
  );
}

export default AirportDetail;
