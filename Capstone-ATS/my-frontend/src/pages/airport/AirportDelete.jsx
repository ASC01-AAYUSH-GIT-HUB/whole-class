import { useState } from "react";

function AirportDelete() {
  const [id, setId] = useState("");
  const [message, setMessage] = useState("");

  const handleDelete = () => {
    fetch(`http://localhost:3001/ats/airport/${id}`, {
      method: "DELETE",
    })
      .then((res) => {
        if (res.status === 204) setMessage("Airport deleted successfully!");
        else throw new Error("Failed to delete");
      })
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Delete Airport</h3>
      <input
        type="text"
        placeholder="Enter airport ID"
        value={id}
        onChange={(e) => setId(e.target.value)}
      />
      <button onClick={handleDelete}>Delete</button>
      {message && <p>{message}</p>}
    </div>
  );
}

export default AirportDelete;
