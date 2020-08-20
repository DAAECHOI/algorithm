package com.ssafy.java.d0820;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTest {
	public static void main(String[] args) {
		ProductDAO dao = ProductDAO.getDao();

		//상품 정보 저장
//		Product prd1 = new Product(1, "좋은 티비", 1000000, 5);
//		dao.insertProduct(prd1);
//			
//		Product prd2 = new Product(2, "보리 티비", 500000, 10);
//		dao.insertProduct(prd2);
//		
//		Product prd3 = new Product(4, "보리 냉장고", 900000, 8);
//		dao.insertProduct(prd3);
			
		//상품 전체 정보 검색
		List<Product> products = dao.listProduct();
		System.out.println(products);
		
		//상품명 검색
//		String pname = "티비";
//		List<Product> products = dao.searchProductPname(pname);
//		System.out.println(products);
		
		//상품 가격 검색
//		int price = 500000;
//		List<Product> products = dao.searchProductPrice(price);
//		System.out.println(products);
		
		//상품 번호 검색
//		int price = 2;
//		System.out.println(dao.searchProductPno(price));
		
		//상품 번호 삭제
//		int pno = 1;
//		dao.deleteProductPno(pno);

		//제품번호 검색으로 가격 업데이트
//		int pno = 1;
//		int price = 200000;
//		dao.motifyProductPrice(pno, price);
			
	}
}
