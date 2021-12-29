package com.spring.batch.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.batch.model.Address;
import com.spring.batch.model.Company;
import com.spring.batch.model.Geolocalization;
import com.spring.batch.model.User; 

@Component
public class H2DataBase {
	
	   static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:mem:testdb";
	   
	   static final String USER = "sa"; 
	   static final String PASS = ""; 
	
	
	public void insertUser(List<User> listOfUsers) {
		
		Connection conn = null; 
	    Statement stmt = null; 
	    
	   try {
		   
	         Class.forName(JDBC_DRIVER);
	         
	         System.out.println(); 
	         System.out.println("CONNECTING TO A SELECTED DATA BASE...");
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);
	         System.out.println("CONNECTED DATABASE SUCCESSFULLY...");
	         System.out.println();
	         
	 		for (User user : listOfUsers) {
				
	         stmt = conn.createStatement();
	         String sql = "INSERT INTO TBL_USERS ( id, name, username, email, street, suite, city, zipcode, lat, lng, phone, website, companyName, catchPhrase, bs) VALUES ( '" +
	        	user.getId() + "', '" +
	        	user.getName() + "', '" +
	        	user.getUsername() + "', '" +
	        	user.getEmail() + "', '" +
	        	user.getAdress().getStreet() + "', '" +
	        	user.getAdress().getSuite() + "', '" +
	        	user.getAdress().getCity() + "', '" +
	        	user.getAdress().getZipcode() + "', '" +
	        	user.getAdress().getGeo().getLat() + "', '" +
	        	user.getAdress().getGeo().getLng() + "', '" +
	        	user.getPhone() + "', '" +
	        	user.getWebsite() + "', '" +
	        	user.getCompany().getName() + "', '" +
	        	user.getCompany().getCatchPhrase() + "', '" +
	        	user.getCompany().getBs() +
	        	"' )"; 

	         stmt.executeUpdate(sql);
	         
	 		}
	 		
	         stmt.close(); 
	         conn.close();
		
		} catch (SQLException se) {
	         se.printStackTrace(); 
		} catch(Exception e) { 
	         e.printStackTrace();			
		} finally {

	         try {
	            if(stmt!=null) stmt.close();  
	         } catch(SQLException se2) { 
	         } 
	         try { 
	            if(conn!=null) conn.close(); 
	         } catch(SQLException se) { 
	            se.printStackTrace(); 
	         } 
		}
	   
	   
	   
	}

	
	public List<User> getData() {
		
		List<User> allUsers = new ArrayList<User>();
		Connection conn = null; 
	    Statement stmt = null;
	    int index = 0;
	    
	    try {
	    	
	    	Class.forName(JDBC_DRIVER);
	    	
	         System.out.println(); 
	         System.out.println("CONNECTING TO A SELECTED DATA BASE...");
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);
	         System.out.println("CONNECTED DATABASE SUCCESSFULLY...");
	         System.out.println();
	         
	         stmt = conn.createStatement();
	            
        
	         String sql = "SELECT * FROM TBL_USERS "; 
	         ResultSet rs = stmt.executeQuery(sql);
	         
         
	         while (rs.next()) {
	        	 
				User user = new User();
				Address address = new Address();
				Geolocalization geo = new Geolocalization();
				Company company = new Company();
				
				company.setName(rs.getString("companyname"));
				company.setCatchPhrase(rs.getString("catchPhrase"));
				company.setBs(rs.getString("bs"));
						
				geo.setLat(rs.getString("lat"));
				geo.setLng(rs.getString("lng"));
				
				address.setStreet(rs.getString("street"));
				address.setSuite(rs.getString("suite"));
				address.setCity(rs.getString("city"));
				address.setZipcode(rs.getString("zipcode"));
				address.setGeo(geo);
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setAddress(address);
				user.setPhone(rs.getString("phone"));
				user.setWebsite(rs.getString("website"));
				user.setCompany(company);

				allUsers.add(user);
	         }

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	    
		return allUsers;
	}
}
