package com.ssafy.java.d0821;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpMgrImpl implements EmpMgr{

	private static EmpMgrImpl mgr = new EmpMgrImpl();
	private DBUtil util = DBUtil.getUtil();
	
	private EmpMgrImpl() {}
	
	public static EmpMgrImpl getMgr() {
		return mgr;
	}
	
	@Override
	public void add(Connection con, Employee b) throws SQLException {
		String sql = "insert into employee values(?,?,?,?)";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)
			){
			pstmt.setInt(1, b.getEmpNo());
			pstmt.setString(2, b.getName());
			pstmt.setString(3, b.getPosition());
			pstmt.setString(4, b.getDept());
			pstmt.executeUpdate();
				
		}
	}

	@Override
	public List<Employee> search(Connection con) throws SQLException {
		List<Employee> employees = null;
		String sql = "select * from employee";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try{
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			employees = new ArrayList<>();
			while(rset.next()) {
				int empno = rset.getInt("empno");
				String name = rset.getString("ename");
				String position = rset.getString("position");
				String dept = rset.getString("dept");
				
				Employee employee = new Employee(empno, name, position, dept);
				employees.add(employee);
			}
		} finally {
			util.close(rset, pstmt);
		}
		
		return employees;
	}

	@Override
	public Employee search(Connection con, int empNo) throws SQLException {
		String sql = "select * from employee where empno=?";
		Employee employee = null;
		try(
			PreparedStatement pstmt = con.prepareStatement(sql)
			){
			pstmt.setInt(1, empNo);
			try(
				ResultSet rset = pstmt.executeQuery()
				){
				//컬럼헤드를 가리키고 있는 상태
				if(rset.next()) {
					int empno = rset.getInt("empno");
					String name = rset.getString("ename");
					String position = rset.getString("position");
					String dept = rset.getString("dept");
					
					employee = new Employee(empno, name, position, dept);
				}
			}
		}
		return employee;
	}

	@Override
	public List<Employee> search(Connection con, String ename) throws SQLException {
		List<Employee> employees = null;
		
		String sql = "select * from employee where ename LIKE concat('%',?,'%')";
		try(
			PreparedStatement pstmt = con.prepareStatement(sql)
			){
			pstmt.setString(1, ename);
			try(
				ResultSet rset = pstmt.executeQuery()
				){
				employees = new ArrayList<>();
				
				while(rset.next()) {
					int empno = rset.getInt("empno");
					String name = rset.getString("ename");
					String position = rset.getString("position");
					String dept = rset.getString("dept");
						
					Employee employee = new Employee(empno, name, position, dept);
					employees.add(employee);
				}
			}
		}
		return employees;
	}

	@Override
	public boolean update(Connection con, int empNo, String dept) throws SQLException {
		String sql = "update employee set dept=? where empno=?";
		int result = -1;
		try(
			PreparedStatement pstmt = con.prepareStatement(sql)
			){
			pstmt.setString(1, dept);
			pstmt.setInt(2, empNo);
			
			result = pstmt.executeUpdate();
		}
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Connection con, int empNo) throws SQLException {
		String sql = "delete from employee where empno=?";
		int result = -1;
		try(
			PreparedStatement pstmt = con.prepareStatement(sql)
			){
			pstmt.setInt(1, empNo);
			result = pstmt.executeUpdate();
		}
		if(result > 0)
			return true;
		else
			return false;
	}

}
