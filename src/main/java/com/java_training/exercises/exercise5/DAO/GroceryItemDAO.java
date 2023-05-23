package com.java_training.exercises.exercise5.DAO;

import java.sql.SQLException;
import java.util.List;

public interface GroceryItemDAO<T> {
	List<T> getAllGroceries();
	
	List<T> getAllPurchaseList();
	
	T getGroceryItemById(int itemId) throws SQLException;
	
	boolean addToPurchaseCart(T t) throws SQLException;
	
	boolean emptyPurchaseCart() throws SQLException;
}
