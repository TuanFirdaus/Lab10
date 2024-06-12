<%-- 
    Document   : bookRoom
    Created on : 12 Jun 2024, 7:32:33 am
    Author     : tfird
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Book a Room</title>
    </head>
    <body>
        <h2>Book a Room</h2>
        <form action="BookRoomServlet" method="post">
            User ID: <input type="text" name="userID" required><br>
            Check In Date: <input type="date" name="checkInDate" required><br>
            Check Out Date: <input type="date" name="checkOutDate" required><br>
            Room Type: <select name="roomType">
                <option value="Single">Single</option>
                <option value="Double">Double</option>
                <option value="Deluxe">Deluxe</option>
                <option value="Triple">Triple</option>
                <option value="VIP">VIP</option>
            </select><br>
            Number of Customers: <input type="number" name="numOfCustomers" required><br>
            <input type="submit" value="Book Room">
        </form>
    </body>
</html>

