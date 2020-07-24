package com.ssafy.java.day4;

public class TV {// Java Beans: 멤버 변수는 private, 거기에 접근할 수 있는  getter/setter, default 생성자
	private int num;
	private String name;
	private int price;
	private int qty;
	private int inch;
	private String dType;
	
	public TV() {}

	public TV(int num, String name, int price, int qty, int inch, String dType) {
		//생성자에서 명시적으로 this() 또는  super()를 호출하지 않으면 자동으로  super()삽입
		//super(); 생성자의 첫번째 줄에서만 사용 가능
		this.num = num;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.inch = inch;
		this.dType = dType;
	}
	
	public TV(int num, String name, int inch, String dType) {//this(): 자신의 다른 생성자 호출, 생성자의 맨 첫 줄에서만 사용 가능
		this(num, name, 0, 0, inch, dType);
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
		if(name != null)
			this.name = name;
		else
			System.out.println("이름을 입력해주세요.");
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price > 0)
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
		StringBuilder builder = new StringBuilder();
		builder.append("TV [num=");
		builder.append(num);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", qty=");
		builder.append(qty);
		builder.append(", inch=");
		builder.append(inch);
		builder.append(", dType=");
		builder.append(dType);
		builder.append("]");
		return builder.toString();
	}
	
}
