public class CarlsMealEntry {
	static int count = 0;

	int numOfMeals;
	String burger;
	String side;
	String drink;

	public  CarlsMealEntry(String burger,String side, String drink) {
			super();
			this.burger = burger;
			this.side = side;
			this.drink = drink;
			this.numOfMeals = count++;
		}

	public int getNumOfMeals() {
		return numOfMeals;
	}

	public void setNumOfMeals(int numOfTodo) {
		this.numOfMeals = numOfTodo;
	}

	public String getBurger() {
		return burger;
	}

	public void setBurger(String burger) {
		this.burger = burger;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

}
