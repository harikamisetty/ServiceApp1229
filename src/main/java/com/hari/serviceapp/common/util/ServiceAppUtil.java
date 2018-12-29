package com.hari.serviceapp.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class ServiceAppUtil {
	
	public static  String getRandonString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public static String getDateAsString() {
		// Create an instance of SimpleDateFormat used for formatting 
	     // the string representation of date (month/day/year)
	     DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	     // Get the date today using Calendar object.
	     Date today = Calendar.getInstance().getTime();        
	     // Using DateFormat format method we can create a string 
	     // representation of a date with the defined format.
	     String reportDate = df.format(today);

	     // Print what date is today!
	     return reportDate;
	}
	
	public static  String getAddressid() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        salt.append("ADD");
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public static  String getRequestString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        salt.append("REQ");
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
