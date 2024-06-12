import com.RoomDetails;
import com.HotelReservationDAO;
import com.RoomReservation;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateReservation")
public class UpdateReservationServlet extends HttpServlet {
    private HotelReservationDAO hotelReservationDAO;

    public void init() {
        hotelReservationDAO = new HotelReservationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationCode = Integer.parseInt(request.getParameter("reservationCode"));
        Date checkInDate = Date.valueOf(request.getParameter("checkInDate"));
        Date checkOutDate = Date.valueOf(request.getParameter("checkOutDate"));
        String roomType = request.getParameter("roomType");
        int numOfCustomers = Integer.parseInt(request.getParameter("numOfCustomers"));

        RoomDetails roomDetails = (RoomDetails) hotelReservationDAO.getRoomDetailsByType(roomType);
        if (roomDetails == null) {
            request.setAttribute("errorMessage", "Room type not found: " + roomType);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            return;
        }

        String roomID = roomDetails.getRoomID();
        double totalPrice = roomDetails.getRoomPrice() * (checkOutDate.getTime() - checkInDate.getTime()) / (1000 * 60 * 60 * 24);

        RoomReservation reservation = new RoomReservation();
        reservation.setReservationCode(reservationCode);
        reservation.setCheckInDate(checkInDate);
        reservation.setCheckOutDate(checkOutDate);
        reservation.setRoomType(roomType);
        reservation.setRoomID(roomID);
        reservation.setNumOfCustomers(numOfCustomers);
        reservation.setTotalPrice(totalPrice);

        hotelReservationDAO.updateReservation(reservation);

        response.sendRedirect("viewReservations.jsp");
    }
}
