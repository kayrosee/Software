
public class Food {
	String restaurant;
	String name;
	String cost;
	
	public Food(String r, String n, String c) {
		this.restaurant = r;
		this.name = n;
		this.cost = cost;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return (this.restaurant + " " + this.cost + " " + this.name);
	}
	
}
