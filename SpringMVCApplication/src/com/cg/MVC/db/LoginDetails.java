package com.cg.MVC.db;

import java.util.HashMap;
import java.util.Map;

public class LoginDetails {
	private HashMap<String,String> details=new HashMap<>();
	
	public HashMap<String, String> getDetails() {
		return details;
	}

	public void setDetails(HashMap<String, String> details) {
		this.details = details;
	}

	public Map<String, String> addDetails(String mobno,String password){
		details.put(mobno, password);
		return details;
	}
	
}
