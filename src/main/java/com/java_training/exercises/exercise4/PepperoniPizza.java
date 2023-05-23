package com.java_training.exercises.exercise4;

public class PepperoniPizza extends PizzaBase {
	public PepperoniPizza() {
		this.setName("Pepperoni Pizza");
		this.setDescription("A classic pizza option and is one of the most well-loved pizzas for a reason – "
				+ "something about the combination of pepperoni, tomato sauce and cheese "
				+ "creates a flavour sensation unlike anything else.");
		this.setIngredients("Cheese, Tomato sauce, Pepperoni");
		this.setPrice(344.99);
		this.setDiscount(5);
	}
}