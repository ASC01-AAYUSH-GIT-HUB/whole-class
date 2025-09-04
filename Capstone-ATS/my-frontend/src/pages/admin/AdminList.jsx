import { useEffect, useState } from "react";

function AdminList() {
  const [admins, setAdmins] = useState([]);

  useEffect(() => {
    fetch("http://localhost:2001/ats/admin")
      .then((res) => res.json())
      .then((data) => setAdmins(data))
      .catch((err) => console.error("Error fetching admins:", err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h2>All Admins</h2>
      <ul>
        {admins.map((a, i) => (
          <li key={i}>{a.name}<br/>{a.email}<br/>{a.phoneNo}</li>
        ))}
      </ul>
    </div>
  );
}

export default AdminList;
