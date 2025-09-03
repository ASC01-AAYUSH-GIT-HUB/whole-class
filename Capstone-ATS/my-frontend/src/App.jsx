import { useEffect, useState } from "react";

function App() {
  const [admins, setAdmin] = useState([]);

  useEffect(() => {
    // adjust URL to your backend (Spring Boot default: localhost:8080)
    fetch("http://localhost:2001/ats/admin")
      .then((res) => res.json())
      .then((data) => {
        setAdmin(data);
      })
      .catch((err) => console.error("Error fetching admin data :", err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h2>Admins</h2>
    
      <ul>
        {admins.map((item, index) => (
          <li key={index}>{item.email}<br/>{item.name}<br/>{item.phoneNo}</li>
        ))}
      </ul>
    
    </div>
  );
}

export default App;
