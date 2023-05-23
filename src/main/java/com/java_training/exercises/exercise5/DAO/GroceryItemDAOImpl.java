package com.java_training.exercises.exercise5.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java_training.exercises.exercise5.GroceryItem;

public class GroceryItemDAOImpl implements GroceryItemDAO<GroceryItem> {
	Connection conn;
	
	public GroceryItemDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<GroceryItem> getAllGroceries() {

		List<GroceryItem> groceries = new ArrayList<>();
		String sqlQuery = "SELECT * FROM groceries ORDER BY id ASC ";
		Statement statement = null;
		
		try {
			statement = conn.createStatement();
	        ResultSet resultSet = statement.executeQuery(sqlQuery);
	        
	        while (resultSet.next()) {
	        	GroceryItem grocery = extractGroceryFromResultSet(resultSet);
	        	groceries.add(grocery);
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
		return groceries;
	}

	@Override
	public GroceryItem getGroceryItemById(int itemId) throws SQLException {
		GroceryItem grocery = null;
		String sqlQuery = "SELECT * FROM groceries WHERE id = ?";
		try (PreparedStatement statement = conn.prepareStatement(sqlQuery)) {
            statement.setInt(1, itemId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	grocery = extractGroceryFromResultSet(resultSet);
                }
            }
        }
		return grocery;
	}

	@Override
	public boolean addToPurchaseCart(GroceryItem grocery) throws SQLException {
		boolean flag = false;
		String sqlQuery = "INSERT INTO purchase_cart (product_name, price, discount, quantity, amount) VALUES (?, ?, ?, ?, ?)";
		
		try (PreparedStatement statement = conn.prepareStatement(sqlQuery)) {
			statement.setString(1, grocery.getProductName());
            statement.setDouble(2, grocery.getPrice());
            statement.setInt(3, grocery.getDiscount());
            statement.setInt(4, grocery.getQuantity());
            statement.setDouble(5, grocery.getAmount());
            int rowsUpdated = statement.executeUpdate();
            
            flag = rowsUpdated > 0;
        }
		
		return flag;
	}

	@Override
	public List<GroceryItem> getAllPurchaseList() {
		List<GroceryItem> purchaseCart = new ArrayList<>();
		String sqlQuery = "SELECT * FROM purchase_cart ORDER BY id ASC ";
		Statement statement = null;
		
		try {
			statement = conn.createStatement();
	        ResultSet resultSet = statement.executeQuery(sqlQuery);
	        
	        while (resultSet.next()) {
	        	GroceryItem grocery = extractPurchaseItemsFromResultSet(resultSet);
	        	purchaseCart.add(grocery);
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
		return purchaseCart;
	}

	@Override
	public boolean emptyPurchaseCart() throws SQLException {
		boolean flag = false;
		String sqlQuery = "TRUNCATE purchase_cart RESTART IDENTITY";
		
		try (Statement statement = conn.createStatement()) {
			
            int rowsUpdated = statement.executeUpdate(sqlQuery);
            
            flag = rowsUpdated > 0;
        }
		
		return flag;
	}
	
	private GroceryItem extractGroceryFromResultSet(ResultSet rs) throws SQLException {
		GroceryItem grocery = new GroceryItem();

		grocery.setId( rs.getInt("id") );
		grocery.setProductName(rs.getString("product_name"));
		grocery.setPrice( rs.getDouble("price") );
		grocery.setDiscount( rs.getInt("discount") );

	    return grocery;
	}
	
	private GroceryItem extractPurchaseItemsFromResultSet(ResultSet rs) throws SQLException {
		GroceryItem grocery = new GroceryItem();
		
		grocery.setId( rs.getInt("id") );
		grocery.setProductName(rs.getString("product_name"));
		grocery.setPrice( rs.getDouble("price") );
		grocery.setDiscount( rs.getInt("discount"));
		grocery.setQuantity( rs.getInt("quantity") );
		grocery.setAmount( rs.getDouble("amount") );

	    return grocery;
	}
}	
