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

function App() {
  return (
    <Router>
      <div style={{ padding: "20px" }}>
        {/* Top navigation */}
        <nav style={{ marginBottom: "20px" }}>
          <Link to="/" style={{ marginRight: "20px" }}>Home</Link>
          <Link to="/admin" style={{ marginRight: "20px" }}>Admin</Link>
          <Link to="/passenger">Passenger</Link>
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
        </Routes>
      </div>
    </Router>
  );
}

export default App;
