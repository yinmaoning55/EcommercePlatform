package com.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import impl.AdminDAOimpl;
import impl.CategoryDAOimpl;
import impl.ProductDAOimpl;
import impl.UserDAOimpl;
import pojo.Admin;
import pojo.Category;
import pojo.Product;
import pojo.User;
import util.DBUtil;
import util.ServletUtil;

@WebServlet("*.do")

public class AdminSerlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8873755674091037295L;
	protected void servlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBUtil.getConnection();
		ServletUtil.setEncoding(request, response);

		UserDAOimpl userDAO = new UserDAOimpl();
		CategoryDAOimpl categoryDAO = new CategoryDAOimpl();
		AdminDAOimpl adminDAO = new AdminDAOimpl();
		ProductDAOimpl pdao = new ProductDAOimpl();

		String uri = request.getRequestURI();

		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(path);
		if ("/userlist".equals(path)) {
			List<User> user = userDAO.findAll();
			request.setAttribute("users", user);
			request.getRequestDispatcher("user.jsp").forward(request, response);
		} else if ("/categorylist".equals(path)) {
			// ����б�
			List<Category> categories = categoryDAO.findToTree();
			// �����������ַ�������
			for (Category category : categories) {
				String str = "";
				for (int i = 0; i < category.getGrade() - 1; i++) {
					str += "----";
				}
				category.setName(str + category.getName());

			}

			request.setAttribute("categories", categories);
			request.getRequestDispatcher("categories.jsp").forward(request, response);
		} else if ("/categoryaddroot".equals(path)) {
			// ��Ӹ����

			String name = request.getParameter("name");
			String descr = request.getParameter("descr");
			categoryDAO.add(name, descr);
			response.sendRedirect("categorylist.do");

		} else if ("/categoryloadchild".equals(path)) {
			// ���ݴ���PID��������
			Integer pid = Integer.parseInt(request.getParameter("pid"));
			Category category = categoryDAO.findById(pid);
			System.out.println(category);
			request.setAttribute("category", category);
			request.getRequestDispatcher("category_add_child.jsp").forward(request, response);

		} else if ("/categoryaddchild".equals(path)) {
			// ��������
			Integer pid = Integer.parseInt(request.getParameter("pid"));
			System.out.println(pid);

			String name = request.getParameter("name");
			String descr = request.getParameter("descr");
			System.out.println(name + descr);
			
			System.out.println("p id is ----"+pid);
			System.out.println("name id is ----"+name);
			System.out.println("descr id is ----"+descr);
			
			
			categoryDAO.add(name, descr, pid);
			response.sendRedirect("categorylist.do");

		} else if ("/categorydelete".equals(path)) {
			// ��������
			Integer pid = Integer.parseInt(request.getParameter("pid"));
			Integer id = Integer.parseInt(request.getParameter("id"));
			categoryDAO.delete(id, pid);

			response.sendRedirect("categorylist.do");

		}

		else if ("/adminlist".equals(path)) {
			List<Admin> admins = adminDAO.findAll();

			request.setAttribute("admins", admins);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} else if ("/adminadd".equals(path)) {
			String aname = request.getParameter("aname");
			String apwd = request.getParameter("apwd");
			System.out.println(aname + apwd);
			adminDAO.add(new Admin(aname, apwd));

			// ��ӳɹ�������Ԅ���ת��adminҳ��
			// ʹ��jsp/servlet���ض�����
			response.sendRedirect("adminlist.do");
		} else if ("/admindelete".equals(path)) {
			// ɾ������Ա
			Integer id = Integer.parseInt(request.getParameter("id"));
			adminDAO.delete(id);

			response.sendRedirect("adminlist.do");

			// ת�����ض��������
			// ת����һ������û�����꣬������һ������ɣ�������ͬһ������request��,ת������Я�����ݣ���ַ������ı�
			// �ض���һ���������꣬������ת����һ�����棻���������������ض�����Я������

		} else if ("/adminload".equals(path)) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Admin admin = adminDAO.findById(id);
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("admin_load.jsp").forward(request, response);

		} else if ("/adminupdata".equals(path)) {
			// �޸�����
			Integer id = Integer.parseInt(request.getParameter("id"));

			Admin admin = adminDAO.findById(id);
			// �õ�ԭʼ����
			String pwd = request.getParameter("pwd");
			// ������
			String newpwd = request.getParameter("newpwd");
			String confirmnewpwd = request.getParameter("confirmnewpwd");

			// ����ȶ�
			if (admin.getApwd().equals(pwd)) {
				if (newpwd.equals(confirmnewpwd)) {
					// �޸�
					admin.setApwd(newpwd);
					System.out.println(newpwd);
					adminDAO.update(admin);
					response.sendRedirect("adminlist.do");

				} else {
					System.out.println("�������벻һ��");
					request.setAttribute("admin", admin);
					request.setAttribute("error_msg1", "�������벻һ��");
					request.getRequestDispatcher("admin_load.jsp").forward(request, response);
				}
			} else {

				System.out.println("���������벻��ȷ");
				request.setAttribute("admin", admin);
				request.setAttribute("error_msg2", "�����벻��ȷ");

				request.getRequestDispatcher("admin_load.jsp").forward(request, response);
			}

		} else if ("/productlist".equals(path)) {
			List<Product> products = pdao.findAll();
			request.setAttribute("products", products);
			request.getRequestDispatcher("products.jsp").forward(request, response);

		}

		// ���������Ʒ
		else if ("/productaddload".equals(path)) {
			List<Category> categories = categoryDAO.findAll();
			request.setAttribute("categories", categories);
			System.out.println(categories);
			request.getRequestDispatcher("products_add.jsp").forward(request, response);

		}
		// �����Ʒ
		else if ("/productadd".equals(path)) {
			String name = request.getParameter("name");
			String descr = request.getParameter("descr");
			Double normalprice = Double.parseDouble(request.getParameter("normalprice"));
			Integer categoryid = Integer.parseInt(request.getParameter("categoryid"));

			Category category = categoryDAO.findById(categoryid);
			pdao.add(new Product(name, descr, normalprice, null, category));
			response.sendRedirect("productlist.do");

		}
		// ��½�߼�
		else if ("/login".equals(path)) {

			String apwd = request.getParameter("apwd");
			String aname = request.getParameter("aname");
			// ��֤��
			String code = request.getParameter("admincode");

			HttpSession session = request.getSession();
			String sessionCode = (String) session.getAttribute("admincode");

			Admin admin = adminDAO.findByAname(aname);
			// ��½ҵ���߼�
			if (code.equals(sessionCode)) {

				if (admin != null) {
					// �ж�����
					if (apwd.equals(admin.getApwd())) {
						//��֤�û��Ƿ��½
						session.setAttribute("admin", admin);
						
						
						
						// ȥ��½
						response.sendRedirect("index.jsp");
					} else {
						request.setAttribute("login_msg", "�û������������");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}

				} else {
					request.setAttribute("login_msg", "�û������������");
					request.getRequestDispatcher("login.jsp").forward(request, response);

				}
			} else {
				request.setAttribute("code_msg", "��֤�����");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
