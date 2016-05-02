package com.tcc.domain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO{
	public BaseDAO(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();
		}
	}
	protected Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://localhost/tcc";
		Connection conn = DriverManager.getConnection(url,"NikFG","niks1111");
		return conn;
	}
	public static void main(String[] args) throws SQLException{
		BaseDAO db = new BaseDAO();
		Connection conn = db.getConnection();
		System.out.println(conn);
	}
}
