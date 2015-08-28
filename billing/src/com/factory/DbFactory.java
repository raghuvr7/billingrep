package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbFactory {
	Connection con=null;
	public Connection getOrcaleCon()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded");
			con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.146:1521:orcl","hr","hr");
			con.setAutoCommit(false);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public void closeCon()
	{
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
	}
}
