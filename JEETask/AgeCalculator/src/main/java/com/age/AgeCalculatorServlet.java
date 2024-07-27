package com.age;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/age")
public class AgeCalculatorServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String dob=req.getParameter("dob");
		String date=req.getParameter("date");
		List<String> birthData=Arrays.asList(dob.split("-"));
		List<String> dateData=Arrays.asList(date.split("-"));
		int totalDays=Integer.parseInt(dateData.get(2))-Integer.parseInt(birthData.get(2));
		int totalMonths=Integer.parseInt(dateData.get(1))-Integer.parseInt(birthData.get(1));
		int totalYears=Integer.parseInt(dateData.get(0))-Integer.parseInt(birthData.get(0));
		
		int ageDays=totalDays+totalMonths*30+totalYears*365;
		int ageHours=ageDays*24;
		int ageMins=ageHours*60;
		int ageSecs=ageMins*60;
		
		PrintWriter out=res.getWriter();
		out.println("<html>"
				+ "<head>\r\n"
				+ "    <style>\r\n"
				+ "        .header-bar {\r\n"
				+ "            background-color: #4caf50;\r\n"
				+ "            color: white;\r\n"
				+ "            padding: 15px;\r\n"
				+ "            text-align: center;\r\n"
				+ "            font-size: 24px;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"header-bar\">\r\n"
				+ "        Result\r\n"
				+ "    </div>\r\n"
				+ "    <h1>Age:</h1>\r\n"
				+ "    <p><var>"+ageDays +" days</var></p>\r\n"
				+ "    <p><var>or "+ageHours +" Hours</var></p>\r\n"
				+ "    <p><var>or "+ageMins +" Minutes</var></p>\r\n"
				+ "    <p><var>or "+ageSecs +" Seconds</var></p>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
	}

}
