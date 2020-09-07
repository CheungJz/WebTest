package com.test.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbutil {
	private static final String DRV = "com.mysql.cj.jdbc.Driver";	//数据库的驱动名称
	//访问数据库的url地址
	private static final String URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
	private static final String USER = "root";					//用户名
	private static final String PWD = "123";						//密码
	
	/**
	 * 得到数据库的连接
	 * @return
	 * Connection
	 * 通过反射加载驱动
	 * DriverManager
	 * 通过DriverManager得到连接
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try{
			//1.通过反射加载驱动
			Class.forName(DRV);
			//2.通过DriverManager得到连接
			connection = DriverManager.getConnection(URL, USER, PWD);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * 关闭资源 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeAll(Connection conn,Statement ps,ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
