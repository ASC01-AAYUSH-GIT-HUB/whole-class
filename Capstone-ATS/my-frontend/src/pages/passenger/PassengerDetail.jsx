import { useState } from "react";

function PassengerDetail() {
  const [id, setId] = useState("");
  const [passenger, setPassenger] = useState(null);
  const [error, setError] = useState("");

  const handleSearch = () => {
    fetch(`http://localhost:5001/ats/passengers/${id}`)
      .then((res) => {
        if (!res.ok) throw new Error("Passenger not found");
        return res.json();
      })
      .then((data) => {
        setPassenger(data);
        setError("");
      })
      .catch((err) => setError(err.message));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Find Passenger</h2>
      <input placeholder="Passenger ID" value={id} onChange={(e) => setId(e.target.value)} />
      <button onClick={handleSearch}>Search</button>
      {error && <p style={{ color: "red" }}>{error}</p>}
      {passenger && (
        <div>
          <p><strong>ID:</strong> {passenger.passengerId}</p>
          <p>{passenger.firstName} {passenger.lastName}</p>
          <p>Email: {passenger.email}</p>
          <p>Phone: {passenger.phone}</p>
        </div>
      )}
    </div>
  );
}

export default PassengerDetail;
