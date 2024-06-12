package com;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/")

public class HotelReservationDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/yaya_hotel";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String INSERT_USER_SQL = "INSERT INTO UserProfile (userID, userName, gender, contactNo, idNumber, age, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ROOM_BY_TYPE = "SELECT * FROM RoomDetails WHERE roomType = ?";
    private static final String INSERT_RESERVATION_SQL = "INSERT INTO RoomReservation (userID, checkInDate, checkOutDate, roomType, roomID, numOfCustomers, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_RESERVATIONS_BY_USER = "SELECT * FROM RoomReservation WHERE userID = ?";
    private static final String UPDATE_RESERVATION_SQL = "UPDATE RoomReservation SET checkInDate = ?, checkOutDate = ?, roomType = ?, roomID = ?, numOfCustomers = ?, totalPrice = ? WHERE reservationCode = ?";
    private static final String DELETE_RESERVATION_SQL = "DELETE FROM RoomReservation WHERE reservationCode = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    
    // Add User
    public void addUser(UserProfile user) { // Use a dedicated User class
        if (user.getIdNumber() == null || user.getIdNumber().isEmpty()) {
            throw new IllegalArgumentException("ID number cannot be null or empty");
        }
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUserID());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getContactNo());
            preparedStatement.setString(5, user.getIdNumber());
            preparedStatement.setInt(6, user.getAge());
            preparedStatement.setString(7, user.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get Room Details by Type
    public RoomDetails getRoomDetailsByType(String roomType) {
        RoomDetails roomDetails = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROOM_BY_TYPE)) {
            preparedStatement.setString(1, roomType);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                roomDetails = new RoomDetails();
                roomDetails.setRoomID(rs.getString("roomID"));
                roomDetails.setRoomNo(rs.getInt("roomNo"));
                roomDetails.setRoomPicture(rs.getString("roomPicture"));
                roomDetails.setRoomType(rs.getString("roomType"));
                roomDetails.setRoomPrice(rs.getDouble("roomPrice"));
            } else {
                // Handle case where no room is found (throw exception or return special indicator)
                // throw new RoomNotFoundException("Room with type " + roomType + " not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomDetails;
    }

    // Add Room Reservation
    public void addReservation(RoomReservation reservation) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION_SQL)) {
            preparedStatement.setString(1, reservation.getUserID());
            preparedStatement.setDate(2, (Date) reservation.getCheckInDate());
            preparedStatement.setDate(3, (Date) reservation.getCheckOutDate());
            preparedStatement.setString(4, reservation.getRoomType());
            preparedStatement.setString(5, reservation.getRoomID());
            preparedStatement.setInt(6, reservation.getNumOfCustomers());
            preparedStatement.setDouble(7, reservation.getTotalPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      // Add method to retrieve all reservations for a user
    public List<RoomReservation> getReservationsByUserID(String userID) {
        List<RoomReservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM RoomReservation WHERE userID = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    RoomReservation reservation = new RoomReservation();
                    reservation.setReservationCode(rs.getInt("reservationCode"));
                    reservation.setUserID(rs.getString("userID"));
                    reservation.setCheckInDate(rs.getDate("checkInDate"));
                    reservation.setCheckOutDate(rs.getDate("checkOutDate"));
                    reservation.setRoomType(rs.getString("roomType"));
                    reservation.setRoomID(rs.getString("roomID"));
                    reservation.setNumOfCustomers(rs.getInt("numOfCustomers"));
                    reservation.setTotalPrice(rs.getDouble("totalPrice"));
                    reservations.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }
    
    public RoomReservation getReservationById(int reservationCode) {
    RoomReservation reservation = null;
    String sql = "SELECT * FROM RoomReservation WHERE reservationCode = ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, reservationCode);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                reservation = new RoomReservation();
                reservation.setReservationCode(rs.getInt("reservationCode"));
                reservation.setUserID(rs.getString("userID"));
                reservation.setCheckInDate(rs.getDate("checkInDate"));
                reservation.setCheckOutDate(rs.getDate("checkOutDate"));
                reservation.setRoomType(rs.getString("roomType"));
                reservation.setRoomID(rs.getString("roomID"));
                reservation.setNumOfCustomers(rs.getInt("numOfCustomers"));
                reservation.setTotalPrice(rs.getDouble("totalPrice"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return reservation;
}


    // Update Reservation
    public boolean updateReservation(RoomReservation reservation) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RESERVATION_SQL)) {
            preparedStatement.setDate(1, (Date) reservation.getCheckInDate());
            preparedStatement.setDate(2, (Date) reservation.getCheckOutDate());
            preparedStatement.setString(3, reservation.getRoomType());
            preparedStatement.setString(4, reservation.getRoomID());
            preparedStatement.setInt(5, reservation.getNumOfCustomers());
            preparedStatement.setDouble(6, reservation.getTotalPrice());
            preparedStatement.setInt(7, reservation.getReservationCode());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // Delete Reservation
    public boolean deleteReservation(int reservationCode) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RESERVATION_SQL)) {
            preparedStatement.setInt(1, reservationCode);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
    
    
    // Add method to update a reservation
    public void updateReservationId(RoomReservation reservation) {
        String sql = "UPDATE RoomReservation SET checkInDate = ?, checkOutDate = ?, roomType = ?, roomID = ?, numOfCustomers = ?, totalPrice = ? WHERE reservationCode = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, (Date) reservation.getCheckInDate());
            stmt.setDate(2, (Date) reservation.getCheckOutDate());
            stmt.setString(3, reservation.getRoomType());
            stmt.setString(4, reservation.getRoomID());
            stmt.setInt(5, reservation.getNumOfCustomers());
            stmt.setDouble(6, reservation.getTotalPrice());
            stmt.setInt(7, reservation.getReservationCode());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add method to delete a reservation
    public void deleteReservationId(int reservationCode) {
        String sql = "DELETE FROM RoomReservation WHERE reservationCode = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservationCode);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    
    
}

