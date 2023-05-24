package com.java_training.exercises.exercise7.DAO;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemDAO<T> {
	List<T> getAllOrders();
	
	T getOrderItemByCode(String code) throws SQLException;
}