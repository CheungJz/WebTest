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
		//1.定义sql语句
		String sql = "select * from test1";
		//2.取得连接
		Connection connection = Dbutil.getConnection();
		//3.通过连接取得命令对象
		Statement ps = connection.createStatement();
		//4.执行命令
		ResultSet rs = ps.executeQuery(sql);
		
		//5.将ResultSet对象转换成JAVA的集合对象
		while(rs != null && rs.next()){
			int ID = rs.getInt("ID");		//"did"：代表的数据库的列名,也可写成rs.getInt(1);
			String name = rs.getString("name");//也可写成rs.getString(2);
			String address = rs.getString("address");//也可写成rs.getString(3);
			Dept dept = new Dept(ID, name, address);
			//将当前的dept对象加入到集合中
			depts.add(dept);
		}
		//6.关闭资源
		Dbutil.closeAll(connection,ps,rs);
		return depts;
	}
	/**
	 * 添加部门
	 * @param dept
	 * @throws Exception
	 */
	public void add(Dept dept) throws Exception{
		//1.构造sql语句
		//①常规做法
		//String sql = "insert into dept values(null,'"+dept.getDname()+"','"+dept.getDcity()+"')";
		//②使用String.format()方法：
		String sql = "insert into test1 values(null,'%s','%s')";
		sql = String.format(sql,dept.getName(),dept.getAddress());
		//2.得到连接对象
		Connection connection = Dbutil.getConnection();
		//3.得到命令对象
		Statement ps = connection.createStatement();
		//4.执行命令
		ps.executeUpdate(sql);
		//5.关闭资源
		Dbutil.closeAll(connection, ps, null);
		
	}
	/**
	 * 删除部门
	 * @param dept
	 * @throws Exception
	 */
	public void delete(int ID) throws Exception{
		//1.构造sql语句
		String sql = "delete from test1 where ID = " + ID;
		//2.得到连接对象
		Connection connection = Dbutil.getConnection();
		//3.得到命令对象
		Statement ps = connection.createStatement();
		//4.执行命令
		ps.executeUpdate(sql);
		//5.关闭资源
		Dbutil.closeAll(connection, ps, null);
		
	}
	/**
	 * 修改部门
	 * @param dept
	 * @throws Exception
	 */
	public void update(Dept dept) throws Exception{
		//1.构造sql语句
		//①常规做法
		//String sql = "update dept set dname = '"+dept.getDname()+"',dcity='"+dept.getDcity()+"' where did=" + dept.getDid();
		//②使用String.format()方法：
		String sql = "update test1 set name='%s',address='%s' where ID=%d";
		sql = String.format(sql,dept.getName(),dept.getAddress(),dept.getID());
		//2.得到连接对象
		Connection connection = Dbutil.getConnection();
		//3.得到命令对象
		Statement ps = connection.createStatement();
		//4.执行命令
		ps.executeUpdate(sql);
		//5.关闭资源
		Dbutil.closeAll(connection, ps, null);
		
	}
	/**
	 * 根据部门编号查询部门信息
	 * @param did
	 * @return
	 * @throws Exception
	 */
	public Dept findDeptByDid(int ID) throws Exception{
		Dept dept = null;
		//1.定义sql语句
		String sql = "select * from test1 where ID=" + ID;
		//2.取得连接
		Connection connection = Dbutil.getConnection();
		//3.通过连接取得命令对象
		Statement ps = connection.createStatement();
		//4.执行命令
		ResultSet rs = ps.executeQuery(sql);
		//5.将ResultSet对象转换成JAVA的集合对象
		if(rs != null && rs.next()){
			String name = rs.getString("name");//也可写成rs.getString(2);
			String address = rs.getString("address");//也可写成rs.getString(3);
			dept = new Dept(ID, name, address);
		
		}
		//6.关闭资源
		Dbutil.closeAll(connection,ps,rs);
		return dept;
	}
}
