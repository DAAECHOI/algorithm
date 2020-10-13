package com.ssafy.work;

import java.util.List;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
		IProductMgr mgr = ProductMgrImpl.getProductMgr();
//		
//		System.out.println("<<< 상품 관리 프로그램 >>>");
//		
//		while(true) {
//			List<Product> products;
//			Product product;
//			
//			System.out.println("1. 상품 정보 입력");
//			System.out.println("2. 전체 상품 검색");
//			System.out.println("3. 상품 번호 검색");
//			System.out.println("4. 상품명 검색");
//			System.out.println("5. 전체 TV 검색");
//			System.out.println("6. 전체 Refrigerator 검색");
//			System.out.println("7. 400L이상의 Refrigerator 검색");
//			System.out.println("8. 50inch TV 검색");
//			System.out.println("9. 상품 가격 변경");
//			System.out.println("10. 상품 정보 삭제");
//			System.out.println("11. 전체 재고 상품 금액");
//			System.out.println("0. 종료");
//			System.out.print("원하는 번호를 선택하세요.");
//			
//			int input = sc.nextInt();
//			if(input == 0) {
//				break;
//			}
//			else if(input == 1) {
//				System.out.print("TV는 1번, Refrigerator는 2번을 선택하세요.");
//				int type = sc.nextInt();
//				System.out.print("상품 번호를 입력하세요.");
//				int no = sc.nextInt();
//				System.out.print("상품 이름을 입력하세요.");
//				String name = sc.next();
//				System.out.print("가격을 입력하세요.");
//				int price = sc.nextInt();
//				System.out.print("수량을 입력하세요.");
//				int qty = sc.nextInt();
//				
//				Product p;
//				if(type == 1) {
//					System.out.print("인치를 입력하세요.");
//					int inch = sc.nextInt();
//					System.out.print("디스플레이 타입을 입력하세요.");
//					String dType = sc.next();
//					p = new TV(no, name, price, qty, inch, dType);
//				}
//				else {
//					System.out.print("리터를 입력하세요.");
//					int L = sc.nextInt();
//					p = new Refrigerator(no, name, price, qty, L);
//				}
//				
//				try {
//		            mgr.add(p);
//		            System.out.println(p.getName() + "이/가 저장되었습니다.");
//		        } catch (DuplicateException e2) {
//		            e2.printStackTrace();
//		        }
//			}
//			else if(input == 2) {
//				System.out.println("전체 상품 리스트입니다.");
//				products = mgr.list();
//				System.out.println(products);
//			}
//			else if(input == 3) {
//				System.out.print("검색하고 싶은 상품 번호를 입력하세요.");
//				int no = sc.nextInt();
//				try {
//		            product = mgr.list(no);
//		            System.out.println(no + "에 해당하는 상품입니다.");
//		            System.out.println(product);
//		        } catch (CodeNotFoundException e1) {
//		            e1.printStackTrace();
//		        }
//			}
//			else if(input == 4) {
//				System.out.print("검색하고 싶은 상품명을 입력하세요.");
//				String name = sc.next();
//				products = mgr.list(name);
//				if(!products.isEmpty()) {
//					System.out.println(name + "에 해당하는 상품 리스트입니다.");
//					System.out.println(products);
//				}
//				else {
//					System.out.println(name + "에 해당하는 상품이 없습니다.");
//				}
//			}
//			else if(input == 5) {
//				System.out.print("전체 TV 리스트입니다.");
//				products = mgr.listTV();
//				System.out.println(products);
//			}
//			else if(input == 6) {
//				System.out.print("전체 Refrigerator 리스트입니다.");
//				products = mgr.listRefrigerator();
//				System.out.println(products);
//			}
//			else if(input == 7) {
//			    try {
//		            products = mgr.list400Refrigerator();
//		          System.out.println("400L 이상의  Refrigerator 리스트입니다.");
//		            System.out.println(products);
//		        } catch (ProductNotFoundException e) {
//		            e.printStackTrace();
//		        }
//			}
//			else if(input == 8) {
//			    try {
//		            products = mgr.list50TV();
//		            System.out.println("50inch 이상의 TV 리스트입니다.");
//		            System.out.println(products);
//		        } catch (ProductNotFoundException e) {
//		            e.printStackTrace();
//		        }
//			}
//			else if(input == 9) {
//				System.out.print("변경하고 싶은 상품번호를 입력해주세요.");
//				int no = sc.nextInt();
//				System.out.print("변경할 가격을 입력해주세요.");
//				int price = sc.nextInt();
//				if(mgr.update(no, price)) {
//					System.out.println(no + "번이 " + price+ "원으로 변경되었습니다.");
//				}
//				else {
//					System.out.println(no + "번에 해당하는 상품이 없습니다.");
//				}
//			}
//			else if(input == 10) {
//				System.out.print("삭제할 상품 번호를 입력하세요.");
//				int no = sc.nextInt();
//				if(mgr.delete(no)) {
//					System.out.println(no + "번이 삭제되었습니다.");
//				}
//				else {
//					System.out.println(no + "번에 해당하는 상품이 없습니다.");
//				}
//			}
//			else if(input == 11) {
//				System.out.print("전체 재고 상품의 금액은 " + mgr.priceList() + "원 입니다.");
//			}
//		}
		
		List<Product> products;
		Product product;
		
		Product prd1 = new TV(1, "좋은 티비", 1000000, 5, 50, "LED");
		Product prd2 = new TV(1, "어디 티비", 500000, 10, 55, "LED");
		Product prd3 = new TV(22, "보리 티비", 900000, 3, 40, "LED");
		Product prd4 = new Refrigerator(44, "어디 냉장고", 700000, 8, 300);
		Product prd5 = new Refrigerator(5, "보리 냉장고", 600000, 2, 300);
		
		try {
            mgr.add(prd1);
            System.out.println(prd1.getName() + "이/가 저장되었습니다.");
        } catch (DuplicateException e1) {
            e1.printStackTrace();
        }
		
		try {
            mgr.add(prd2);
            System.out.println(prd2.getName() + "이/가 저장되었습니다.");
        } catch (DuplicateException e2) {
            e2.printStackTrace();
        }
		
		try {
            mgr.add(prd3);
            System.out.println(prd3.getName() + "이/가 저장되었습니다.");
        } catch (DuplicateException e3) {
            e3.printStackTrace();
        }
		try {
            mgr.add(prd4);
            System.out.println(prd4.getName() + "이/가 저장되었습니다.");
        } catch (DuplicateException e4) {
            e4.printStackTrace();
        }
		try {
            mgr.add(prd5);
            System.out.println(prd5.getName() + "이/가 저장되었습니다.");
        } catch (DuplicateException e5) {
            e5.printStackTrace();
        }
		
		System.out.println("전체 상품 리스트입니다.");
		products = mgr.list();
		System.out.println(products);
		
		int no = 22;
		try {
            product = mgr.list(no);
            System.out.println(no + "에 해당하는 상품입니다.");
            System.out.println(product);
        } catch (CodeNotFoundException e1) {
            e1.printStackTrace();
        }
		
		no = 11;
		try {
            product = mgr.list(no);
            System.out.println(no + "에 해당하는 상품입니다.");
            System.out.println(product);
        } catch (CodeNotFoundException e2) {
            e2.printStackTrace();
        }
		
		String name = "보리";
		products = mgr.list(name);
		if(!products.isEmpty()) {
			System.out.println(name + "에 해당하는 상품 리스트입니다.");
			System.out.println(products);
		}
		else {
			System.out.println(name + "에 해당하는 상품이 없습니다.");
		}
		
		name = "삼성";
		products = mgr.list(name);
		if(!products.isEmpty()) {
			System.out.println(name + "에 해당하는 상품 리스트입니다.");
			System.out.println(products);
		}
		else {
			System.out.println(name + "에 해당하는 상품이 없습니다.");
		}
		
		System.out.println("전체 TV 리스트입니다.");
		products = mgr.listTV();
		System.out.println(products);
		
		System.out.println("전체 Refrigerator 리스트입니다.");
		products = mgr.listRefrigerator();
		System.out.println(products);
		
		try {
            products = mgr.list400Refrigerator();
	        System.out.println("400L 이상의  Refrigerator 리스트입니다.");
            System.out.println(products);
        } catch (ProductNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		try {
            products = mgr.list50TV();
            System.out.println("50inch 이상의 TV 리스트입니다.");
            System.out.println(products);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
		
		no = 44;
		int price = 100;
		if(mgr.update(no, price)) {
			System.out.println(no + "번이 " + price+ "원으로 변경되었습니다.");
		}
		else {
			System.out.println(no + "번에 해당하는 상품이 없습니다.");
		}
		
		no = 10;
		price = 100;
		if(mgr.update(no, price)) {
			System.out.println(no + "번이 " + price+ "원으로 변경되었습니다.");
		}
		else {
			System.out.println(no + "번에 해당하는 상품이 없습니다.");
		}
		
		System.out.println("전체 상품 리스트입니다.");
		products = mgr.list();
		System.out.println(products);
		
		no = 5;
		if(mgr.delete(no)) {
			System.out.println(no + "번이 삭제되었습니다.");
		}
		else {
			System.out.println(no + "번에 해당하는 상품이 없습니다.");
		}
		
		no = 6;
		if(mgr.delete(no)) {
			System.out.println(no + "번이 삭제되었습니다.");
		}
		else {
			System.out.println(no + "번에 해당하는 상품이 없습니다.");
		}
		
		System.out.println("전체 상품 리스트입니다.");
		products = mgr.list();
		System.out.println(products);
		
		System.out.println("전체 재고 상품의 금액은 " + mgr.priceList() + "원 입니다.");
		
		mgr.save();
		mgr.send();
	}

}
