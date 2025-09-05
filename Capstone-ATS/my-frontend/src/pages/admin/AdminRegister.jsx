import { useState } from "react";
import "./AdminRegister.css"; // ✅ import CSS

function AdminRegister() {
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
        return res.text(); // backend returns string
      })
      .then((msg) => setMessage(msg))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div className="register-container">
      <div className="register-box">
        <h2>Register New Admin</h2>
        <form onSubmit={handleRegister}>
          <input
            type="text"
            placeholder="Full Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />

          <input
            type="email"
            placeholder="Email Address"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />

          <input
            type="text"
            placeholder="Phone Number"
            value={phoneNo}
            onChange={(e) => setPhoneNo(e.target.value)}
            required
          />

          <input
            type="password"
            placeholder="Create Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <button type="submit">Register</button>
        </form>

        {message && <p className="register-message">{message}</p>}
      </div>
    </div>
  );
}

export default AdminRegister;
