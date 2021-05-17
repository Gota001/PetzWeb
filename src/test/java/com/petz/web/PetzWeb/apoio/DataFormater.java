package com.petz.web.PetzWeb.apoio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormater {
	
	final static Date currentTime = new Date();
	final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	
	public static String data(){
		String d = sdf.format(currentTime);
		return d;
	}

}
