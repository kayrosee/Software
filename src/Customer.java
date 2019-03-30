import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/Software/Customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		/*
		 * BIG RESTAURANT DATABASE GOES HERE
		 */
		
		//Create local array list of restaurants
		ArrayList<String> restaurantNames = new ArrayList<String>();
		
		//Prepopulate the list with names 
		restaurantNames.add("Carl\'s Jr");
		restaurantNames.add("El Pollo Loco");
		restaurantNames.add("Johnny\'s Kitchen");	
		
		//Store the list of names in the Applications Scope (ServletContext)
		getServletContext().setAttribute("restaurantNames", restaurantNames);
		
		/*
		 * BIG FOOD DATABASE GOES HERE
		 */
		
		//Create local array of foods
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> restaurantNames = (ArrayList<String>) getServletContext().getAttribute("restaurantNames");
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Customer Resturant</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Choose Where to Eat:</h1>");

		for (String rName : (ArrayList<String>) getServletContext().getAttribute("restaurantNames")) {
//			out.println("	<form action=\"RestaurantSelection?name="+rName+"\" method=\"post\">"
//					+ "		<input class=\"btn btn-primary\" type=\"submit\" name=\"submitBtn\" value="+ rName +"></form><br>");
			out.print("<a href=\"RestaurantSelection?name="+rName+"\">"+rName + "<br>");
		
		}
		
//		// Carls Jr
//		out.println("	<form action=\"RestaurantSelection\" method=\"post\">");
//		out.println("	<input class=\"btn btn-primary\" type=\"submit\" name=\"submitBtn\" value=\"Carl's Jr\"></form><br>");
//
//		// El Pollo Loco
//		out.println("	<form action=\"RestaurantSelection\" method=\"post\">");
//		out.println("	<input class=\"btn btn-primary\" type=\"submit\" name=\"submitBtn\" value=\"El Pollo Loco\"></form><br>");
//
//		// Johny's Kitchen
//		out.println("	<form action=\"RestaurantSelection\" method=\"post\">");
//		out.println("	<input class=\"btn btn-primary\" type=\"submit\" name=\"submitBtn\" value=\"Johny's Kitchen\">");
//		out.println("	</form>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);

	}

}