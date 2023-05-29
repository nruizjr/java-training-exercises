package com.java_training.exercises.exercise7.DAO;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemDAO<T> {
	List<T> getAllOrders();
	
	List<T> getOrdersByRegion(String region);
	
	T getOrderItemByCode(String code) throws SQLException;
	
	boolean updateUnitCost(T t) throws SQLException;
}
