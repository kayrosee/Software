package Software;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

/**
 * Servlet implementation class MainMenu
 */
@WebServlet("/Software/MainMenu")
public class MainMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Main Menu</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Person Selection:</h1>");
		
		//Customer
		out.println("	<form action=\"Customer\" method=\"post\">");
		out.println("	<input class=\"btn btn-primary\" type=\"submit\" name=\"submitBtn\" value=\"Customer\">");
		out.println("	</form><br>");

		out.println("	<input class=\"btn btn-primary\" type=\"submit\" name=\"submitBtn\" value=\"Deliverer\">");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Check to see if the Add New Entry form was submitted
		// We'll do so by validating the inputs
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		if (name != null && name.trim().length() > 0 &&
			message != null && message.trim().length() > 0) {
					
			// Get a reference to the Guest Book in the Servlet Context
			ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
			
			// Add a new Entry to the guest book using the name and message that were submitted
			guestbookEntries.add( new GuestBookEntry(name, message) );
			
			// Send the User (Client) back to the GuestBook page
			response.sendRedirect("GuestBook");
		}
		else
			doGet(request, response);
		
	}

}