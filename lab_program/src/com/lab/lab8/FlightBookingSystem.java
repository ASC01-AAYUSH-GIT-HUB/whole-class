package com.lab.lab8;

import java.sql.*;
import java.util.Scanner;

public class FlightBookingSystem {
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=FLIGHT;user=sa;password=sqlserver;trustServerCertificate=true";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Flight Booking System ===");
            System.out.println("1. Add Booking(s)");
            System.out.println("2. Display All Bookings");
            System.out.println("3. Update Booking");
            System.out.println("4. Delete Booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1: 
                    addBookings();
                break;
                case 2: 
                    displayBookings();
                break;
                case 3: 
                    updateBooking();
                break;
                case 4: 
                    deleteBooking();
                break;
                case 5: 
                    System.out.println("Exiting...");
                break;
                default: 
                    System.out.println("Invalid choice.");
                break;
            }
        } while (choice != 5);
    }

    public static void addBookings() {
        try (
                Connection connection = DriverManager.getConnection(URL);
                Scanner sc = new Scanner(System.in)
        ) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.print("How many bookings to add? ");
            int count = sc.nextInt();
            sc.nextLine();

            String sql = "INSERT INTO FlightBooking (PassengerName, FromCity, ToCity, FlightDate) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < count; i++) {
                System.out.println("Booking " + (i + 1));
                System.out.print("Passenger Name: ");
                String name = sc.nextLine();
                System.out.print("From City: ");
                String from = sc.nextLine();
                System.out.print("To City: ");
                String to = sc.nextLine();
                System.out.print("Flight Date (yyyy-mm-dd): ");
                String date = sc.nextLine();

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, from);
                preparedStatement.setString(3, to);
                preparedStatement.setDate(4, Date.valueOf(date));
                preparedStatement.executeUpdate();
            }

            System.out.println("Booking(s) added successfully.");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void displayBookings() {
        try (
                Connection connection = DriverManager.getConnection(URL);
                Statement statement = connection.createStatement()
        ) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            ResultSet rs = statement.executeQuery("SELECT * FROM FlightBooking");

            System.out.println("\n=== All Bookings ===");
            while (rs.next()) {
                System.out.println(
                        "Booking ID: " + rs.getInt("BookingId") +
                                ", Name: " + rs.getString("PassengerName") +
                                ", From: " + rs.getString("FromCity") +
                                ", To: " + rs.getString("ToCity") +
                                ", Date: " + rs.getDate("FlightDate")
                );
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void updateBooking() {
        try (
                Connection connection = DriverManager.getConnection(URL);
                Scanner sc = new Scanner(System.in)
        ) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.print("Enter Booking ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            String checkSql = "SELECT * FROM FlightBooking WHERE BookingId = ?";
            PreparedStatement checkPs = connection.prepareStatement(checkSql);
            checkPs.setInt(1, id);
            ResultSet rs = checkPs.executeQuery();

            if (!rs.next()) {
                System.out.println("Booking ID not found.");
                return;
            }

            System.out.print("New Passenger Name: ");
            String name = sc.nextLine();
            System.out.print("New From City: ");
            String from = sc.nextLine();
            System.out.print("New To City: ");
            String to = sc.nextLine();
            System.out.print("New Flight Date (yyyy-mm-dd): ");
            String date = sc.nextLine();

            String updateSql = "UPDATE FlightBooking SET PassengerName = ?, FromCity = ?, ToCity = ?, FlightDate = ? WHERE BookingId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, from);
            preparedStatement.setString(3, to);
            preparedStatement.setDate(4, Date.valueOf(date));
            preparedStatement.setInt(5, id);
            int rows = preparedStatement.executeUpdate();
            System.out.println("Updated " + rows + " booking(s).");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void deleteBooking() {
        try (
                Connection connection = DriverManager.getConnection(URL);
                Scanner sc = new Scanner(System.in)
        ) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.print("Enter Booking ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();

            String deleteSql = "DELETE FROM FlightBooking WHERE BookingId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Booking deleted successfully.");
            } else {
                System.out.println("Booking ID not found.");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
