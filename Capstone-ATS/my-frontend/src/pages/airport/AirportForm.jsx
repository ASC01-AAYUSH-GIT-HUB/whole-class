import { useState } from "react";

function AirportForm() {
  const [form, setForm] = useState({ name: "", city: "", country: "", code: "" });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch("http://localhost:3001/ats/airport/create", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to create airport");
        return res.json();
      })
      .then((data) => setMessage("Airport created: " + data.name))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div>
      <h3>Create Airport</h3>
      <form onSubmit={handleSubmit}>
        <input name="name" placeholder="Name" value={form.name} onChange={handleChange} required /><br /><br />
        <input name="city" placeholder="City" value={form.city} onChange={handleChange} required /><br /><br />
        <input name="country" placeholder="Country" value={form.country} onChange={handleChange} required /><br /><br />
        <input name="code" placeholder="Code" value={form.code} onChange={handleChange} required /><br /><br />
        <button type="submit">Create</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

export default AirportForm;
