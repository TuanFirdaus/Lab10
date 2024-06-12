import com.HotelReservationDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DeleteReservationServlet extends HttpServlet {
    private HotelReservationDAO hotelReservationDAO;

    public void init() {
        hotelReservationDAO = new HotelReservationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationCode = Integer.parseInt(request.getParameter("reservationCode"));
        hotelReservationDAO.deleteReservation(reservationCode);
        response.sendRedirect("viewReservations.jsp");
    }
}
