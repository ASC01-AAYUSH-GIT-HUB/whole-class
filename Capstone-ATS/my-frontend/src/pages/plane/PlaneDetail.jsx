import { useState } from "react";

function PlaneDetail() {
  const [id, setId] = useState("");
  const [plane, setPlane] = useState(null);
  const [message, setMessage] = useState("");

  const handleFetch = () => {
    fetch(`http://localhost:4001/ats/plane/${id}`)
      .then((res) => {
        if (!res.ok) throw new Error("Plane not found");
        return res.json();
      })
      .then((data) => setPlane(data))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Get Plane by ID</h3>
      <input
        type="text"
        placeholder="Enter plane ID"
        value={id}
        onChange={(e) => setId(e.target.value)}
      />
      <button onClick={handleFetch}>Fetch</button>

      {plane && (
        <div>
          <p><b>{plane.planeName}</b> ({plane.model})</p>
          <p>Capacity: {plane.capacity}</p>
        </div>
      )}
      {message && <p>{message}</p>}
    </div>
  );
}

export default PlaneDetail;

