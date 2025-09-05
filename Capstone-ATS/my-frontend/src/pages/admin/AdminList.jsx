import { useEffect, useState } from "react";
import "./AdminList.css"; // ✅ import CSS

function AdminList() {
  const [admins, setAdmins] = useState([]);

  useEffect(() => {
    fetch("http://localhost:2001/ats/admin")
      .then((res) => res.json())
      .then((data) => setAdmins(data))
      .catch((err) => console.error("Error fetching admins:", err));
  }, []);

  return (
    <div className="list-container">
      <h2 className="list-title">All Admins</h2>

      <div className="admin-grid">
        {admins.map((a, i) => (
          <div key={i} className="admin-card">
            <h3>{a.name}</h3>
            <p><strong>Email:</strong> {a.email}</p>
            <p><strong>Phone:</strong> {a.phoneNo}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default AdminList;
