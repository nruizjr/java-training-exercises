package com.java_training.exercises.exercise7;

import java.util.Date;

public class OrderItem {
	int id;
	String code;
	Date order_date;
	String region;
	String rep;
	String item;
	int units;
	double unit_cost;
	double total;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem(int id, String code, Date order_date, String region, String rep, String item, int units,
			double unit_cost, double total) {
		super();
		this.id = id;
		this.code = code;
		this.order_date = order_date;
		this.region = region;
		this.rep = rep;
		this.item = item;
		this.units = units;
		this.unit_cost = unit_cost;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getUnit_cost() {
		return unit_cost;
	}

	public void setUnit_cost(double unit_cost) {
		this.unit_cost = unit_cost;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
