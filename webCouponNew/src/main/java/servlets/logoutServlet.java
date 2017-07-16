package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logoutServlet
 */
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * this method creates 3 new cookies with no values and a life span of zero,
	 * and replaces the cookies that was saved by the login servlet, and removes the
	 * facade that the login servlet saved from the client's session.
	 * the the servlet sends a response with a redirect to the login page.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("facade");
		Cookie ck1 = new Cookie("userName","");
		ck1.setMaxAge(0);
		response.addCookie(ck1);
		Cookie ck2 = new Cookie("password","");
		ck2.setMaxAge(0);
		response.addCookie(ck2);
		Cookie ck3 = new Cookie("client","");
		ck3.setMaxAge(0);
		response.addCookie(ck3);
		response.sendRedirect("http://localhost:8080/webCouponNew/login/login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
