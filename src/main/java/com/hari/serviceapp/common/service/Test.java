package com.hari.serviceapp.common.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test {
	
	public static void main(String a[]) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        salt.append("add");
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        System.out.println("Random String........"+ saltStr);
        
     // Create an instance of SimpleDateFormat used for formatting 
     // the string representation of date (month/day/year)
     DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

     // Get the date today using Calendar object.
     Date today = Calendar.getInstance().getTime();        
     // Using DateFormat format method we can create a string 
     // representation of a date with the defined format.
     String reportDate = df.format(today);

     // Print what date is today!
     System.out.println("Report Date: " + reportDate);
     
     String sDate1="31/12/1998";
     Date date1 = null;;
	try {
		date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     System.out.println(sDate1+"\t"+date1);
    }
}
