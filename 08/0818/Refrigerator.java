package com.ssafy.work;

import java.io.Serializable;

public class Refrigerator extends Product implements Serializable{
	private int L;
	
	public Refrigerator() {}

	public Refrigerator(int no, String name, int price, int qty, int l) {
		super(no, name, price, qty);
		this.L = l;
	}

	public int getL() {
		return L;
	}
	public void setL(int l) {
		this.L = l;
	}

	@Override
	public String toString() {
		return String.format("Refrigerator [ %s, 리터 = %s ]", super.toString(), L);
	}
	
	
	
}
