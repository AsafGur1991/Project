package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import core.ClientType;
import core.CouponSystem;
import exceptions.CompanyExceptionHandler;
import exceptions.CustomerExceptionHandler;
import exceptions.GeneralExceptionHandler;
import exceptions.NullConnectionException;
import exceptions.WrongDataInputException;
import facade.CouponClientFacade;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        
    }

	/**
	 * this method gathers the information that the client filled in the login page
	 * and invoke the login method in the CouponSystem class.
	 * if the information is correct, then the method saves the login information
	 * in 3 cookies and saves the facade that was returned from the login
	 * method on the client's session so it can be retrieved later.
	 * then the servlet sends a response with a redirect to the application web page,
	 * according to the client type.
	 * 
	 * @param username the user name from the login page input
	 * @param password the password from the login page input
	 * @param client the client type from the login page input
	 * 
	 * @see CouponSystem#login(String, String, ClientType)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		ClientType client = ClientType.valueOf(request.getParameter("client"));
		PrintWriter out = response.getWriter();
		
		CouponClientFacade facade = null;
		
			switch (client)
			{
			case CUSTOMER :
				try {
					facade = CouponSystem.getInstance().login(name, password, client);
				} catch (ClassNotFoundException | InterruptedException | SQLException | WrongDataInputException
						| NullConnectionException e) {
					out.println(CustomerExceptionHandler.customerExceptionHandle(e));
				}
				if (facade != null)
				{
					request.getSession().setAttribute("facade", facade);
					Cookie ck1 = new Cookie("userName",name);
					response.addCookie(ck1);
					Cookie ck2 = new Cookie("password",password);
					response.addCookie(ck2);
					Cookie ck3 = new Cookie("client","CUSTOMER");
					response.addCookie(ck3);
					response.sendRedirect("http://localhost:8080/webCouponNew/customerSPA/customer.html");
					
				}
				else
				{
					response.sendRedirect("http://localhost:8080/webCouponNew/login/loginError.html");					
				}
				break;
			case COMPANY :
				try {
					facade = CouponSystem.getInstance().login(name, password, client);
				} catch (ClassNotFoundException | InterruptedException | SQLException | WrongDataInputException
						| NullConnectionException e) {
					out.println(CompanyExceptionHandler.companyExceptionHandler(e));
				}
				if (facade != null)
				{
					request.getSession().setAttribute("facade", facade);
					Cookie ck1 = new Cookie("userName",name);
					response.addCookie(ck1);
					Cookie ck2 = new Cookie("password",password);
					response.addCookie(ck2);
					Cookie ck3 = new Cookie("client","COMPANY");
					response.addCookie(ck3);
					response.sendRedirect("http://localhost:8080/webCouponNew/companySPA/company.html");
				}
				else
				{
					response.sendRedirect("http://localhost:8080/webCouponNew/login/loginError.html");
				}
				break;
			case ADMIN :
				try {
					facade = CouponSystem.getInstance().login(name, password, client);
				} catch (ClassNotFoundException | InterruptedException | SQLException | WrongDataInputException
						| NullConnectionException e) {
					out.println(GeneralExceptionHandler.generalExceptionHandle(e));
				}
				if (facade != null)
				{
					request.getSession().setAttribute("facade", facade);
					Cookie ck1 = new Cookie("userName",name);
					response.addCookie(ck1);
					Cookie ck2 = new Cookie("password",password);
					response.addCookie(ck2);
					Cookie ck3 = new Cookie("client","ADMIN");
					response.addCookie(ck3);
					response.sendRedirect("http://localhost:8080/webCouponNew/adminSPA/admin.html");
				}
				else
				{
					response.sendRedirect("http://localhost:8080/webCouponNew/login/loginError.html");					
				}
				break;
			
			}
			
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
