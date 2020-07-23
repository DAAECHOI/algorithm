package com.ssafy.java.day4;

public class Refrigerator {
	int num;
	String name;
	int price;
	int qty;
	int L;
	
	public Refrigerator() {
		super();
	}

	public Refrigerator(int num, String name, int price, int qty, int l) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.L = l;
		this.qty = qty;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	
	public int getL() {
		return L;
	}
	public void setL(int l) {
		L = l;
	}
	
	@Override
	public String toString() {
		return "Refrigerator [제품 번호=" + num + ", 제품 이름=" + name + ", 가격=" + price + ", 수량=" + qty + ", 용량(L)=" + L + "]";
	}
	
	
}
