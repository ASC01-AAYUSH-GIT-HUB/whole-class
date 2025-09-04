import { useState } from "react";

function PlaneForm() {
  const [form, setForm] = useState({ planeName: "", model: "", capacity: "" });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch("http://localhost:4001/ats/plane/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ ...form, capacity: Number(form.capacity) }),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to add plane");
        return res.json();
      })
      .then((data) => setMessage("Plane added: " + data.planeName))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Add Plane</h3>
      <form onSubmit={handleSubmit}>
        <input name="planeName" placeholder="Plane Name" value={form.planeName} onChange={handleChange} required /><br /><br />
        <input name="model" placeholder="Model" value={form.model} onChange={handleChange} required /><br /><br />
        <input type="number" name="capacity" placeholder="Capacity" value={form.capacity} onChange={handleChange} required /><br /><br />
        <button type="submit">Add</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

export default PlaneForm;
