import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RestaurantSelection
 */
@WebServlet("/Software/RestaurantSelection")
public class RestaurantSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String getName(String name) {
		//Get name of restaurant
		ArrayList<String> rNames = (ArrayList<String>) getServletContext().getAttribute("restaurantNames");
		
		for (int i=0; i<rNames.size(); i++) {
			if (rNames.get(i).equals(name)) {
				return name;
			}
		}
		return null;
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//Create local array list of restaurants
		ArrayList<String> foods = new ArrayList<String>();
		
		//Prepopulate the list with names 
		foods.add("Hamburger");
		foods.add("Cheeseburger");
		foods.add("Sprite");	
		
		//Store the list of names in the Applications Scope (ServletContext)
		getServletContext().setAttribute("foods", foods);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		//String rName = "Restaurant";
		String rName = request.getParameter("name");
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>" + rName + " Order</title>");
		out.println(
				"	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>" + rName + " Order:</h1>");

		// Read our entries from the Servlet Context
		ArrayList<String> foods = (ArrayList<String>) getServletContext().getAttribute("foods");
//		ServletContext context = this.getServletContext();
//		ArrayList<CarlsMealEntry> carlsMealEntries = (ArrayList<CarlsMealEntry>) getServletContext().getAttribute("carlsMealEntries");

		String space = "\t\t\t";
		out.print("<h1>Choose the + to add items to your cart</h1>");
		out.println("<table class=\"table table-bordered table-striped table-hover\">"
				+ "<tr>"
				+ "	<th>Item</th>	"
				+ "	<th align = \"center\">Add?</th>"
				+ "</tr>");
		
		for (int i=0; i<foods.size(); i++) {
			out.println("<tr>"
					+ "		<td>" + foods.get(i) + "</td>"
					+ "		<td align = \"center\">	<a href=\"test\">+	</td>"
					+ "		<br>"
					+ "	</tr>");
		}
		out.println("</table>");
		
//		// Burgers
//		out.println("<p>Type of Burger:</p>");
//		out.println("<form action=\"action_form.php\" method=\"get\">");
//		out.println("<input type=\"text\" list =\"burgers\">");
//		out.println("<datalist id =\"burgers\" name=\"Burger:\">");
//		out.println("<option value=\"Cheese Burger\">");
//		out.println("<option value =\"Bacon Burger\">");
//		out.println("<option value =\"Hamburger\"></datalist>");
//		//out.println("<input type =\"submit\" value =\"confirm\">");
//		//out.println("</form>");
//
//		//Sides
//		out.println("<p>Type of Sides:</p>");
//		out.println("<form action=\"action_form.php\" method=\"get\">");
//		out.println("<input type=\"text\" list =\"sides\">");
//		out.println("<datalist id =\"sides\" name=\"Sides:\">");
//		out.println("<option value=\"Fries\">");
//		out.println("<option value =\"Crisp Cut Fries\"></datalist>");
//		//out.println("<input type =\"submit\" value =\"confirm\">");
//		//out.println("</form>");
//		
//		out.println("<p>Type of Drinks:</p>");
//		out.println("<form action=\"action_form.php\" method=\"get\">");
//		out.println("<input type=\"text\" list =\"drinks\">");
//		out.println("<datalist id =\"drinks\" name=\"Drinks:\">");
//		out.println("<option value=\"Lemonade\">");
//		out.println("<option value =\"Coke\">");
//		out.println("<option value =\"Sprite\"></datalist>");
//		out.println("<input type =\"submit\" value =\"confirm\">");
//		out.println("</form>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CarlsMealEntry> carlsMealEntries = (ArrayList<CarlsMealEntry>) getServletContext().getAttribute("carlsMealEntries");
		
		//Send User back to main page
		response.sendRedirect("RestaurantSelection");
		
	}

}
