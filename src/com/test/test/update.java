package com.test.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Dao.Dao;
import com.test.po.Dept;

public class update extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int ID = Integer.parseInt(req.getParameter("id"));
        Dept dept;
		try {
			System.out.println(ID);
			dept = new Dao().findDeptByDid(ID);
			StringBuffer format = new StringBuffer();
	        resp.setContentType("text/html; charset=UTF-8");
	        format.append("<!DOCTYPE html>");
	        format.append("<form action='update1' method='post'>");
	        format.append("姓名 ： <input type='text' name='name'  value='%s' > <br>");
	        format.append("地址： <input type='text' name='address'  value='%s' > <br>");
	        format.append("<input type='hidden' name='id' value='%d'>");
	        format.append("<input type='submit' value='更新'>");
	        format.append("</form>");
	        String html = String.format(format.toString(), dept.getName(), dept.getAddress(),dept.getID());
	        resp.getWriter().write(html);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
