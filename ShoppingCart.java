package Software;
import java.util.ArrayList;

public class ShoppingCart {
	ArrayList<Food> cart = new ArrayList<Food>();
	Food item;
	int quantity;
	
	public ShoppingCart() {
	}
	public ShoppingCart(ArrayList<Food> cart, Food item) {
		this.cart = cart;
		addItem(item);
	}
	
	//Mainly use this method to get the user's shopping cart
	public ArrayList<Food> getCart() {
		return this.cart;
	}
	
	
	public void addItem(Food item) {
		cart.add(item);
	}
	
	//Setters and getters. ONLY FOR METHOD USE
	public void setItem(Food item) {
		this.item = item;
	}
	public Food getItem() {
		return this.item;
	}
	
	public void setQuantity(int quant) {
		this.quantity = quant;
	}
	public int getQuantity() {
		return this.quantity;
	}
}
