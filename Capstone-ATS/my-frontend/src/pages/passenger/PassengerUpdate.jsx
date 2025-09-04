import { useState } from "react";

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
      .then((res) => res.json())
      .then((data) => setMessage("Passenger updated: " + data.passengerId))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Update Passenger</h2>
      <form onSubmit={handleUpdate}>
        <input placeholder="Passenger ID" value={id} onChange={(e) => setId(e.target.value)} required /><br /><br />
        <input placeholder="First Name" value={firstName} onChange={(e) => setFirstName(e.target.value)} required /><br /><br />
        <input placeholder="Last Name" value={lastName} onChange={(e) => setLastName(e.target.value)} required /><br /><br />
        <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required /><br /><br />
        <input placeholder="Phone" value={phone} onChange={(e) => setPhone(e.target.value)} required /><br /><br />
        <button type="submit">Update</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

export default PassengerUpdate;
