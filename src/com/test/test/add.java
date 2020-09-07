package com.test.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Dao.Dao;
import com.test.po.Dept;

public class add extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");        
        StringBuffer format = new StringBuffer();
        response.setContentType("text/html; charset=UTF-8");
        format.append("<!DOCTYPE html>");
        format.append("<form action='add2' method='post'>");
        format.append("姓名 ： <input type='text' name='name'> <br>");
        format.append("地址： <input type='text' name='address'> <br>");
        format.append("<input type='submit' value='增加'>");
        format.append("</form>");
//        dept.setID(request.getParameter("ID"));
//        dept.setname(Float.parseFloat(request.getParameter("hp")));
//        dept.setDamage(Integer.parseInt(request.getParameter("damage")));
//         
//        new HeroDAO().add(hero);
        String str=format.toString();
        response.getWriter().write(str);;
        
    }
}
