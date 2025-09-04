import { useState } from "react";

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
      .then((res) => res.json())
      .then((data) => setMessage("Passenger created: " + data.passengerId))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Create Passenger</h2>
      <form onSubmit={handleSubmit}>
        <input placeholder="First Name" value={firstName} onChange={(e) => setFirstName(e.target.value)} required /><br /><br />
        <input placeholder="Last Name" value={lastName} onChange={(e) => setLastName(e.target.value)} required /><br /><br />
        <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required /><br /><br />
        <input placeholder="Phone (10 digits)" value={phone} onChange={(e) => setPhone(e.target.value)} required /><br /><br />
        <button type="submit">Create</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

export default PassengerForm;
