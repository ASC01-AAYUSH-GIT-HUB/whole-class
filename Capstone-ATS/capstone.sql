


INSERT INTO admins (email, password, failed_attempts, account_locked, lock_time)
VALUES 
('admin1@example.com', 'Admin@123', 0, 0, NULL),
('admin2@example.com', 'Admin@456', 0, 0, NULL);
SELECT * FROM admins;


CREATE SEQUENCE AirportSeq
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE FlightSeq
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE PassengerSeq
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE ScheduleSeq
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE BookingSeq
    START WITH 1
    INCREMENT BY 1;
