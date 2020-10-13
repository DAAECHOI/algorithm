package com.ssafy.java.d0812.hw;

import java.util.ArrayList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr{
	
	private List<Product> products = new ArrayList<>();
	
	private ProductMgrImpl() {};
	
	private static ProductMgrImpl mgr = new ProductMgrImpl();
	
	public static ProductMgrImpl getProductMgr() {
		return mgr;
	}
	
	@Override
	public boolean add(Product p) throws DuplicateException{ //상품정보를 저장
		for(Product ps: products) {
			if(ps.getNo() == p.getNo()) {
			    throw new DuplicateException(p.getNo());
			}
		}
		return products.add(p);
	}
	
	@Override
	public List<Product> list() { //상품정보 전체
		return products;
	}
	
	@Override
	public Product list(int num) throws CodeNotFoundException{ //상품번호로 상품을 검색
		for(Product ps: products) {
			if(ps.getNo() == num) {
				return ps;
			}
		}
		throw new CodeNotFoundException(num);
	}
	
	@Override
	public List<Product> list(String name) { //상품명으로 상품을 검색
		List<Product> tmp = new ArrayList<>();
		for(Product ps: products) {
			if(ps.getName().contains(name)) {
				tmp.add(ps);
			}
		}
		return tmp;
	}
	
	@Override
	public List<Product> listTV() { //TV정보만 검색
		List<Product> tmp = new ArrayList<>();
		for(Product ps: products) {
			if(ps instanceof TV) {
				tmp.add(ps);
			}
		}
		return tmp;
	}
	
	@Override
	public List<Product> listRefrigerator() { //Refrigerator정보만 검색
		List<Product> tmp = new ArrayList<>();
		for(Product ps: products) {
			if(ps instanceof Refrigerator) {
				tmp.add(ps);
			}
		}
		return tmp;
	}

	@Override
	public List<Product> list400Refrigerator() throws ProductNotFoundException { //400L 이상의 Refrigerator 검색
		List<Product> tmp = new ArrayList<>();
		for(Product ps: products) {
			if(ps instanceof Refrigerator) {
				Refrigerator rf = (Refrigerator)ps;
				if(rf.getL() >= 400) {
					tmp.add(ps);
				}
			}
		}
		if(tmp.size() == 0) {
		    throw new ProductNotFoundException("400L 이상");
		}
		else {
		    return tmp;
		}
	}

	@Override
	public List<Product> list50TV() throws ProductNotFoundException { //50inch 이상의 TV정보만 검색
		List<Product> tmp = new ArrayList<>();
		for(Product ps: products) {
			if(ps instanceof TV) {
				TV tv = (TV)ps;
				if(tv.getInch() >= 50) {
					tmp.add(ps);
				}
			}
		}
		if(tmp.size() == 0) {
            throw new ProductNotFoundException("50inch 이상");
        }
        else {
            return tmp;
        }
	}
	
	@Override
	public boolean update(int num, int price) {
		for(Product ps: products) {
			if(ps.getNo() == num) {
				ps.setPrice(price);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(int num) { //상품번호로 상품을 삭제
		int size = products.size();
		for(int i = 0; i < size; i++) {
			if(products.get(i).getNo() == num) {
				products.remove(i);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int priceList() { //전체 재고 상품 금액 구하기
		int sum = 0;
		for(Product ps: products) {
			sum += ps.getPrice();
		}
		return sum;
	}
	
}
