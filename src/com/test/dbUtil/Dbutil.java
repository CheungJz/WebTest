package com.test.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbutil {
	private static final String DRV = "com.mysql.cj.jdbc.Driver";	//���ݿ����������
	//�������ݿ��url��ַ
	private static final String URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
	private static final String USER = "root";					//�û���
	private static final String PWD = "123";						//����
	
	/**
	 * �õ����ݿ������
	 * @return
	 * Connection
	 * ͨ�������������
	 * DriverManager
	 * ͨ��DriverManager�õ�����
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try{
			//1.ͨ�������������
			Class.forName(DRV);
			//2.ͨ��DriverManager�õ�����
			connection = DriverManager.getConnection(URL, USER, PWD);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * �ر���Դ 
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
