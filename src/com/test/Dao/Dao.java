package com.test.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.dbUtil.Dbutil;
import com.test.po.Dept;

public class Dao {
	public List<Dept> findDepts() throws Exception{
		List<Dept> depts = new ArrayList<Dept>();
		//1.����sql���
		String sql = "select * from test1";
		//2.ȡ������
		Connection connection = Dbutil.getConnection();
		//3.ͨ������ȡ���������
		Statement ps = connection.createStatement();
		//4.ִ������
		ResultSet rs = ps.executeQuery(sql);
		
		//5.��ResultSet����ת����JAVA�ļ��϶���
		while(rs != null && rs.next()){
			int ID = rs.getInt("ID");		//"did"����������ݿ������,Ҳ��д��rs.getInt(1);
			String name = rs.getString("name");//Ҳ��д��rs.getString(2);
			String address = rs.getString("address");//Ҳ��д��rs.getString(3);
			Dept dept = new Dept(ID, name, address);
			//����ǰ��dept������뵽������
			depts.add(dept);
		}
		//6.�ر���Դ
		Dbutil.closeAll(connection,ps,rs);
		return depts;
	}
	/**
	 * ��Ӳ���
	 * @param dept
	 * @throws Exception
	 */
	public void add(Dept dept) throws Exception{
		//1.����sql���
		//�ٳ�������
		//String sql = "insert into dept values(null,'"+dept.getDname()+"','"+dept.getDcity()+"')";
		//��ʹ��String.format()������
		String sql = "insert into test1 values(null,'%s','%s')";
		sql = String.format(sql,dept.getName(),dept.getAddress());
		//2.�õ����Ӷ���
		Connection connection = Dbutil.getConnection();
		//3.�õ��������
		Statement ps = connection.createStatement();
		//4.ִ������
		ps.executeUpdate(sql);
		//5.�ر���Դ
		Dbutil.closeAll(connection, ps, null);
		
	}
	/**
	 * ɾ������
	 * @param dept
	 * @throws Exception
	 */
	public void delete(int ID) throws Exception{
		//1.����sql���
		String sql = "delete from test1 where ID = " + ID;
		//2.�õ����Ӷ���
		Connection connection = Dbutil.getConnection();
		//3.�õ��������
		Statement ps = connection.createStatement();
		//4.ִ������
		ps.executeUpdate(sql);
		//5.�ر���Դ
		Dbutil.closeAll(connection, ps, null);
		
	}
	/**
	 * �޸Ĳ���
	 * @param dept
	 * @throws Exception
	 */
	public void update(Dept dept) throws Exception{
		//1.����sql���
		//�ٳ�������
		//String sql = "update dept set dname = '"+dept.getDname()+"',dcity='"+dept.getDcity()+"' where did=" + dept.getDid();
		//��ʹ��String.format()������
		String sql = "update test1 set name='%s',address='%s' where ID=%d";
		sql = String.format(sql,dept.getName(),dept.getAddress(),dept.getID());
		//2.�õ����Ӷ���
		Connection connection = Dbutil.getConnection();
		//3.�õ��������
		Statement ps = connection.createStatement();
		//4.ִ������
		ps.executeUpdate(sql);
		//5.�ر���Դ
		Dbutil.closeAll(connection, ps, null);
		
	}
	/**
	 * ���ݲ��ű�Ų�ѯ������Ϣ
	 * @param did
	 * @return
	 * @throws Exception
	 */
	public Dept findDeptByDid(int ID) throws Exception{
		Dept dept = null;
		//1.����sql���
		String sql = "select * from test1 where ID=" + ID;
		//2.ȡ������
		Connection connection = Dbutil.getConnection();
		//3.ͨ������ȡ���������
		Statement ps = connection.createStatement();
		//4.ִ������
		ResultSet rs = ps.executeQuery(sql);
		//5.��ResultSet����ת����JAVA�ļ��϶���
		if(rs != null && rs.next()){
			String name = rs.getString("name");//Ҳ��д��rs.getString(2);
			String address = rs.getString("address");//Ҳ��д��rs.getString(3);
			dept = new Dept(ID, name, address);
		
		}
		//6.�ر���Դ
		Dbutil.closeAll(connection,ps,rs);
		return dept;
	}
}
