package com.ssafy.java.d0820;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private static ProductDAO dao = new ProductDAO();
	private DBUtil util = DBUtil.getUtil();
	
	public static ProductDAO getDao() {
		return dao;
	}
	
	private ProductDAO() {}
	
	//상품 정보 저장
	public void insertProduct(Product product) {
		String sql = "insert into product values(?,?,?,?)";
		try(
				Connection con = util.getConnection();
	    	){
	    		
	    		try ( 
	    				PreparedStatement pstmt = 
	    				con.prepareStatement(sql);
				){
	    			pstmt.setInt(1, product.getPno());
	    			pstmt.setString(2, product.getPname());
	    			pstmt.setInt(3, product.getPrice());
	    			pstmt.setInt(4, product.getQty());
	    			pstmt.executeUpdate();
	    			
				}catch( SQLException e ) {
					e.printStackTrace();
				}
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
		
	}
	
	//상품 전체 정보 검색
	public List<Product> listProduct(){
		List<Product> products = new ArrayList<>();
		String sql = "select * from product";
    	try(
    			Connection con = util.getConnection();
    	){
    		try ( 
    				PreparedStatement pstmt = con.prepareStatement(sql);
    				ResultSet rset = pstmt.executeQuery();
			){
    			while(rset.next()) {
    				int pno = rset.getInt("pno");
    				String pname = rset.getString("pname");
    				int price = rset.getInt("price");
    				int qty = rset.getInt("qty");
    				
    				Product product = new Product(pno, pname, price, qty);
    				products.add(product);
    			}
			}catch( SQLException e ) {
				e.printStackTrace();
			}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		
		return products;
	}
	
	//상품명 검색
	public List<Product> searchProductPname(String selectedPname){
		List<Product> products = new ArrayList<>();
		String sql = "select * from product where pname LIKE concat('%',?,'%')";
	    try(
	    		Connection con = util.getConnection();
	    ){
	    	try ( 
	    			PreparedStatement pstmt = con.prepareStatement(sql);
			){
	    		pstmt.setString(1, selectedPname);
		    	try(
		    		ResultSet rset = pstmt.executeQuery();
		    	){	
		    		while(rset.next()) {
		    			int pno = rset.getInt("pno");
		    			String pname = rset.getString("pname");
		    			int price = rset.getInt("price");
		    			int qty = rset.getInt("qty");
		    				
		    			Product product = new Product(pno, pname, price, qty);
		    			products.add(product);
		    		}
		    	}catch( SQLException e ) {
						e.printStackTrace();
				}
			}catch( SQLException e ) {
				e.printStackTrace();
			}
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
		
		return products;
	}	
	
	//상품 가격 검색
	public List<Product> searchProductPrice(int selectedPrice){
		List<Product> products = new ArrayList<>();
		String sql = "select * from product where price <= ?";
		try(
		    	Connection con = util.getConnection();
		){
		    try ( 
		    		PreparedStatement pstmt = con.prepareStatement(sql);
			){
		    	pstmt.setInt(1, selectedPrice);
			    try(
			    	ResultSet rset = pstmt.executeQuery();
			    ){	
			    	while(rset.next()) {
			    		int pno = rset.getInt("pno");
			    		String pname = rset.getString("pname");
			    		int price = rset.getInt("price");
			    		int qty = rset.getInt("qty");
			    				
			    		Product product = new Product(pno, pname, price, qty);
			    		products.add(product);
			    	}
			    }catch( SQLException e ) {
						e.printStackTrace();
				}
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}catch(SQLException e) {
		    e.printStackTrace();
		}
			
		return products;
	}		
	
	//상품 번호 검색
	public Product searchProductPno(int selectedPno){
		Product product = new Product();
		String sql = "select * from product where pno = ?";
		try(
			    Connection con = util.getConnection();
		){
			try ( 
			    	PreparedStatement pstmt = con.prepareStatement(sql);
			){
			    pstmt.setInt(1, selectedPno);
				try(
				    ResultSet rset = pstmt.executeQuery();
				){	
				    if(rset.next()) {
				    	int pno = rset.getInt("pno");
				    	String pname = rset.getString("pname");
				    	int price = rset.getInt("price");
				    	int qty = rset.getInt("qty");
				    				
				    	product = new Product(pno, pname, price, qty);
				    }
				}catch( SQLException e ) {
						e.printStackTrace();
				}
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		return product;
	}			
	
	//상품 번호 삭제
	public void deleteProductPno(int selectedPno){
		String sql = "delete from product where pno = ?";
		try(
				Connection con = util.getConnection();
		){
			try ( 
					PreparedStatement pstmt = con.prepareStatement(sql);
			){
				pstmt.setInt(1, selectedPno);
				pstmt.executeUpdate();
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	
	//제품번호 검색으로 가격 업데이트
	public void motifyProductPrice(int selectedPno, int selectedprice){
		String sql = "update product set price = ? where pno = ?";
		try(
				Connection con = util.getConnection();
				){
	    		
	    		try ( 
					PreparedStatement pstmt = 
					con.prepareStatement(sql);
				){
	    			pstmt.setInt(1, selectedprice);
	    			pstmt.setInt(2, selectedPno);
	    			pstmt.executeUpdate();
					
				}catch( SQLException e ) {
					e.printStackTrace();
				}
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
		
	}
	
}
