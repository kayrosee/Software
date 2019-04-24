package Software;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/Software/RestaurantSelection")
public class RestaurantSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ShoppingCart cart;
	public static String goRName;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		/*
		 * BIG RESTAURANT DATABASE GOES HERE
		 */
		
		//Create local array list of restaurants
		ArrayList<String> restaurantNames = new ArrayList<String>();
		
		readFile(restaurantNames);
		
		//Store the list of names in the Applications Scope (ServletContext)
		getServletContext().setAttribute("restaurantNames", restaurantNames);
		
		/*
		 * BIG FOOD DATABASE GOES HERE
		 */
		
		//Create local array of foods
		
		//Get reference to shopping cart
		if (cart != null) {
			System.out.println("cart isn't null, grabbing cart reference in Restaurant Selection");
			cart = (ShoppingCart)getServletContext().getAttribute("cart");
		}
		if (cart == null) { 
			System.out.println("cart is null, making a new cart in Restaurant Selection");
			cart = new ShoppingCart();
		}

		//Store shopping cart data in Applications Scope (ServletContext)
		getServletContext().setAttribute("cart", cart);
		System.out.println("first item is: " + cart.getCart());
		
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
			out.print("<a href=\"FoodSelection?name="+rName+"\">"+rName + "<br>");
			
		}
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
	
	public static void readFile(ArrayList<String> restaurantNames) {

		try {
			FileInputStream in = new FileInputStream("RestaurantDatabase.csv");
			FileOutputStream out = new FileOutputStream("new.txt");
			File file = new File("RestaurantDatabase.csv");
			
//			if (file.createNewFile()) {
//				System.out.println(file.getAbsolutePath());
//			} else {
//				System.out.println("File exists in " + file.getAbsolutePath());
//			}
			System.out.println(System.getProperty("user.dir"));
			System.out.println(System.getProperty("user.dir"));
			
			Scanner data = new Scanner(in);

			//Header
			data.nextLine();
			
			//Prepopulate the list with names 
			while (data.hasNextLine()) {
				restaurantNames.add(data.nextLine());
			}
			
			
		} catch (Exception e) {
			System.out.println("-----------------------------------");
			System.out.println(e);
		}
	}

}