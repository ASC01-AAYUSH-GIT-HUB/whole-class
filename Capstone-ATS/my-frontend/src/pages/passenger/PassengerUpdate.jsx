import { useState } from "react";
import "./PassengerUpdate.css";

function PassengerUpdate() {
  const [id, setId] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [message, setMessage] = useState("");

  const handleUpdate = (e) => {
    e.preventDefault();
    const updatedPassenger = { firstName, lastName, email, phone };

    fetch(`http://localhost:5001/ats/passengers/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(updatedPassenger),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to update passenger");
        return res.json();
      })
      .then((data) => setMessage(`✅ Passenger updated: ${data.passengerId}`))
      .catch((err) => setMessage("❌ Error: " + err.message));
  };

  return (
    <div className="passenger-update-container">
      <h2>Update Passenger</h2>

      <form onSubmit={handleUpdate} className="passenger-update-form">
        <input
          type="text"
          placeholder="Passenger ID"
          value={id}
          onChange={(e) => setId(e.target.value)}
          required
        />

        <input
          type="text"
          placeholder="First Name"
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)}
          required
        />

        <input
          type="text"
          placeholder="Last Name"
          value={lastName}
          onChange={(e) => setLastName(e.target.value)}
          required
        />

        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />

        <input
          type="text"
          placeholder="Phone (10 digits)"
          value={phone}
          onChange={(e) => setPhone(e.target.value)}
          required
        />

        <button type="submit">Update Passenger</button>
      </form>

      {message && <p className="message">{message}</p>}
    </div>
  );
}

export default PassengerUpdate;
