package com.java_training.exercises.exercise7.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java_training.exercises.exercise7.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO<OrderItem> {
	Connection conn;
	
	public OrderItemDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<OrderItem> getAllOrders() {
		List<OrderItem> orders = new ArrayList<>();
		String sqlQuery = "SELECT * FROM exercises_table ORDER BY id ASC ";
		Statement statement = null;
		
		try {
			statement = conn.createStatement();
	        ResultSet resultSet = statement.executeQuery(sqlQuery);
	        
	        while (resultSet.next()) {
	        	OrderItem order = extractOrderFromResultSet(resultSet);
	        	orders.add(order);
	        }
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					System.err.println(ex.getMessage());
				}
			}
		}
		return orders;
	}

	@Override
	public OrderItem getOrderItemByCode(String code) throws SQLException {
		OrderItem order = null;
		String sqlQuery = "SELECT * FROM exercises_table WHERE code = ?";
		try (PreparedStatement statement = conn.prepareStatement(sqlQuery)) {
            statement.setString(1, code);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	order = extractOrderFromResultSet(resultSet);
                }
            }
        }
		return order;
	}
	
	private OrderItem extractOrderFromResultSet(ResultSet rs) throws SQLException {
		OrderItem order = new OrderItem();
		
		order.setId(rs.getInt("id"));
		order.setCode(rs.getString("code"));
		order.setOrder_date(rs.getDate("order_date"));
		order.setRegion(rs.getString("region"));
		order.setRep(rs.getString("rep"));
		order.setItem(rs.getString("item"));
		order.setUnits(rs.getInt("units"));
		order.setUnit_cost(rs.getDouble("unit_cost"));
		order.setTotal(rs.getDouble("total"));

	    return order;
	}

}
