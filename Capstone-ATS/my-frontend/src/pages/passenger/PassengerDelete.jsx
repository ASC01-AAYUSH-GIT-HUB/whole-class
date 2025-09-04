import { useState } from "react";

function PassengerDelete() {
  const [id, setId] = useState("");
  const [message, setMessage] = useState("");

  const handleDelete = () => {
    fetch(`http://localhost:5001/ats/passengers/${id}`, {
      method: "DELETE",
    })
      .then((res) => {
        if (res.status === 204) {
          setMessage("Passenger deleted successfully");
        } else {
          throw new Error("Failed to delete passenger");
        }
      })
      .catch((err) => setMessage(err.message));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Delete Passenger</h2>
      <input placeholder="Passenger ID" value={id} onChange={(e) => setId(e.target.value)} />
      <button onClick={handleDelete}>Delete</button>
      {message && <p>{message}</p>}
    </div>
  );
}

export default PassengerDelete;
