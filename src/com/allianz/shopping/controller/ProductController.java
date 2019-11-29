package com.allianz.shopping.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.dao.ProductDAO;
import com.allianz.shopping.dao.ProductdDAOImpl;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtility;


@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 static ProductDAO dao=new ProductdDAOImpl(); //to use directly we make static
    public ProductController()
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");
		if(action!=null && action.equals("delete"))
		{
			String id=request.getParameter("id");
			boolean flag=dao.deleteProduct(Integer.parseInt(id));
			if(flag)
			{
				response.sendRedirect("ProductController");
			}
		}
		else if(action!=null && action.equals("edit"))
		{
			String id=request.getParameter("id");
			Product productEdit=dao.getProductById(Integer.parseInt(id));
			
			if(productEdit!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("ProductEdit.jsp");
				request.setAttribute("productEdit",productEdit);
				rd.forward(request, response);
			}
		}
		else if(action!=null && action.equals("new"))
		{
			Product productEdit=new Product();
			
			if(productEdit!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("ProductEdit.jsp");
				request.setAttribute("productEdit",productEdit);
				rd.forward(request, response);
			}
		}
		else
		{
			List<Product> productList=dao.getALLProducts();
			RequestDispatcher rd=request.getRequestDispatcher("ProductList.jsp");
			request.setAttribute("productList",productList);
			rd.forward(request, response);
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		System.out.println(action);
		if(action!=null && action.equals("update"))
		{
			String id=req.getParameter("id");
			String code=req.getParameter("code");
			String description=req.getParameter("desc");
			String price=req.getParameter("price");
			String manfDate=req.getParameter("date");
			
			Product product=new Product();
			product.setId(Integer.parseInt(id));
			product.setCode(code);
			product.setDescription(description);
			product.setPrice(Float.parseFloat(price));
			product.setManfDate(DateUtility.convertStringToDate(manfDate));
			boolean flag=false;
			
			if(dao.getProductById(Integer.parseInt(id))!=null)
				flag=dao.updateProduct(product);
			else
				flag=dao.addProduct(product);
			
			
			if(flag)
				resp.sendRedirect("ProductController");
			
			
			
		}
		else if(action==null )
		{
System.out.println("in save method of controller");
			String id=req.getParameter("id");
			String code=req.getParameter("code");
			String description=req.getParameter("desc");
			String price=req.getParameter("price");
			String manfDate=req.getParameter("date");
			
			Product product=new Product();
			product.setId(Integer.parseInt(id));
			product.setCode(code);
			product.setDescription(description);
			product.setPrice(Float.parseFloat(price));
			product.setManfDate(DateUtility.convertStringToDate(manfDate));
			boolean flag=false;
			
			if(dao.getProductById(Integer.parseInt(id))!=null)
				flag=dao.updateProduct(product);
			else
				flag=dao.addProduct(product);
			
			
			if(flag)
				resp.sendRedirect("ProductController");
			
			
			
		
		}
	}
	
	

}
