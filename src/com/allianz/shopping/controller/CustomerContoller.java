package com.allianz.shopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.allianz.shopping.dao.CustomerDAO;
import com.allianz.shopping.dao.CustomerDAOImpl;
import com.allianz.shopping.model.Customer;

/**
 * Servlet implementation class CustomerContoller
 */
@WebServlet("/CustomerContoller")
public class CustomerContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    CustomerDAO cdao=new CustomerDAOImpl();
    Customer customer=new Customer();
    public CustomerContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			customer.setCust_name(request.getParameter("cname"));
			customer.setCust_mobile(Integer.parseInt(request.getParameter("mobile")));
			customer.setUsername(request.getParameter("uname"));
			customer.setPassword(request.getParameter("pass"));
			
			
			boolean res=cdao.registeration(customer);
			if(res==true)
			{
				RequestDispatcher rs=request.getRequestDispatcher("Login.jsp");
				rs.forward(request, response);
						return;
			}
			else
			{
				RequestDispatcher rs=request.getRequestDispatcher("Register.jsp");
				rs.forward(request, response);
				return;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String uname=request.getParameter("uname");
			String pass=request.getParameter("pass");
			boolean res=cdao.validate(uname,pass);
			
			System.out.println(res);
			if(res==true)
			{
				RequestDispatcher rs=request.getRequestDispatcher("index.jsp");
				rs.forward(request, response);
				HttpSession session_id=request.getSession();
				session_id.setAttribute("username", uname);
				return;
			}
			else
			{
				System.out.println("Not");
				response.sendRedirect("Login.jsp");
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
