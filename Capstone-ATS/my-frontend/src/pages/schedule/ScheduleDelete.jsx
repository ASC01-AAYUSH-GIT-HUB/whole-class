import { useState } from "react";

function ScheduleDelete() {
  const [id, setId] = useState("");
  const [message, setMessage] = useState("");

  const handleDelete = () => {
    fetch(`http://localhost:6001/ats/schedules/${id}`, {
      method: "DELETE",
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to delete");
        return res.text();
      })
      .then((msg) => setMessage(msg))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Delete Schedule</h3>
      <input type="text" placeholder="Enter Schedule ID" value={id} onChange={(e) => setId(e.target.value)} />
      <button onClick={handleDelete}>Delete</button>
      {message && <p>{message}</p>}
    </div>
  );
}

export default ScheduleDelete;
