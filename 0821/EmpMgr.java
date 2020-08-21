package com.ssafy.java.d0821;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmpMgr {
	void add(Connection con, Employee b) throws SQLException;
	List<Employee> search(Connection con) throws SQLException;
	Employee search(Connection con, int empNo) throws SQLException;
	List<Employee> search(Connection con, String name) throws SQLException;
	boolean update(Connection con, int empNo, String dept) throws SQLException;
	boolean delete(Connection con, int empNo) throws SQLException;
}
