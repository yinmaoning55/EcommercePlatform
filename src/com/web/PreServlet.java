package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartItemDAO;
import impl.CartItemDAOimpl;
import impl.CategoryDAOimpl;
import impl.ProductDAOimpl;
import impl.UserDAOimpl;
import pojo.Cart;
import pojo.CartItem;
import pojo.Category;
import pojo.Product;
import pojo.User;
import util.ServletUtil;

/**
 * Servlet implementation class PreServlet
 */
@WebServlet("*.action")
public class PreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletUtil.setEncoding(request, response);
		
		UserDAOimpl userDAO=new UserDAOimpl();		
		ProductDAOimpl productDAO=new ProductDAOimpl();
		CategoryDAOimpl categoryDAO=new CategoryDAOimpl();	
		CartItemDAOimpl cartDAO=new CartItemDAOimpl();
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(path);
		if("/register".equals(path)){
			String username=request.getParameter("username");
			String password=request.getParameter("pwd1");
            String confirmpassword=request.getParameter("pwd2") ;
            String phone=request.getParameter("phone");
			String addr=request.getParameter("addr");
             if(password.equals(confirmpassword)){
            	 userDAO.add(new User(username,password,phone,addr));
            	 response.sendRedirect("login.jsp");
             }else{
            	 request.setAttribute("reg_error_msg", "两次密码不一致");
            	 request.getRequestDispatcher("regisger.jsp").forward(request, response);
             }
			
			
		}
		//登陆
		else if("/login".equals(path)){
			
			String password=request.getParameter("pwd");
			String username=request.getParameter("username");
			//验证码
			String code=request.getParameter("code");
			
			HttpSession session=request.getSession();
			String sessionCode= (String)session.getAttribute("code");
			
			User user= userDAO.findByUsername(username);
			//登陆业务逻辑
			if(code.equals(sessionCode)){
				
				if(user!=null){
					//判断密码
					if(ServletUtil.MD5(password).equalsIgnoreCase(user.getPassword())){
						//去登陆3
						response.sendRedirect("index.action");
					}else {
					request.setAttribute("login_error_msg", "用户名或密码错误");
	           	 request.getRequestDispatcher("login.jsp").forward(request, response);
					}
					
				}else {
				request.setAttribute("login_error_msg", "用户名或密码错误");
	          	 request.getRequestDispatcher("login.jsp").forward(request, response);
				 
				
			}
			}else{
				request.setAttribute("code_error_msg", "验证码错误");
           	 request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else if("/index".equals(path)){
			
			List<Product> ps1=productDAO.lastProduct(1);			
			List<Product> ps2=productDAO.lastProduct(2);
			
			//类别列表
			List<Category> cs1 = categoryDAO.findToTree();			
			List<Category> cs2=null;
			
			for (int i = 0; i < cs1.size(); i++) {
				Category c1=cs1.get(i);
				cs2=categoryDAO.findByPid(c1.getId());
				
				
			}
			request.setAttribute("cs1", cs1);
			request.setAttribute("cs2", cs2);
			
			request.setAttribute("ps1", ps1);
			request.setAttribute("ps2", ps2);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			
		}
		
		//商品链接
		else if("/productload".equals(path)){
			Integer id=Integer.parseInt(request.getParameter("id"));
			Product p=productDAO.findById(id);
		   
			
			
			request.setAttribute("p", p);
			request.getRequestDispatcher("view.jsp").forward(request, response);
		}
		//添加到购物车
		else if("/productaddtocart".equals(path)){
			Integer id=Integer.parseInt(request.getParameter("id"));
			
			Integer pcount=Integer.parseInt(request.getParameter("pcount"));
			
			
			Product product=productDAO.findById(id);
			CartItem ci=new CartItem();
			ci.setId(1);
			ci.setProduct(product);
			ci.setPcount(pcount);
		
			 
			cartDAO.add(ci);
			
			//System.out.println(pcount);
			//判断购物车是否存在
			HttpSession session=request.getSession();
			Cart cart=(Cart)session.getAttribute("cart");
			if(cart==null){
				cart=new Cart();
				session.setAttribute("cart", cart);
			}
			

			
			cart.add(ci);
			request.setAttribute("p", product);
			
			request.getRequestDispatcher("view.jsp").forward(request, response);
			
		}
		else if("/Cartload".equals(path)){
            
			List<CartItem> c=cartDAO.findAll();
			
			request.setAttribute("c", c);
			request.getRequestDispatcher("Cart.jsp").forward(request, response);
		
	
		
		
		
	}
		//删除购物项
		else if ("/Cartdelete".equals(path)) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			HttpSession session=request.getSession();
			Cart cart=(Cart)session.getAttribute("cart");
			cart.delete(id);
			response.sendRedirect("Cartload.action");
		}
		//添加数量
		else if ("/add".equals(path)) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			Integer pcount=Integer.parseInt(request.getParameter("pcount"));
			
			
			HttpSession session=request.getSession();
			Cart cart=(Cart)session.getAttribute("cart");
			
			cart.modify(id, pcount);
			//response.sendRedirect("Cartload.action");
			request.getRequestDispatcher("Cart.jsp").forward(request, response);

		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
