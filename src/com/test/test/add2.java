package com.test.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Dao.Dao;
import com.test.po.Dept;

public class add2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		Dept dept = new Dept();
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        dept.setName(name);
        dept.setAddress(address);
        Dao dao = new Dao();
        try {
			dao.add(dept);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        resp.sendRedirect("/Web_test/cx");
	}
}
