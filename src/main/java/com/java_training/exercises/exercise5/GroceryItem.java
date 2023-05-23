package com.java_training.exercises.exercise5;

public class GroceryItem {
	int id;
	String productName;
	double price;
	int discount;
	int quantity;
	double amount;
	
	public GroceryItem() {
	}

	public GroceryItem(int id, String productName, double price, int discount, int quantity, double amount) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
