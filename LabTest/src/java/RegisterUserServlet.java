import com.UserProfile;
import com.HotelReservationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tfird
 */
@WebServlet("/")
public class RegisterUserServlet extends HttpServlet {

       private HotelReservationDAO hotelReservationDAO;

    public void init() {
        hotelReservationDAO = new HotelReservationDAO();
    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user details from the request
        String userID = request.getParameter("userID");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String contactNo = request.getParameter("contactNo");
        String idNumber = request.getParameter("idNumber");
        int age = 0;
        if(request.getParameter("age") != null && !request.getParameter("age").isEmpty()){
            age = Integer.parseInt(request.getParameter("age"));
        }
        String address = request.getParameter("address");

        // Create a new user profile
        UserProfile user = new UserProfile();
        user.setUserID(userID);
        user.setUserName(userName);
        user.setGender(gender);
        user.setContactNo(contactNo);
        user.setIdNumber(idNumber);
        user.setAge(age);
        user.setAddress(address);

        // Add the user to the database
        hotelReservationDAO.addUser(user);

        // Redirect to registration success page
        response.sendRedirect("registrationSuccess.jsp");
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}