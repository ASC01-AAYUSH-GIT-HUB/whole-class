import { useState } from "react";
import "./PassengerForm.css";

function PassengerForm() {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    const newPassenger = { firstName, lastName, email, phone };

    fetch("http://localhost:5001/ats/passengers/create", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newPassenger),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Failed to create passenger");
        return res.json();
      })
      .then((data) => setMessage(`✅ Passenger created: ${data.passengerId}`))
      .catch((err) => setMessage("❌ Error: " + err.message));
  };

  return (
    <div className="passenger-form-container">
      <h2>Create Passenger</h2>

      <form onSubmit={handleSubmit} className="passenger-form">
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

        <button type="submit">Create Passenger</button>
      </form>

      {message && <p className="message">{message}</p>}
    </div>
  );
}

export default PassengerForm;
