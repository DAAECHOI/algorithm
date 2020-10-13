package com.ssafy.java.d0821;

import java.sql.SQLException;
import java.util.List;

public interface EmpService {
	void add(Employee b) throws SQLException;
	List<Employee> search() throws SQLException;
	Employee search(int empNo) throws SQLException;
	List<Employee> search(String name) throws SQLException;
	boolean update(int empNo, String dept) throws SQLException;
	boolean delete(int empNo) throws SQLException;
}
