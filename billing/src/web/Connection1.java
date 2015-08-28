package web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import proj.ServerSend1;
import billing.Customers;
import billing.Implementation;

@WebServlet("/Connection1")
public class Connection1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int custId=-1;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int empcode=Integer.parseInt(request.getParameter("id"));
	Implementation dao = new Implementation(); 
	List<Customers> cust= dao.getBills(empcode);  
	request.setAttribute("l", cust); 
	request.setAttribute("l1",empcode); 
	RequestDispatcher rd = request.getRequestDispatcher("viewBills.jsp");
	
	rd.forward(request, response); 
	
	
	
	}

}
