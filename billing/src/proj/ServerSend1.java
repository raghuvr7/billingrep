package proj;

import javax.jws.WebMethod;
import javax.jws.WebService;

import web.Connection1;


@WebService
public class ServerSend1 {
	
	
	@WebMethod
	public String updateTable(int custId){
		Connection1.custId=custId;		
		return "succesful";
	}
	



}
