import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";

// Admin
import AdminDashboard from "./pages/admin/AdminDashboard";
import AdminList from "./pages/admin/AdminList";
import AdminLogin from "./pages/admin/AdminLogin";
import AdminRegister from "./pages/admin/AdminRegister";

// Passenger
import PassengerDashboard from "./pages/passenger/PassengerDashboard";
import PassengerList from "./pages/passenger/PassengerList";
import PassengerForm from "./pages/passenger/PassengerForm";
import PassengerDetail from "./pages/passenger/PassengerDetail";
import PassengerUpdate from "./pages/passenger/PassengerUpdate";
import PassengerDelete from "./pages/passenger/PassengerDelete";

// Airport
import AirportDashboard from "./pages/airport/AirportDashboard";
import AirportList from "./pages/airport/AirportList";
import AirportForm from "./pages/airport/AirportForm";
import AirportDetail from "./pages/airport/AirportDetail";
import AirportDelete from "./pages/airport/AirportDelete";

// Plane
import PlaneDashboard from "./pages/plane/PlaneDashboard";
import PlaneList from "./pages/plane/PlaneList";
import PlaneForm from "./pages/plane/PlaneForm";
import PlaneDetail from "./pages/plane/PlaneDetail";
import PlaneUpdate from "./pages/plane/PlaneUpdate";
import PlaneDelete from "./pages/plane/PlaneDelete";

// Schedule
import ScheduleDashboard from "./pages/schedule/ScheduleDashboard";
import ScheduleList from "./pages/schedule/ScheduleList";
import ScheduleForm from "./pages/schedule/ScheduleForm";
import ScheduleDetail from "./pages/schedule/ScheduleDetail";
import ScheduleUpdate from "./pages/schedule/ScheduleUpdate";
import ScheduleDelete from "./pages/schedule/ScheduleDelete";

// Booking
import BookingDashboard from "./pages/booking/BookingDashboard";
import BookingList from "./pages/booking/BookingList";
import BookingForm from "./pages/booking/BookingForm";
import BookingDetail from "./pages/booking/BookingDetail";
import BookingDelete from "./pages/booking/BookingDelete";

function App() {
  return (
    <Router>
      <div style={{ padding: "20px" }}>
        {/* Top navigation */}
        <nav style={{ marginBottom: "20px" }}>
          <Link to="/" style={{ marginRight: "20px" }}>Home</Link>
          <Link to="/admin" style={{ marginRight: "20px" }}>Admin</Link>
          <Link to="/passenger" style={{ marginRight: "20px" }}>Passenger</Link>
          <Link to="/airport" style={{ marginRight: "20px" }}>Airport</Link>
          <Link to="/plane" style={{ marginRight: "20px" }}>Plane</Link>
          <Link to="/schedule" style={{ marginRight: "20px" }}>Schedule</Link>
          <Link to="/booking" style={{ marginRight: "20px" }}>Booking</Link>
        </nav>

        <Routes>
          {/* Home */}
          <Route path="/" element={<Home />} />

          {/* Admin Dashboard with nested routes */}
          <Route path="/admin" element={<AdminDashboard />}>
            <Route path="list" element={<AdminList />} />
            <Route path="login" element={<AdminLogin />} />
            <Route path="register" element={<AdminRegister />} />
          </Route>

          {/* Passenger Dashboard with nested routes */}
          <Route path="/passenger" element={<PassengerDashboard />}>
            <Route path="list" element={<PassengerList />} />
            <Route path="create" element={<PassengerForm />} />
            <Route path=":id" element={<PassengerDetail />} />
            <Route path="update/:id" element={<PassengerUpdate />} />
            <Route path="delete/:id" element={<PassengerDelete />} />
          </Route>
          {/* Airport Dashboard with nested routes */}
          <Route path="/airport" element={<AirportDashboard />}>
            <Route path="list" element={<AirportList />} />
            <Route path="create" element={<AirportForm />} />
            <Route path="detail/:id" element={<AirportDetail />} />
            <Route path="delete/:id" element={<AirportDelete />} />
          </Route>
          {/* Plane Dashboard with nested routes */}
          <Route path="/plane" element={<PlaneDashboard />}>
            <Route path="list" element={<PlaneList />} />
            <Route path="add" element={<PlaneForm />} />
            <Route path="detail/:id" element={<PlaneDetail />} />
            <Route path="update/:id" element={<PlaneUpdate />} />
            <Route path="delete/:id" element={<PlaneDelete />} />
          </Route>
          {/* Schedule Dashboard with nested routes */}
          <Route path="/schedule" element={<ScheduleDashboard />}>
            <Route path="list" element={<ScheduleList />} />
            <Route path="create" element={<ScheduleForm />} />
            <Route path="detail/:id" element={<ScheduleDetail />} />
            <Route path="update/:id" element={<ScheduleUpdate />} />
            <Route path="delete/:id" element={<ScheduleDelete />} />
          </Route>
          {/* Booking Dashboard with nested routes */}
          <Route path="/booking" element={<BookingDashboard />}>
            <Route path="list" element={<BookingList />} />
            <Route path="create" element={<BookingForm />} />
            <Route path="detail/:id" element={<BookingDetail />} />
            <Route path="delete/:id" element={<BookingDelete />} />
          </Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
