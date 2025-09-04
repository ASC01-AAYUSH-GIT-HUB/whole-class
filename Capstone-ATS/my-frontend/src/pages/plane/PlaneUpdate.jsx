import { useState } from "react";

function PlaneUpdate() {
  const [id, setId] = useState("");
  const [form, setForm] = useState({ planeName: "", model: "", capacity: "" });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleUpdate = (e) => {
    e.preventDefault();

    fetch(`http://localhost:4001/ats/plane/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ ...form, capacity: Number(form.capacity) }),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to update plane");
        return res.json();
      })
      .then((data) => setMessage("Plane updated: " + data.planeName))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Update Plane</h3>
      <input
        type="text"
        placeholder="Enter plane ID"
        value={id}
        onChange={(e) => setId(e.target.value)}
      /><br /><br />
      <form onSubmit={handleUpdate}>
        <input name="planeName" placeholder="Plane Name" value={form.planeName} onChange={handleChange} required /><br /><br />
        <input name="model" placeholder="Model" value={form.model} onChange={handleChange} required /><br /><br />
        <input type="number" name="capacity" placeholder="Capacity" value={form.capacity} onChange={handleChange} required /><br /><br />
        <button type="submit">Update</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

export default PlaneUpdate;
