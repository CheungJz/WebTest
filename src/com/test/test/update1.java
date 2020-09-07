package com.test.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Dao.Dao;
import com.test.po.Dept;

public class update1 extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Dept hero = new Dept();
        hero.setID(Integer.parseInt(request.getParameter("id")));
        hero.setName(request.getParameter("name"));
        hero.setAddress(request.getParameter("address"));
        try {
			new Dao().update(hero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        response.sendRedirect("/Web_test/cx");
 
    }
}
