package com.test.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Dao.Dao;
import com.test.po.Dept;

public class test extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        List<Dept> heros;
		try {
			heros = new Dao().findDepts();
			StringBuffer sb = new StringBuffer();
	        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
	        sb.append("<tr><td>id</td><td>name</td><td>address</td><td><a href='add'>add</a></td><td>delete</td></tr>\r\n");
	        String trFormat = "<tr><td>%d</td><td>%s</td><td>%s</td><td><a href='editHero?id=%d'>update</a></td><td><a href='deleteHero?id=%d'>delete</a></td></tr>\r\n";
	        for (Dept dept : heros) {
	            String tr = String.format(trFormat, dept.getID(), dept.getName(), dept.getAddress(),dept.getID(),dept.getID());
	            sb.append(tr);
	        }
	 
	        sb.append("</table>");
	 
	        response.getWriter().write(sb.toString());
	 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
