package com.allianz.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.allianz.shopping.dao.CategoryDAO;
import com.allianz.shopping.dao.CategoryDAOImpl;
import com.allianz.shopping.dao.ProductDAO;
import com.allianz.shopping.dao.ProductDAODatabaseImpl;
import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtility;
import com.mysql.cj.Session;

/**
 * Servlet implementation class ProductDatabaseController
 */
@WebServlet("/ProductDatabaseController")
public class ProductDatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO impl = new ProductDAODatabaseImpl();

	static CategoryDAO categorydao = new CategoryDAOImpl();

	public ProductDatabaseController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String id = request.getParameter("id");
		if (action != null && action.equals("delete")) {
			boolean flag = impl.deleteProduct(Integer.parseInt(id));
			if (flag)
				response.sendRedirect("ProductDatabaseController");

			return;
		} else if (action != null && action.equals("edit")) {
			Product productEdit = impl.getProductById(Integer.parseInt(id));
			if (productEdit != null) {
				RequestDispatcher rd = request.getRequestDispatcher("ProductEditDataBase.jsp");
				request.setAttribute("productEdit", productEdit);
				rd.forward(request, response);
				return;
			}
		} else if (action != null && action.equals("new")) {
			Product productEdit = new Product();

			if (productEdit != null) {
				RequestDispatcher rd = request.getRequestDispatcher("ProductEditDataBase.jsp");
				request.setAttribute("productEdit", productEdit);
				rd.forward(request, response);
				return;
			}
		} else if (action != null && action.equals("getAllCategoryByProductId")) {
			String categoryid = request.getParameter("categoryId");
			List<Category> categoryList = categorydao.getALLCategory();

			List<Product> productList = (List<Product>) impl.getAllProductByCategoryID(Integer.parseInt(categoryid));
			if (productList != null) {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("categoryList", categoryList);
				request.setAttribute("list", productList);
				rd.forward(request, response);
			}
		}

		else if (action != null && action.equals("getProductDescritpion")) {
			String pid = request.getParameter("productId");

			Product product = impl.getProductById(Integer.parseInt(pid));

			if (product != null) {
				RequestDispatcher rd = request.getRequestDispatcher("Subpage.jsp");

				request.setAttribute("product", product);
				rd.forward(request, response);
			}
		} else if (action != null && action.equals("addToCart")) {
			String pid = request.getParameter("productId");

			Product product = impl.getProductById(Integer.parseInt(pid));

			if (product != null)
			{
				List<Product> productList = new ArrayList<Product>();
				if (request.getSession().getAttribute("productList") != null)
				{
					productList = (List<Product>) request.getSession().getAttribute("productList");
					productList.add(product);
					request.getSession().setAttribute("productList", productList);
				} else {
					productList.add(product);
					request.getSession().setAttribute("productList", productList);
				}

				RequestDispatcher rd = request.getRequestDispatcher("addToCart.jsp");
				request.setAttribute("productList", productList);
				
				rd.forward(request, response);

			}
		}
		else if (action != null && action.equals("deleteFromCart")) {
			String index = request.getParameter("index");
			List<Product> productList = new ArrayList<Product>();

			if (request.getSession().getAttribute("productList") != null)
			{
				productList=(List<Product>)request.getSession().getAttribute("productList");
				productList.remove(Integer.parseInt(index));
				request.getSession().removeAttribute("productList");
				request.getSession().setAttribute("productList", productList);
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("addToCart.jsp");
			rd.forward(request, response);
		}

		else {

			List<Product> list = impl.getALLProducts();
			List<Category> categoryList = categorydao.getALLCategory();
			System.out.println(list);
			request.setAttribute("list", list);
			request.setAttribute("categoryList", categoryList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		System.out.println("Hello");
		if (action != null && action.equals("update")) {
			System.out.println("MMMMMMM");
			Product product = new Product();
			String id = request.getParameter("id");
			product.setId(Integer.parseInt(id));
			product.setCode(request.getParameter("code"));
			product.setDescription(request.getParameter("desc"));
			product.setPrice(Float.parseFloat(request.getParameter("price")));
			product.setManfDate(DateUtility.convertStringToDate(request.getParameter("date")));

			System.out.println(product);

			boolean flag = false;

			if (impl.getProductById(Integer.parseInt(id)) != null)
				flag = impl.updateProduct(product);
			else
				flag = impl.addProduct(product);

			if (flag)
				response.sendRedirect("ProductDatabaseController");

		}

		if (action != null && action.equals("save")) {
			System.out.println("Inside save");
			Product product = new Product();
			int pid = Integer.parseInt(request.getParameter("id"));
			product.setId(pid);
			product.setCode(request.getParameter("code"));
			product.setDescription(request.getParameter("desc"));
			product.setPrice(Float.parseFloat(request.getParameter("price")));
			product.setManfDate(DateUtility.convertStringToDate(request.getParameter("date")));

			boolean flag = false;

			System.out.println(impl.getProductById(pid));
//			System.out.println(product);

			System.out.println("impl.getProductById(pid)");
			if (impl.getProductById(pid) != null) {

				flag = impl.updateProduct(product);
			} else {
				flag = impl.addProduct(product);
			}

			if (flag)
				response.sendRedirect("ProductDatabaseController");
		}

		List<Product> list = impl.getALLProducts();
		request.setAttribute("list", list);
		request.getRequestDispatcher("ProductListDataBase.jsp").include(request, response);

	}

}
