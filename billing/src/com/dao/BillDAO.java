package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.factory.DbFactory;
import com.model.BillModel;
public class BillDAO {
	Connection con=null;
	DbFactory db;
	PreparedStatement ps;
	ResultSet rs;
	BillModel ve;
	int result;
	List<BillModel> l;
	float tax1;
	float promotions1;
	float currentactivity;
	float credit;
	float previouspay;
	public BillDAO()
	{
		db=new DbFactory();
		con=db.getOrcaleCon();
	}
	
	
	public List<BillModel> Tp(int custid,int invoiceid)//TAX AND PROMOTIONS
	{
		BillModel r;
		List<BillModel> l4=new ArrayList<BillModel>();
		try
		{
			PreparedStatement prepst=con.prepareStatement("select sum(tax),sum(spl_prom) from invoice_details where cust_id=? and invoice_id=?");
			prepst.setInt(1,custid);
		    prepst.setInt(2,invoiceid);
		    
			ResultSet rs1=prepst.executeQuery();
			while(rs1.next())
			{
				r=new BillModel();
				r.setTax(rs1.getFloat(1));
				r.setPromotions(rs1.getFloat(2));
				tax1=rs1.getFloat(1);
				promotions1=rs1.getFloat(2);
	            l4.add(r);
				
			}
			
			
		
		}
		catch(Exception ee)
		{
			System.out.println("1");
		}
		return l4;
	
	}
	
	
	public List<BillModel> Prev_bal(int custid,int invoiceid)
	{
		BillModel r;
		List<BillModel> l4=new ArrayList<BillModel>();
		try
		{
			PreparedStatement prepst=con.prepareStatement("select current_bill_amount,amount_paid,current_due,past_due from payment  where cust_id=? and bill_gen_date = (select max(bill_gen_date) from payment where cust_id=? and bill_gen_date < (select bill_gen_date from payment where invoice_id=?))");
			prepst.setInt(1,custid);
			prepst.setInt(2,custid);
			prepst.setInt(3,invoiceid);
			ResultSet rs1=prepst.executeQuery();
			
			while(rs1.next())
			{
				r=new BillModel();
				r.setCustID(rs1.getInt(1));
	            r.setPrevious_balance(rs1.getFloat(3)+rs1.getFloat(2));
	            r.setPaid_amount(rs1.getFloat(2));
	            r.setCurrent_due(rs1.getFloat(3));
	            r.setNewchargesby(rs1.getFloat(1)+rs1.getFloat(4));
	            credit=rs1.getFloat(3)+rs1.getFloat(2);
	            previouspay=rs1.getFloat(2);
	            l4.add(r);
				
			}
			
			
		
		}
		catch(Exception ee)
		{
			System.out.println("2");
		}
		return l4;
	
	}
	public List<BillModel> Invoicebreakup(int custid,int invoiceid)
	{
	
		BillModel e1;
		List<BillModel> l=new ArrayList<BillModel>();
		try
		{
			PreparedStatement ps1=con.prepareStatement("select prod_id,ps_desc,amount,ps_quantity,charge_start_date,charge_end_date,tax from invoice_details where cust_id=? and invoice_id=? and finalise=? ");
			String finalise="y";
			ps1.setInt(1,custid);
			ps1.setInt(2,invoiceid);
			ps1.setString(3,finalise);

		
			ResultSet rs1=ps1.executeQuery();
		
			while(rs1.next())
			{
				e1=new BillModel();
			
				e1.setProd_id(rs1.getString(1));
				e1.setPs_desc(rs1.getString(2));
				e1.setPs_quantity(rs1.getInt(4));
				float totalamount=rs1.getFloat(3);
				e1.setProduct_amount(totalamount);
				e1.setChargeStartDate(rs1.getDate(5));
				e1.setChargeEndDate(rs1.getDate(6));
				l.add(e1);
			}
			return l;
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
		return l;
	}
	public List<BillModel> Cust_Info(int custid)
	{
		BillModel e2;
		List<BillModel> l1=new ArrayList<BillModel>();
		try
		{
			PreparedStatement ps2=con.prepareStatement("select customer_fname,customer_mobile_no from customer where customer_id=? ");
			ps2.setInt(1,custid);
			ResultSet rs1=ps2.executeQuery();
			while(rs1.next())
			{
				e2=new BillModel();
				e2.setCust_name(rs1.getString(1));
				e2.setCust_mobile_no(rs1.getInt(2));
				l1.add(e2);
				
			}
			
			return l1;
		
		}
		catch(Exception ee)
		{
			System.out.println("4");
		}
		return l1;
	
	}
	public List<BillModel> Payment_Info(int custid,int invoiceid)
	{
		BillModel e3;
		List<BillModel> l3=new ArrayList<BillModel>();
		try
		{
			PreparedStatement ps3=con.prepareStatement("select current_due,current_bill_amount,past_due,bill_gen_date,cust_id,amount_paid from payment where cust_id=? and invoice_id=?");
			ps3.setInt(1,custid);
			ps3.setInt(2,invoiceid);
			ResultSet rs1=ps3.executeQuery();
			while(rs1.next())
			{
				e3=new BillModel();
				e3.setCurrent_due(rs1.getFloat(1));
				e3.setBilled_amount(rs1.getFloat(2));
				e3.setPaid_amount(rs1.getInt(6));
				e3.setCredit_balance(rs1.getInt(3));
				Date d=new Date(rs1.getDate(4).getTime());
				Calendar cal=Calendar.getInstance();
				cal.setTime(d);
				cal.add(Calendar.DATE,10);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String reportDate = df.format(cal.getTime());
				e3.setBilled_date(reportDate);
				e3.setCustID(rs1.getInt(5));
				 currentactivity=rs1.getFloat(2)+promotions1-tax1;
				 Float newchargesby=rs1.getFloat(2)+credit;
				e3.setCurrent_activity(currentactivity);
				e3.setNewchargesby(newchargesby-previouspay);
				l3.add(e3);				
			}		
		}
		catch(Exception ee)
		{
			System.out.println("5");
		}
		return l3;
	
	}
	
	
}