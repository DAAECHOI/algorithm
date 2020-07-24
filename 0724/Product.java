package com.ssafy.java.day5;

public class Product {
	private int no;
	private String name;
	private int price;
	private int qty;
	
	public Product() {}
	
	public Product(int no, String name, int price, int qty) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", qty=");
		builder.append(qty);
		builder.append("]");
		return builder.toString();
	}
	
	
}
