import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
@WebServlet("/Software/FoodSelection")
public class FoodSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String rName;
    
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
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		//String rName = "Restaurant";
		rName = request.getParameter("name");
		
		//Create local array list of restaurants
		ArrayList<Food> foods = new ArrayList<Food>();
		
		readFile(foods);

		//Store the list of names in the Applications Scope (ServletContext)
//		getServletContext().setAttribute("foods", foods);
		
		
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

		String space = "\t\t\t";
		out.print("<h1>Choose the + to add items to your cart</h1>");
		out.println("<table class=\"table table-bordered table-striped table-hover\">"
				+ "<tr>"
				+ "	<th>Item</th>	"
				+ "	<th>Cost</th>	"
				+ "	<th align = \"center\">Add?</th>"
				+ "</tr>");
		
		for (int i=0; i<foods.size(); i++) {
			out.println("<tr>"
					+ "		<td>" + foods.get(i).name + "</td>"
					+ "		<td>" + foods.get(i).cost + "</td>"	
					+ "		<td align = \"center\">	<a href=\"test\">+	</td>"
					+ "		<br>"
					+ "	</tr>");
		}
		out.println("</table>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CarlsMealEntry> carlsMealEntries = (ArrayList<CarlsMealEntry>) getServletContext().getAttribute("carlsMealEntries");
		
		//Send User back to main page
		response.sendRedirect("RestaurantSelection");
		
	}
	
	public static void readFile(ArrayList<Food> foods) {

		try {
			FileInputStream in = new FileInputStream("FoodDatabase.csv");
			FileOutputStream out = new FileOutputStream("new.txt");
			File file = new File("FoodDatabase.csv");
			
			if (file.createNewFile()) {
				System.out.println(file.getAbsolutePath());
			} else {
				System.out.println("File exists in " + file.getAbsolutePath());
			}
			
			Scanner data = new Scanner(in);

			//Header
			System.out.println(data.nextLine());
			
			//Prepopulate the list with names 
			int counter = 0;
			while (data.hasNextLine()) {
				String line = data.nextLine();
				String[] list = line.split(",");
				
				if (rName.equals(list[0])) {
					foods.add(new Food(list[0], list[1], list[2]));	
					foods.get(counter).setCost(list[2]);

					counter++;
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println("-----------------------------------");
			System.out.println(e);
		}
	}

}
