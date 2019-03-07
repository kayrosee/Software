package Software;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab5.TodoEntry;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/Software/Customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Customer Resturant</title>");
		out.println(
				"	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Choose Where to Eat:</h1>");

		// Carls Jr
		out.println("	<form action=\"CarlsJr\" method=\"post\">");
		out.println("	<input class=\"btn btn-primary\" type=\"submit\" name=\"submitBtn\" value=\"Carl's Jr\"></form><br>");

		//El Pollo Loco
		out.println("	<form action=\"ElPolloLoco\" method=\"post\">");
		out.println("	<input class=\"btn btn-primary\" type=\"submit\" name=\"submitBtn\" value=\"El Pollo Loco\"></form><br>");

		// Johny's Kitchen
		out.println("	<form action=\"JohnysKitchen\" method=\"post\">");
		out.println("	<input class=\"btn btn-primary\" type=\"submit\" name=\"submitBtn\" value=\"Johny's Kitchen\">");
		out.println("	</form>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Check to see if the Add New Entry form was submitted
		// We'll do so by validating the inputs

		String todo = request.getParameter("todo");

		if (todo != null && todo.trim().length() > 0) {

			ArrayList<TodoEntry> todoEntries = (ArrayList<TodoEntry>) getServletContext().getAttribute("todoEntries");

			// Add a new Entry to the guest book using the name and message that were
			// submitted

			todoEntries.add(new TodoEntry(todo));

			// Send the User (Client) back to the GuestBook page
			response.sendRedirect("Todo");
		} else
			doGet(request, response);

	}

}