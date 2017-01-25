package edu.ap.rest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.resource.ClientResource;

public class HospitalClient {

    // http://hc.apache.org/
     public static void main(String[] args) {
           
             try {
            	ClientResource resource = new ClientResource("http://127.0.0.1:8181/hospital/registrations");
            	// Post a new record
            	JSONObject json = new JSONObject(); //Nieuwe registratie aanmaken
            	
            	json.put("date", "25/01/2017"); //Registratie invullen en een eerste keer posten
            	json.put("name", "Jordy Mous");
            	json.put("dateOfBirth", "10/01/1996");
            	json.put("doctorName", "Dr Pepper");
            	json.put("diagnosis", "Alcoholvergifteging");
            	
        		resource.post(json.toString());
            	
            	json.put("date", "28/03/2018");	//Registratie aanpassen en een tweede keer posten
            	json.put("name", "Spongebob Squarepants");
            	json.put("dateOfBirth", "01/01/1901");
            	json.put("doctorName", "Dr Dré");
            	json.put("diagnosis", "Mentale Stoornis");
            	
        		resource.post(json.toString());
            	
            	// Write the response entity on the console
            	resource.get().write(System.out);
            	System.out.println();
            	// Process the resource
                JSONObject obj1 = new JSONObject(resource.get(String.class));
                JSONArray array1 = obj1.getJSONArray("result");
               
                for(int i = 0; i < array1.length(); i++) {
                    JSONObject obj2 = array1.getJSONObject(i);
                    System.out.println(obj2.toString());
                 }
            }
            catch (Exception e) {
                System.out.println("In main : " + e.getMessage());
            }
        }
    }
