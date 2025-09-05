import { useState } from "react";
import { useAuth } from "../../AuthContext"; // ✅ adjust path
import "./AdminAuth.css"; // ✅ styling

function AdminAuth() {
  const [activeTab, setActiveTab] = useState("login"); // "login" | "register"
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [message, setMessage] = useState("");

  const { login } = useAuth();

  // ✅ Handle Login
  const handleLogin = (e) => {
    e.preventDefault();

    fetch("http://localhost:2001/ats/admin/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email, password }),
    })
      .then((res) => res.text())
      .then((msg) => {
        setMessage(msg);
        if (msg.startsWith("Login successful!")) {
          login();
        }
      })
      .catch((err) => setMessage("Login failed: " + err));
  };

  // ✅ Handle Register
  const handleRegister = (e) => {
    e.preventDefault();

    const newAdmin = { name, email, phoneNo, password };

    fetch("http://localhost:2001/ats/admin/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newAdmin),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Registration failed");
        return res.text();
      })
      .then((msg) => setMessage(msg))
      .catch((err) => setMessage("Error: " + err.message));
  };

  return (
    <div className="auth-container">
      <div className="auth-box">
        <div className="tabs">
          <button
            className={activeTab === "login" ? "active" : ""}
            onClick={() => {
              setActiveTab("login");
              setMessage("");
            }}
          >
            Login
          </button>
          <button
            className={activeTab === "register" ? "active" : ""}
            onClick={() => {
              setActiveTab("register");
              setMessage("");
            }}
          >
            Register
          </button>
        </div>

        {activeTab === "login" ? (
          <form onSubmit={handleLogin}>
            <input
              type="email"
              placeholder="Email Address"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />

            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />

            <button type="submit">Login</button>
          </form>
        ) : (
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
        )}

        {message && <p className="auth-message">{message}</p>}
      </div>
    </div>
  );
}

export default AdminAuth;
