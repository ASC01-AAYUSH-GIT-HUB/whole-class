import { useState } from "react";
import { useAuth } from "../../AuthContext"; 
import "./AdminLogin.css"; // ✅ import CSS

function AdminLogin() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const { login } = useAuth();

  const handleLogin = (e) => {
    e.preventDefault();

    fetch("http://localhost:2001/ats/admin/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email, password }),
    })
      .then((res) => res.text()) // ✅ backend returns String
      .then((msg) => {
        setMessage(msg);

        if (msg.startsWith("Login successful!")) {
          login(); // ✅ unlocks navigation
        }
      })
      .catch((err) => setMessage("Login failed: " + err));
  };

  return (
    <div className="login-container">
      <div className="login-card">
        <h2 className="login-title">Admin Login</h2>
        <form onSubmit={handleLogin} className="login-form">
          <div className="form-group">
            <label>Email</label>
            <input
              type="email"
              placeholder="Enter your email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>

          <div className="form-group">
            <label>Password</label>
            <input
              type="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <button type="submit" className="login-btn">Login</button>
        </form>

        {message && <p className="login-message">{message}</p>}
      </div>
    </div>
  );
}

export default AdminLogin;
