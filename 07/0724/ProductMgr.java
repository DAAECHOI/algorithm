package com.ssafy.java.day5;

public class ProductMgr {
	Product[] products = new Product[100];
	private int size;
	
	private ProductMgr() {};
	
	private static ProductMgr mgr = new ProductMgr();
	
	//*************************************
	public static ProductMgr getProductMgr() {
		return mgr;
	}
	
	public void add(Product p) {
		boolean addCheck = true;
		for(int i = 0; i < size; i++) {
			if(products[i].getNo() == p.getNo()) {
				addCheck = false;
				size++;
				System.out.println("제품 번호 "+ p.getNo() + " 은/는 이미 저장된 상품입니다.");
				break;
			}
		}
		if(addCheck) {
			products[size++] = p;
			System.out.println(p.getName() + " 이/가 저장되었습니다.");
		}
	}
	
	public void list() {
		System.out.println("전체 상품 리스트 입니다.");
		for(int i = 0; i < size; i++) {
			System.out.println(products[i]);
		}
	}
	
	public void list(int num) {
		for(int i = 0; i < size; i++) {
			if(products[i].getNo() == num) {
				System.out.println("제품번호 " + num + "에 해당하는 상품입니다.");
				System.out.println(products[i]);
				break;
			}
		}
	}
	
	public void delete(int num) {
		boolean delCheck = false;
		for(int i = 0; i < size; i++) {
			if(products[i].getNo() == num) {
				//*************************************
				size--;
				products[i] = products[size];
				delCheck = true;
				System.out.println("제품번호 " + num + "이 삭제되었습니다.");
				break;
			}
		}
		if(!delCheck) {
			System.out.println("제품번호 " + num + "은 없는 상품입니다.");
		}
	}
	
	public void priceList(int price) {
		int cnt = 0;
		for(int i = 0; i < size; i++) {
			if(products[i].getPrice() <= price) {
				cnt++;
			}
		}
		Product[] prod = new Product[cnt];
		cnt = 0;
		for(int i = 0; i < size; i++) {
			if(products[i].getPrice() <= price) {
				//****************************
				prod[cnt++] = products[i];
			}
		}
		System.out.println(price + "원 이하에 해당하는 상품 리스트 입니다.");
		for(int i = 0; i < prod.length; i++) {
			System.out.println(prod[i]);
		}
	}
	
}
