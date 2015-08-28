package billing;

	import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

	public class Implementation {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	public void getDBConnection() {
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				String url="jdbc:oracle:thin:@192.168.0.146:1521:orcl";
				conn=DriverManager.getConnection(url,"hr","hr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}

		public void closeDBConnection() {

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		

		public List<Customers> getBills(int id) { 
			getDBConnection(); 
			List<Customers> l=new ArrayList<Customers>();
			Customers customers; 
			try 
			{ 
				
			pst=conn.prepareStatement("select cust_id,bill_gen_date,invoice_id,amount_paid from payment where cust_id=? order by bill_gen_date desc");
			pst.setInt(1,id);
			rs=pst.executeQuery(); 
			while(rs.next()) 
			{ 
				
		        l.add(new Customers(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4)));   
		        
			} 
			return l;
			} 
			catch(SQLException e){ 
				e.printStackTrace(); 
				return l;
			} 

			finally{ 
				closeDBConnection();
			} 
			}

	}
	
	