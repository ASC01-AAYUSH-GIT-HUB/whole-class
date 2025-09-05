import { Link, Outlet } from "react-router-dom";

function PassengerDashboard() {
  return (
    <div>
      <h2>Passenger Dashboard</h2>
      <nav style={{ marginBottom: "20px" }}>
        <Link to="list" style={{ marginRight: "15px" }}>List Passengers</Link>
        <Link to="create" style={{ marginRight: "15px" }}>Create Passenger</Link>
        {/* <Link to="update/1" style={{ marginRight: "15px" }}>Update Passenger</Link>
        <Link to="delete/1">Delete Passenger</Link> */}
      </nav>

      {/* Child routes render here */}
      <Outlet />
    </div>
  );
}

export default PassengerDashboard;
