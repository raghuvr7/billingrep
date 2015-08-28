package billing;

import java.sql.Date;

public class Customers{
	int id;
	Date date;
	int invoiceid;
	int amountpaid;
	public int getAmountpaid() {
		return amountpaid;
	}
	public void setAmountpaid(int amountpaid) {
		this.amountpaid = amountpaid;
	}
	public int getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}
	public Customers(int id, Date date,int invoiceid,int amountpaid) {
		super();
		this.id = id;
		this.date = date;
		this.invoiceid=invoiceid;
		this.amountpaid=amountpaid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}

