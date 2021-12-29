package com.spring.batch.service;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.spring.batch.model.User;

@Service
public class JobService {
	
	private List<User> listOfUsers;
	
	public void setList(List<User> list) {
		this.listOfUsers = list;
	}
	
	public List<User> getList() {
		return this.listOfUsers;
	}
	
	public void createExecelFile() {
		
		try {
			
			String filename = "C:/temp/list_of_users.xls" ;
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet sheet = workbook.createSheet("UserSheet");
	        
	        HSSFRow rowhead = sheet.createRow((short)1);
	        rowhead.createCell(0).setCellValue("ID");
	        rowhead.createCell(1).setCellValue("NAME");
	        rowhead.createCell(2).setCellValue("USERNAME");
	        rowhead.createCell(3).setCellValue("EMAIL");
	        rowhead.createCell(4).setCellValue("STREET");
	        rowhead.createCell(5).setCellValue("SUITE");
	        rowhead.createCell(6).setCellValue("CITY");
	        rowhead.createCell(7).setCellValue("ZIPCODE");
	        rowhead.createCell(8).setCellValue("LAT");
	        rowhead.createCell(9).setCellValue("LNG");
	        rowhead.createCell(10).setCellValue("PHONE");
	        rowhead.createCell(11).setCellValue("WEBSITE");
	        rowhead.createCell(12).setCellValue("COMPANYNAME");
	        rowhead.createCell(13).setCellValue("CATCHPHRASE");
	        rowhead.createCell(14).setCellValue("BS");
	        

	        for (int i = 0; i < listOfUsers.size(); i ++) {
					
		            HSSFRow row = sheet.createRow((short)i + 2);
		            row.createCell(0).setCellValue(listOfUsers.get(i).getId());
		            row.createCell(1).setCellValue(listOfUsers.get(i).getName());
		            row.createCell(2).setCellValue(listOfUsers.get(i).getUsername());
		            row.createCell(3).setCellValue(listOfUsers.get(i).getEmail());
		            row.createCell(4).setCellValue(listOfUsers.get(i).getAdress().getStreet());
		            row.createCell(5).setCellValue(listOfUsers.get(i).getAdress().getSuite());
		            row.createCell(6).setCellValue(listOfUsers.get(i).getAdress().getCity());
		            row.createCell(7).setCellValue(listOfUsers.get(i).getAdress().getZipcode());
		            row.createCell(8).setCellValue(listOfUsers.get(i).getAdress().getGeo().getLat());
		            row.createCell(9).setCellValue(listOfUsers.get(i).getAdress().getGeo().getLng());
		            row.createCell(10).setCellValue(listOfUsers.get(i).getPhone());
		            row.createCell(11).setCellValue(listOfUsers.get(i).getWebsite());
		            row.createCell(12).setCellValue(listOfUsers.get(i).getCompany().getName());
		            row.createCell(13).setCellValue(listOfUsers.get(i).getCompany().getCatchPhrase());
		            row.createCell(14).setCellValue(listOfUsers.get(i).getCompany().getBs());
					
	        }
	        
	     
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("YOUR EXECEL FILE HAS BEEN GENERATED AND SAVE ON " + filename);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

        
	}


}
