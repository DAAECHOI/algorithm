package com.ssafy.java.d0810;

public class TV extends Product{
	
	private int inch;
	private String dType;
	
	public TV() {}

	public TV(int no, String name, int price, int qty, int inch, String dType) {
		super(no, name, price, qty);
		this.inch = inch;
		this.dType = dType;
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
		return String.format("TV [ %s, 인치 = %s, 디스플레이 = %s ]", super.toString(), inch, dType);
	}

	
}
