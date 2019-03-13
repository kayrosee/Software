package Software;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarlsJr
 */
@WebServlet("/Software/CarlsJr")
public class CarlsJr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Carls Jr Order</title>");
		out.println(
				"	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Carl's Jr Order:</h1>");

		// Read our entries from the Servlet Context
		ServletContext context = this.getServletContext();
		ArrayList<CarlsMealEntry> carlsMealEntries = (ArrayList<CarlsMealEntry>) getServletContext().getAttribute("carlsMealEntries");

		// Burgers
		out.println("<p>Type of Burger:</p>");
		out.println("<form action=\"action_form.php\" method=\"get\">");
		out.println("<input type=\"text\" list =\"burgers\">");
		out.println("<datalist id =\"burgers\" name=\"Burger:\">");
		out.println("<option value=\"Cheese Burger\">");
		out.println("<option value =\"Bacon Burger\">");
		out.println("<option value =\"Hamburger\"></datalist>");
		//out.println("<input type =\"submit\" value =\"confirm\">");
		//out.println("</form>");

		//Sides
		out.println("<p>Type of Sides:</p>");
		out.println("<form action=\"action_form.php\" method=\"get\">");
		out.println("<input type=\"text\" list =\"sides\">");
		out.println("<datalist id =\"sides\" name=\"Sides:\">");
		out.println("<option value=\"Fries\">");
		out.println("<option value =\"Crisp Cut Fries\"></datalist>");
		//out.println("<input type =\"submit\" value =\"confirm\">");
		//out.println("</form>");
		
		out.println("<p>Type of Drinks:</p>");
		out.println("<form action=\"action_form.php\" method=\"get\">");
		out.println("<input type=\"text\" list =\"drinks\">");
		out.println("<datalist id =\"drinks\" name=\"Drinks:\">");
		out.println("<option value=\"Lemonade\">");
		out.println("<option value =\"Coke\">");
		out.println("<option value =\"Sprite\"></datalist>");
		out.println("<input type =\"submit\" value =\"confirm\">");
		out.println("</form>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String burger = request.getParameter("burgers");
		String sides = request.getParameter("sides");
		String drinks = request.getParameter("drinks");
		
		ArrayList<CarlsMealEntry> carlsMealEntries = (ArrayList<CarlsMealEntry>) getServletContext().getAttribute("carlsMealEntries");
			carlsMealEntries.add(new CarlsMealEntry(burger, sides, drinks));

			// Send the User (Client) back to the GuestBook page
			response.sendRedirect("CarlsJr");

	}
}
