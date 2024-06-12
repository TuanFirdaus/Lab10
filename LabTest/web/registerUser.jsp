<%-- 
    Document   : registerUser
    Created on : 12 Jun 2024, 7:32:11 am
    Author     : tfird
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register User</title>
    </head>
    <body>
        <h2>Register User</h2>
        <form action="RegisterUserServlet" method="post">
            User ID (Email): <input type="email" name="userID" required><br>
            User Name: <input type="text" name="userName" required><br>
            Gender: <select name="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select><br>
            Contact No: <input type="text" name="contactNo" required><br>
            ID (Mykad/Passport): <input type="text" name="idNumber" required><br>
            Age: <input type="number" name="age" required><br>
            Address: <textarea name="address" required></textarea><br>
            <input type="submit" value="Register">
        </form>
    </body>
</html>


