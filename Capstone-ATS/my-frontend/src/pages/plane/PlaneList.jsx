import { useEffect, useState } from "react";

function PlaneList() {
  const [planes, setPlanes] = useState([]);

  useEffect(() => {
    fetch("http://localhost:4001/ats/plane/all")
      .then((res) => res.json())
      .then((data) => setPlanes(data))
      .catch((err) => console.error("Error fetching planes:", err));
  }, []);

  return (
    <div>
      <h3>All Planes</h3>
      <ul>
        {planes.map((plane) => (
          <li key={plane.planeId}>
            {plane.planeName} - {plane.model} (Capacity: {plane.capacity})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default PlaneList;
