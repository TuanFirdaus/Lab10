import com.HotelReservationDAO;
import com.RoomReservation;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewReservations")
public class ViewReservationsServlet extends HttpServlet {
    private HotelReservationDAO hotelReservationDAO;

    public void init() {
        hotelReservationDAO = new HotelReservationDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        List<RoomReservation> reservations = hotelReservationDAO.getReservationsByUserID(userID);
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("viewReservations.jsp").forward(request, response);
    }
}
