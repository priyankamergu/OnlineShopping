package com.allianz.shopping.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.dao.CategoryDAO;
import com.allianz.shopping.dao.CategoryDAOImpl;
import com.allianz.shopping.dao.OrderDAO;
import com.allianz.shopping.dao.OrderDAOImpl;
import com.allianz.shopping.dao.ProductDAO;
import com.allianz.shopping.dao.ProductDAODatabaseImpl;
import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Order;
import com.allianz.shopping.model.Product;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAO productDao=new ProductDAODatabaseImpl();
		CategoryDAO categoryDao=new CategoryDAOImpl();
		OrderDAO orderDao=new OrderDAOImpl();
		
		String username=(String)request.getSession().getAttribute("username");
		System.out.println("UserName "+username);
		
		String action=request.getParameter("action");
		if(action!=null && action.equals("ListOrder"))
		{
			List<Order> orderList=orderDao.getAllOrderByUserName(username);
//			for(Order order:orderList)
//			{
//				System.out.println(order.getOrder_id());
//			}
			
			if(orderList!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("ShowOrders.jsp");
				request.setAttribute("orderList", orderList);
				rd.forward(request, response);
						
			}
		}
		else
		{
			List<Product> list = productDao.getALLProducts();
			List<Category> categoryList = categoryDao.getALLCategory();
			System.out.println(list);
			request.setAttribute("list", list);
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
