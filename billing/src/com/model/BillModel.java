package com.model;

import java.sql.Date;

public class BillModel {	
	int custID;
	float product_amount;
	float current_activity;
	public float getCurrent_activity() {
		return current_activity;
	}
	public void setCurrent_activity(float current_activity) {
		this.current_activity = current_activity;
	}
	public float getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(float product_amount) {
		this.product_amount = product_amount;
	}
	String cust_name,ps_desc;
	float previous_balance;
	int ps_quantity;
	String prod_id;
	Date chargeStartDate;
	public Date getChargeStartDate() {
		return chargeStartDate;
	}
	public void setChargeStartDate(Date chargeStartDate) {
		this.chargeStartDate = chargeStartDate;
	}
	public Date getChargeEndDate() {
		return chargeEndDate;
	}
	public void setChargeEndDate(Date chargeEndDate) {
		this.chargeEndDate = chargeEndDate;
	}
	Date chargeEndDate;
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String string) {
		this.prod_id = string;
	}
	public String getPs_desc() {
		return ps_desc;
	}
	public void setPs_desc(String ps_desc) {
		this.ps_desc = ps_desc;
	}
	public int getPs_quantity() {
		return ps_quantity;
	}
	public void setPs_quantity(int ps_quantity) {
		this.ps_quantity = ps_quantity;
	}
	public float getPrevious_balance() {
		return previous_balance;
	}
	public void setPrevious_balance(float previous_balance) {
		this.previous_balance = previous_balance;
	}
	float promotions,tax,new_charges;
	public float getNew_charges() {
		return new_charges;
	}
	public void setNew_charges(float new_charges) {
		this.new_charges = new_charges;
	}
	public float getPromotions() {
		return promotions;
	}
	public void setPromotions(float promotions) {
		this.promotions = promotions;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public int getCust_mobile_no() {
		return cust_mobile_no;
	}
	public void setCust_mobile_no(int cust_mobile_no) {
		this.cust_mobile_no = cust_mobile_no;
	}
	int cust_mobile_no;
	
	public Date getCharge_end_date() {
		return charge_end_date;
	}
	public void setCharge_end_date(Date charge_end_date) {
		this.charge_end_date = charge_end_date;
	}
	Date charge_end_date;
	float current_due;
	float credit_balance;
	float final_balance;
	float newchargesby;
	public float getNewchargesby() {
		return newchargesby;
	}
	public void setNewchargesby(float newchargesby) {
		this.newchargesby = newchargesby;
	}
	public float getFinal_balance() {
		return final_balance;
	}
	public void setFinal_balance(float final_balance) {
		this.final_balance = final_balance;
	}
	public float getCredit_balance() {
		return credit_balance;
	}
	public void setCredit_balance(float credit_balance) {
		this.credit_balance = credit_balance;
	}
	public float getCurrent_due() {
		return current_due;
	}
	public void setCurrent_due(float current_due) {
		this.current_due = current_due;
	}
	String billed_date;
	public String getBilled_date() {
		return billed_date;
	}
	public void setBilled_date(String billed_date) {
		this.billed_date = billed_date;
	}
	float billed_amount;
	float paid_amount;
	int product_id;
	Date paid_date;
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	
	
	public float getBilled_amount() {
		return billed_amount;
	}
	public void setBilled_amount(float billed_amount) {
		this.billed_amount = billed_amount;
	}
	public float getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(float paid_amount) {
		this.paid_amount = paid_amount;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Date getPaid_date() {
		return paid_date;
	}
	public void setPaid_date(Date paid_date) {
		this.paid_date = paid_date;
	}
	
}
