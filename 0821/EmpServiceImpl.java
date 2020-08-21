package com.ssafy.java.d0821;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService{

	private static EmpServiceImpl service = new EmpServiceImpl();
	
	private EmpServiceImpl() {}
	
	public static EmpServiceImpl getService() {
		return service;
	}
	
	private DBUtil util = DBUtil.getUtil();
	private EmpMgr emp = EmpMgrImpl.getMgr();
	
	@Override
	public void add(Employee b) throws SQLException {
		Connection con = null;
		try{
			con = util.getConnection();
			con.setAutoCommit(false);
			emp.add(con, b);
			con.commit();
		}catch(SQLException e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			con.setAutoCommit(true);
			util.close(con);
		}
		
	}

	@Override
	public List<Employee> search() throws SQLException {
		List<Employee> employees = null;
		Connection con = null;
		try{
			con = util.getConnection();
			employees = emp.search(con);
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			util.close(con);
		}
		return employees;
	}

	@Override
	public Employee search(int empNo) throws SQLException {
		Employee employee = null;
		Connection con = null;
		try{
			con = util.getConnection();
			employee = emp.search(con, empNo);
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			util.close(con);
		}
		return employee;
	}

	@Override
	public List<Employee> search(String name) throws SQLException {
		List<Employee> employees = null;
		Connection con = null;
		try{
			con = util.getConnection();
			employees = emp.search(con, name);
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			util.close(con);
		}
		return employees;
	}

	@Override
	public boolean update(int empNo, String dept) throws SQLException {
		boolean result;
		Connection con = null;
		try{
			con = util.getConnection();
			con.setAutoCommit(false);
			
			if(emp.update(con, empNo, dept))
				result = true;
			else
				result = false;
			con.commit();
		}catch(SQLException e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			con.setAutoCommit(true);
			util.close(con);
		}
		return result;
	}

	@Override
	public boolean delete(int empNo) throws SQLException {
		boolean result;
		Connection con = null;
		try{
			con = util.getConnection();
			con.setAutoCommit(false);
			
			if(emp.delete(con, empNo))
				result = true;
			else
				result = false;
			con.commit();
		}catch(SQLException e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			con.setAutoCommit(true);
			util.close(con);
		}
		return result;
	}

}
