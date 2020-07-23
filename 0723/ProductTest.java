package com.ssafy.java.day4;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV[] tvs = new TV[5];
		Refrigerator[] refs = new Refrigerator[5];
		
		for(int i = 0; i < 5; i++) {
			tvs[i] = new TV();
			tvs[i].setNum(i+1);
			tvs[i].setName("tv"+i);
			tvs[i].setPrice((i+1) * 800000);
			tvs[i].setQty((i+1) * 8);
			tvs[i].setInch((i+1) * 20);
			tvs[i].setdType("LCD");
		}
		
		for(int i = 0; i < 5; i++) {
			refs[i] = new Refrigerator();
			refs[i].setNum(i+1);
			refs[i].setName("ref"+i);
			refs[i].setPrice((i+1) * 900000);
			refs[i].setQty((i+1) * 6);
			refs[i].setL((i+1) * 100);
		}
		
		for( TV tv : tvs ) {
			System.out.println( tv );
		}
		
		for( Refrigerator ref : refs ) {
			System.out.println( ref );
		}
		
	}

}
