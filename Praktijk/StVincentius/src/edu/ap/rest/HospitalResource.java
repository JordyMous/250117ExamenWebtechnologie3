package edu.ap.rest;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.ap.jdbc.JDBConnection;

public class HospitalResource extends ServerResource {

	@Get
	public String allRegistrations() {
		
		JDBConnection c = JDBConnection.getJDBConnection();
		c.openConnection("hospital", "root", "");
		ArrayList<String> resultArray = c.selectAll();
		c.closeConnection();
		
		JSONObject json = new JSONObject();
		json.put("operation", "selectAll");
		json.put("length", resultArray.size());
		JSONArray jsonArray = new JSONArray();
		
		int i = 0;
		for(String s : resultArray) {
			JSONObject obj = new JSONObject();
			obj.put("" + i, s);
			jsonArray.put(obj);
			i++;
		}
		
		json.put("result", jsonArray);

		return json.toString();
	}
	
	@Post("txt")
	public void newRegistration(String json) {
		
		JSONObject newRegistration = new JSONObject(json);
		
		String date = newRegistration.getString ("date");
		String name = newRegistration.getString ("name");
		String dateOfBirth = newRegistration.getString("dateOfBirth");
		String doctorName = newRegistration.getString("doctorName");
		String diagnosis = newRegistration.getString("diagnosis");
				
		JDBConnection c = JDBConnection.getJDBConnection();
		c.openConnection("registrations", "root", "");
		c.executeInsert("registrations", date, name, dateOfBirth, doctorName, diagnosis);
		c.closeConnection();
	}
}