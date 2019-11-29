package com.allianz.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.dao.AddToCartDAO;
import com.allianz.shopping.dao.AddToCartDAOimpl;
import com.allianz.shopping.dao.OrderDAO;
import com.allianz.shopping.dao.OrderDAOImpl;
import com.allianz.shopping.dao.ProductDAO;
import com.allianz.shopping.dao.ProductDAODatabaseImpl;
import com.allianz.shopping.model.AddToCart;
import com.allianz.shopping.model.Order;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtility;
import com.sun.istack.internal.Pool.Impl;

@WebServlet("/CheckOutController")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CheckOutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//System.out.println("Helllo");
		OrderDAO orderdao=new OrderDAOImpl();
		AddToCartDAO addDao=new AddToCartDAOimpl();
		
		
		
		ProductDAO productDao=new ProductDAODatabaseImpl();
		
		
		AddToCart addToCart=null;
			boolean flag=false;
		
		String username=(String)request.getSession().getAttribute("username");
				
		String product_id[]=request.getParameterValues("product_id");
		
		int order_id=0;
		
		if(product_id!=null && product_id.length>0)
		{
			
			float grantTotal=0;
			for(int i=0;i<product_id.length;i++)
			{
				String total=request.getParameter("total"+product_id[i]);
				grantTotal=grantTotal+ Float.parseFloat(total);
			}
			Order order=new Order();
			order.setDate(new Date());
			order.setOredr_status("Ordered");
			order.setUserName(username);
			order.setPrice(grantTotal);
			order_id=orderdao.addOrder(order);
			
			
			System.out.println("Your order id is"+order_id);
			for(int i=0;i<product_id.length;i++)
			{
				System.out.println("Helllo");
				if(product_id[i]!=null && !product_id[i].trim().equals(""))
				{
					String quantity=request.getParameter("quantity"+product_id[i]);
					
					String total=request.getParameter("total"+product_id[i]);
					
					if(quantity!=null)
					{
						System.out.println("hihihi");
						addToCart=new AddToCart();
						addToCart.setOrder_id(order_id);
						addToCart.setQuantity(Integer.parseInt(quantity));
						addToCart.setProduct_id(Integer.parseInt(product_id[i]));
						addToCart.setTotal(Float.parseFloat(total));
						flag=addDao.addToCart(addToCart);		
					}
				}
			}	
			
			
			List<AddToCart> ListAdd=new ArrayList<AddToCart>();
			ListAdd=(List<AddToCart>)addDao.getAllAddToCartByOrderId(order_id);
	
			
			if(flag==true)
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("AddToCartShow.jsp");
				request.setAttribute("ListAdd",ListAdd);
				
				rd.forward(request, response);
			}
			else
			{
				System.out.println("No data add to cart");
			}
			
			
		}
	}

}
