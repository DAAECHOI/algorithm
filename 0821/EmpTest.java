package com.ssafy.java.d0821;

import java.util.List;

public class EmpTest {

	public static void main(String[] args) {
		EmpService service = EmpServiceImpl.getService();
		EmpMgr mgr = EmpMgrImpl.getMgr();
		
		try {
			Employee employee1 = new Employee(1, "최다애", "사원", "개발팀");
			service.add(employee1);
			Employee employee2 = new Employee(2, "보리", "대리", "개발팀");
			service.add(employee2);
			Employee employee3 = new Employee(3, "꼬리", "팀장", "개발팀");
			service.add(employee3);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			System.out.println(service.search());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println(service.search(4));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println(service.search("리"));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println(service.update(4, "인사팀"));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println(service.delete(4));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
	}
}
