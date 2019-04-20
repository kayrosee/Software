import java.util.ArrayList;

public class ShoppingCart {
	ArrayList<Food> cart = new ArrayList<Food>();
	String item;
	int quantity;
	
	public ShoppingCart() {
		
	}
	
	
	//Mainly use this method to get the user's shopping cart
	public ArrayList<Food> getCart() {
		return this.cart;
	}
	
	
	public void addItem() {
		
	}
	
	//Setters and getters. ONLY FOR METHOD USE
	public void setItem(String item) {
		this.item = item;
	}
	public String getItem() {
		return this.item;
	}
	
	public void setQuantity(int quant) {
		this.quantity = quant;
	}
	public int getQuantity() {
		return this.quantity;
	}
}
