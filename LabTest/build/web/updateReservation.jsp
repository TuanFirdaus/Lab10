<%@ page import="com.RoomReservation" %>
<%@ page import="com.HotelReservationDAO" %>

<%
    int reservationCode = Integer.parseInt(request.getParameter("reservationCode"));
    HotelReservationDAO hotelReservationDAO = new HotelReservationDAO();
    RoomReservation reservation = hotelReservationDAO.getReservationById(reservationCode);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Reservation</title>
</head>
<body>
    <h2>Update Reservation</h2>
    <form action="updateReservation" method="post">
        <input type="hidden" name="reservationCode" value="<%= reservation.getReservationCode() %>">
        Check-In Date: <input type="date" name="checkInDate" value="<%= reservation.getCheckInDate() %>" required><br>
        Check-Out Date: <input type="date" name="checkOutDate" value="<%= reservation.getCheckOutDate() %>" required><br>
        Room Type: 
        <select name="roomType" required>
            <option value="Single" <%= reservation.getRoomType().equals("Single") ? "selected" : "" %>>Single</option>
            <option value="Double" <%= reservation.getRoomType().equals("Double") ? "selected" : "" %>>Double</option>
            <option value="Deluxe" <%= reservation.getRoomType().equals("Deluxe") ? "selected" : "" %>>Deluxe</option>
            <option value="Triple" <%= reservation.getRoomType().equals("Triple") ? "selected" : "" %>>Triple</option>
            <option value="VIP" <%= reservation.getRoomType().equals("VIP") ? "selected" : "" %>>VIP</option>
        </select><br>
        Number of Customers: <input type="number" name="numOfCustomers" value="<%= reservation.getNumOfCustomers() %>" required><br>
        <input type="submit" value="Update Reservation">
    </form>
</body>
</html>
