package com.ssafy.java.day5;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProductMgr mgr = ProductMgr.getProductMgr();
		
		System.out.println("<<< 상품 관리 프로그램 >>>");
		
		while(true) {
			System.out.println("1. 상품 정보 입력");
			System.out.println("2. 전체 상품 검색");
			System.out.println("3. 상품 번호 검색");
			System.out.println("4. 상품 정보 삭제");
			System.out.println("5. 특정가격 이하의 상품 검색");
			System.out.println("0. 종료");
			System.out.print("원하는 번호를 선택하세요.");
			
			int input = sc.nextInt();
			if(input == 0)
				break;
			else if(input == 1) {
				System.out.print("상품 번호를 입력하세요.");
				int no = sc.nextInt();
				System.out.print("상품 이름을 입력하세요.");
				String name = sc.next();
				System.out.print("가격을 입력하세요.");
				int price = sc.nextInt();
				System.out.print("수량을 입력하세요.");
				int qty = sc.nextInt();
				
				Product prod = new Product(no, name, price, qty);
				
				mgr.add(prod);
			}
			else if(input == 2) {
				mgr.list();
			}
			else if(input == 3) {
				System.out.print("검색하고 싶은 상품 번호를 입력하세요.");
				int no = sc.nextInt();
				mgr.list(no);
				
			}
			else if(input == 4) {
				System.out.print("삭제할 상품 번호를 입력하세요.");
				int no = sc.nextInt();
				mgr.delete(no);
			}
			else if(input == 5) {
				System.out.print("검색하고 싶은 상품의 가격을 입력하세요.");
				int price = sc.nextInt();
				mgr.priceList(price);
			}
			
		}
//		
//		Product prd1 = new Product(1,"냉장고",1000000,5);
//		Product prd2 = new Product(2,"TV",500000,10);
//		Product prd3 = new Product(3,"전자레인지",800000,7);
//		Product prd4 = new Product(4,"에어컨",700000,8);
//		
//		mgr.add(prd1);
//		mgr.add(prd2);
//		mgr.add(prd3);
//		mgr.add(prd4);
//		
//		System.out.println();
//		mgr.list();
//
//		mgr.list(2);
//		
//		mgr.priceList(800000);
//		
//		mgr.delete(3);
//		
//		mgr.list();
		
	}

}
