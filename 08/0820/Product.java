package com.ssafy.java.d0820;

public class Product{
	private int pno;
	private String pname;
	private int price;
	private int qty;
	
	public Product() {}
	
	public Product(int pno, String pname, int price, int qty) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.qty = qty;
	}
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
		return String.format("Product [ 제품번호 = %s, 제품명 = %s, 가격 = %s, 재고 = %s]", pno, pname, price, qty);
	}
	
}
