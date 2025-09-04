import { useState } from "react";

function PlaneDelete() {
  const [id, setId] = useState("");
  const [message, setMessage] = useState("");

  const handleDelete = () => {
    fetch(`http://localhost:4001/ats/plane/${id}`, {
      method: "DELETE",
    })
      .then((res) => {
        if (res.ok) return res.text();
        throw new Error("Failed to delete");
      })
      .then((msg) => setMessage(msg))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Delete Plane</h3>
      <input
        type="text"
        placeholder="Enter plane ID"
        value={id}
        onChange={(e) => setId(e.target.value)}
      />
      <button onClick={handleDelete}>Delete</button>
      {message && <p>{message}</p>}
    </div>
  );
}

export default PlaneDelete;
