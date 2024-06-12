<%@ page import="java.util.List" %>
<%@ page import="com.RoomReservation" %>
<%@ page import="com.HotelReservationDAO" %>

<%
    String userID = request.getParameter("userID");
    HotelReservationDAO hotelReservationDAO = new HotelReservationDAO();
    List<RoomReservation> reservations = hotelReservationDAO.getReservationsByUserID(userID);
%>

<!DOCTYPE html>
<html>
<head>
    <title>View Reservations</title>
</head>
<body>
    <h2>Your Reservations</h2>
    <table border="1">
        <tr>
            <th>Reservation Code</th>
            <th>Check-In Date</th>
            <th>Check-Out Date</th>
            <th>Room Type</th>
            <th>Number of Customers</th>
            <th>Total Price</th>
            <th>Actions</th>
        </tr>
        <%
            for (RoomReservation reservation : reservations) {
        %>
        <tr>
            <td><%= reservation.getReservationCode() %></td>
            <td><%= reservation.getCheckInDate() %></td>
            <td><%= reservation.getCheckOutDate() %></td>
            <td><%= reservation.getRoomType() %></td>
            <td><%= reservation.getNumOfCustomers() %></td>
            <td><%= reservation.getTotalPrice() %></td>
            <td>
                <form action="updateReservation.jsp" method="get">
                    <input type="hidden" name="reservationCode" value="<%= reservation.getReservationCode() %>">
                    <input type="submit" value="Update">
                </form>
                <form action="deleteReservation" method="post" onsubmit="return confirm('Are you sure you want to delete this reservation?');">
                    <input type="hidden" name="reservationCode" value="<%= reservation.getReservationCode() %>">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
