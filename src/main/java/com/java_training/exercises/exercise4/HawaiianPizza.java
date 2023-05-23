package com.java_training.exercises.exercise4;

public class HawaiianPizza extends PizzaBase {
	
	public HawaiianPizza() {
		this.setName("Hawaiian Pizza");
		this.setDescription("The perfect combination of sweet and savory flavors loaded on "
				+ "top of a crispy crust. Delicious melty mozzarella cheese locks in "
				+ "layers of salty bacon and juicy pineapple pieces in each slice.");
		this.setIngredients("Cheese, Tomato sauce, Bacon, Pineapple");
		this.setPrice(394.99);
		this.setDiscount(15);
	}
}
