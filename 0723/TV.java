package com.ssafy.java.day4;

public class TV {
	private int num;
	private String name;
	private int price;
	private int qty;
	private int inch;
	private String dType;
	
	public TV() {
		super();
	}

	public TV(int num, String name, int price, int inch, String dType) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.inch = inch;
		this.dType = dType;
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
	
	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getdType() {
		return dType;
	}

	public void setdType(String dType) {
		this.dType = dType;
	}

	@Override
	public String toString() {
		return "TV [제품 번호=" + num + ", 제품 이름=" + name + ", 가격=" + price + ", 수량=" + qty + ", 인치=" + inch + ", 디스플레이 타입=" + dType + "]";
	}
	
	
}
