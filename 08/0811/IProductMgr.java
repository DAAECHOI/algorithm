package com.ssafy.java.d0810;

import java.util.ArrayList;
import java.util.List;

public interface IProductMgr {
	
	boolean add(Product p);//상품정보를 저장

	List<Product> list();//상품정보 전체
	
	Product list(int num);//상품번호로 상품을 검색
	
	List<Product> list(String name);//상품명으로 상품을 검색
	
	List<Product> listTV();//TV정보만 검색
	
	List<Product> listRefrigerator();//Refrigerator정보만 검색

	List<Product> list400Refrigerator();//400L 이상의 Refrigerator 검색
	
	List<Product> list50TV();//50inch 이상의 TV정보만 검색
	
	boolean update(int num, int price); //상품번호와 가격을 입력받아 상품가격을 변경

	boolean delete(int num);//상품번호로 상품을 삭제
	
	int priceList();//전체 재고 상품 금액 구하기
	
}
