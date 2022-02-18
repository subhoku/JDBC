package com.codeo.pool.datasource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropsTest {

	public static void main(String[] args) {
		InputStream is=null;
		Properties props=null;
		try {
			//Locate Properties file Using STreams
			is=new FileInputStream("src/com/codeo/pool/commons/PersonalInfo.properties");
			//create Properties class object
			props=new Properties();
			props.load(is);
			System.out.println("Properties file info::"+props);
			System.out.println("...........................");
			System.out.println("name is::"+props.getProperty("name"));
			System.out.println("age is ::"+props.getProperty("age"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main

}
