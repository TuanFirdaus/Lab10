package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.RoomReservation;
import com.HotelReservationDAO;

public final class updateReservation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    int reservationCode = Integer.parseInt(request.getParameter("reservationCode"));
    HotelReservationDAO hotelReservationDAO = new HotelReservationDAO();
    RoomReservation reservation = hotelReservationDAO.getReservationById(reservationCode);

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Update Reservation</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>Update Reservation</h2>\n");
      out.write("    <form action=\"updateReservation\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"reservationCode\" value=\"");
      out.print( reservation.getReservationCode() );
      out.write("\">\n");
      out.write("        Check-In Date: <input type=\"date\" name=\"checkInDate\" value=\"");
      out.print( reservation.getCheckInDate() );
      out.write("\" required><br>\n");
      out.write("        Check-Out Date: <input type=\"date\" name=\"checkOutDate\" value=\"");
      out.print( reservation.getCheckOutDate() );
      out.write("\" required><br>\n");
      out.write("        Room Type: \n");
      out.write("        <select name=\"roomType\" required>\n");
      out.write("            <option value=\"Single\" ");
      out.print( reservation.getRoomType().equals("Single") ? "selected" : "" );
      out.write(">Single</option>\n");
      out.write("            <option value=\"Double\" ");
      out.print( reservation.getRoomType().equals("Double") ? "selected" : "" );
      out.write(">Double</option>\n");
      out.write("            <option value=\"Deluxe\" ");
      out.print( reservation.getRoomType().equals("Deluxe") ? "selected" : "" );
      out.write(">Deluxe</option>\n");
      out.write("            <option value=\"Triple\" ");
      out.print( reservation.getRoomType().equals("Triple") ? "selected" : "" );
      out.write(">Triple</option>\n");
      out.write("            <option value=\"VIP\" ");
      out.print( reservation.getRoomType().equals("VIP") ? "selected" : "" );
      out.write(">VIP</option>\n");
      out.write("        </select><br>\n");
      out.write("        Number of Customers: <input type=\"number\" name=\"numOfCustomers\" value=\"");
      out.print( reservation.getNumOfCustomers() );
      out.write("\" required><br>\n");
      out.write("        <input type=\"submit\" value=\"Update Reservation\">\n");
      out.write("    </form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
