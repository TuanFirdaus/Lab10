import com.RoomDetails;
import com.HotelReservationDAO;
import com.RoomReservation;
import java.io.IOException;
import java.sql.Date; // Use java.sql.Date instead of java.util.Date
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tfird
 */
@WebServlet("/bookRoom")
public class BookRoomServlet extends HttpServlet {
    private HotelReservationDAO hotelReservationDAO;

    public void init() {
        hotelReservationDAO = new HotelReservationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve booking details from the request
        String userID = request.getParameter("userID");
        Date checkInDate = Date.valueOf(request.getParameter("checkInDate"));
        Date checkOutDate = Date.valueOf(request.getParameter("checkOutDate"));
        String roomType = request.getParameter("roomType");
        int numOfCustomers = Integer.parseInt(request.getParameter("numOfCustomers"));

        // Retrieve room details by room type
        RoomDetails roomDetails = (RoomDetails) hotelReservationDAO.getRoomDetailsByType(roomType);
        if (roomDetails == null) {
            request.setAttribute("errorMessage", "Room type not found: " + roomType);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            return;
        }

        String roomID = roomDetails.getRoomID();
        double totalPrice = roomDetails.getRoomPrice() * (checkOutDate.getTime() - checkInDate.getTime()) / (1000 * 60 * 60 * 24);

        RoomReservation reservation = new RoomReservation();
        reservation.setUserID(userID);
        reservation.setCheckInDate(checkInDate);
        reservation.setCheckOutDate(checkOutDate);
        reservation.setRoomType(roomType);
        reservation.setRoomID(roomID);
        reservation.setNumOfCustomers(numOfCustomers);
        reservation.setTotalPrice(totalPrice);

        hotelReservationDAO.addReservation(reservation);

        response.sendRedirect("reservationSuccess.jsp");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("bookRoom.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
