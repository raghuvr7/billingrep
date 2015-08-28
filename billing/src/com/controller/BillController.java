package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import com.dao.BillDAO;
import com.model.BillModel;

/**
 * Servlet implementation class BillController
 */
@WebServlet("/BillController")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			
				System.out.println(request.getParameter("V1"));
				System.out.println(request.getParameter("V2"));
				int custid=Integer.parseInt(request.getParameter("V1"));
				int invoiceid=Integer.parseInt(request.getParameter("V2"));
				BillDAO dao=new BillDAO();
				PrintWriter out=response.getWriter();
				List<BillModel> l4=dao.Tp(custid,invoiceid);
				List<BillModel> l=dao.Invoicebreakup(custid,invoiceid);
				List<BillModel> l1=dao.Cust_Info(custid);
				List<BillModel> l3=dao.Prev_bal(custid,invoiceid);
				List<BillModel> l2=dao.Payment_Info(custid,invoiceid);
				//if(!l1.isEmpty()&&!l2.isEmpty()&&!l3.isEmpty()&&!l.isEmpty()){
				//for(BillModel b:l)
					//System.out.println("from servlet "+b.getCustID()+b.getDue_amount()); 
				if(!l1.isEmpty())
				{
					out.println("successfully inserted first servlet");
					request.setAttribute("invoicebreakup",l);
					request.setAttribute("custinfo",l1);
					request.setAttribute("payment",l2);
					request.setAttribute("previous",l3);
					request.setAttribute("tp",l4);
					RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
				    rd.forward(request, response);
				}
				else{
					
					RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
				    rd.forward(request, response);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
