package vaalikone;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckAdmin extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println(request);
		final String Password = request.getParameter("Password");
		final String User = request.getParameter("User");

		if (crypt(Password).equals(crypt("admin")) && User.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", "admin");
			session.setAttribute("limit-total", 0);
			session.setAttribute("limitCached", 0);
			/*request.getRequestDispatcher("Admin.jsp")
			.forward(request, response);*/
			response.sendRedirect("Admin.jsp");
		} else {
			String error;
			error = "User or Password  is wrong!";
			request.setAttribute("viesti", error);
			/*request.getRequestDispatcher("LogAdm.jsp")
			.forward(request, response);*/
			response.sendRedirect("LogAdm.jsp");

		}
	}
	public String crypt(String str) {
		if (str == null || str.length() == 0) {
			//throw new IllegalArgumentException("String to encrypt cannot be null or zero length");
			return "";
		}

		MessageDigest digester;
		try {
			digester = MessageDigest.getInstance("MD5");

			digester.update(str.getBytes());
			byte[] hash = digester.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
		
	}
	 
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    	//System.out.println(request);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}