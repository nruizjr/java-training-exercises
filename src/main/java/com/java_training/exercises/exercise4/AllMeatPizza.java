package com.java_training.exercises.exercise4;

public class AllMeatPizza extends PizzaBase {
	public AllMeatPizza() {
		this.setName("All Meat Pizza");
		this.setDescription("This pizza is packed full of ground beef, sausage, pepperoni, "
				+ "and bacon to satisfy every meat lovers out there.");
		this.setIngredients("Cheese, Tomato sauce, Ground beef, Sausage, Pepperoni, Bacon");
		this.setPrice(479.99);
		this.setDiscount(10);
	}
}
