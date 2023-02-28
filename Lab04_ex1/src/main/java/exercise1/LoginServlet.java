package exercise1;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String,String> account;
       

    public LoginServlet() {
        super();
        this.account = data();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(checkAcc(username, password)) {
			response.getWriter().write("<html><body><p>Account match!!!</p></body></html>");
		}
		else {
			//response.sendRedirect("/index.jsp");
			response.getWriter().write("<html><body><p>Account don't match!!!</p></body></html>");
		}
		
	}
	
	private HashMap<String,String> data() {
		HashMap<String,String> account = new HashMap<String, String>();
		String[] username = {"52000129", "admin", "52000123"};
		String[] pass = {"12345" , "123456", "1234567"};
		for(int i = 0; i < username.length; i++) {
			account.put(username[i], pass[i]);
		}
		return account;
	}
	
	@SuppressWarnings("unused")
	private boolean checkAcc(String username, String password) {
		return account.get(username).equals(password);
	}

}
