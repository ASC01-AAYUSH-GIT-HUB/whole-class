import { useEffect, useState } from "react";
import "./PassengerList.css";

function PassengerList() {
  const [passengers, setPassengers] = useState([]);
  const [message, setMessage] = useState("");
  const [editingPassenger, setEditingPassenger] = useState(null); // store passenger being edited
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
  });

  // Fetch all passengers
  const fetchPassengers = () => {
    fetch("http://localhost:5001/ats/passengers/all")
      .then((res) => res.json())
      .then((data) => setPassengers(data))
      .catch((err) => console.error("Error fetching passengers:", err));
  };

  useEffect(() => {
    fetchPassengers();
  }, []);

  // Delete passenger
  const handleDelete = (id) => {
    fetch(`http://localhost:5001/ats/passengers/${id}`, {
      method: "DELETE",
    })
      .then((res) => {
        if (res.status === 204) {
          setMessage(`✅ Passenger ${id} deleted successfully`);
          setPassengers(passengers.filter((p) => p.passengerId !== id));
        } else {
          throw new Error("Failed to delete passenger");
        }
      })
      .catch((err) => setMessage("❌ " + err.message));
  };

  // Open update form
  const handleEdit = (passenger) => {
    setEditingPassenger(passenger.passengerId);
    setFormData({
      firstName: passenger.firstName,
      lastName: passenger.lastName,
      email: passenger.email,
      phone: passenger.phone,
    });
  };

  // Handle update form submit
  const handleUpdate = (e) => {
    e.preventDefault();

    fetch(`http://localhost:5001/ats/passengers/${editingPassenger}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData),
    })
      .then((res) => res.json())
      .then((data) => {
        setMessage(`✅ Passenger ${data.passengerId} updated successfully`);
        setPassengers(
          passengers.map((p) =>
            p.passengerId === data.passengerId ? data : p
          )
        );
        setEditingPassenger(null); // close form
      })
      .catch((err) => setMessage("❌ " + err.message));
  };

  return (
    <div className="passenger-list-container">
      <h2>All Passengers</h2>
      {message && <p className="message">{message}</p>}

      <div className="passenger-list">
        {passengers.map((p) => (
          <div key={p.passengerId} className="passenger-card">
            <h3>
              {p.firstName} {p.lastName}
            </h3>
            <p><strong>ID:</strong> {p.passengerId}</p>
            <p><strong>Email:</strong> {p.email}</p>
            <p><strong>Phone:</strong> {p.phone}</p>

            <button
              className="update-btn"
              onClick={() => handleEdit(p)}
            >
              Update
            </button>
            <button
              className="delete-btn"
              onClick={() => handleDelete(p.passengerId)}
            >
              Delete
            </button>

            {/* Inline update form */}
            {editingPassenger === p.passengerId && (
              <form className="update-form" onSubmit={handleUpdate}>
                <input
                  value={formData.firstName}
                  onChange={(e) =>
                    setFormData({ ...formData, firstName: e.target.value })
                  }
                  required
                />
                <input
                  value={formData.lastName}
                  onChange={(e) =>
                    setFormData({ ...formData, lastName: e.target.value })
                  }
                  required
                />
                <input
                  type="email"
                  value={formData.email}
                  onChange={(e) =>
                    setFormData({ ...formData, email: e.target.value })
                  }
                  required
                />
                <input
                  value={formData.phone}
                  onChange={(e) =>
                    setFormData({ ...formData, phone: e.target.value })
                  }
                  required
                />
                <button type="submit">Save</button>
                <button
                  type="button"
                  onClick={() => setEditingPassenger(null)}
                >
                  Cancel
                </button>
              </form>
            )}
          </div>
        ))}
      </div>
    </div>
  );
}

export default PassengerList;
