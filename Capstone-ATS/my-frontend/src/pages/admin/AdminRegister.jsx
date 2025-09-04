import { useState } from "react";

function Register() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const handleRegister = (e) => {
    e.preventDefault();

    const newAdmin = { name, email, phoneNo, password };

    fetch("http://localhost:2001/ats/admin/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newAdmin),
    })
      .then((res) => {
        if (!res.ok) {
          throw new Error("Registration failed");
        }
        return res.text(); // or res.json() depending on backend
      })
      .then((msg) => setMessage(msg))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Register New Admin</h2>
      <form onSubmit={handleRegister}>
        <input
          type="text"
          placeholder="Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        /><br /><br />

        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        /><br /><br />

        <input
          type="text"
          placeholder="Phone No"
          value={phoneNo}
          onChange={(e) => setPhoneNo(e.target.value)}
          required
        /><br /><br />

        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        /><br /><br />

        <button type="submit">Register</button>
      </form>

      {message && <p>{message}</p>}
    </div>
  );
}

export default Register;
