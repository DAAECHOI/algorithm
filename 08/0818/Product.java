package com.ssafy.work;

import java.io.Serializable;

public class Product implements Serializable{
	private int no;
	private String name;
	private int price;
	private int qty;
	
	public Product() {}
	
	public Product(int no, String name, int price, int qty) {
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
		return String.format("Product [ 제품번호 = %s, 제품명 = %s, 가격 = %s, 재고 = %s]", no, name, price, qty);
	}
	
}
