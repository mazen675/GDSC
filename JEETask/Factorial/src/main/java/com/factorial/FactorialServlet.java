package com.factorial;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Factorial")
public class FactorialServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		out.println("<html>"
				+ "<head> "
				+ " <style>\r\n"
				+ "        table {\r\n"
				+ "            width: 50%;\r\n"
				+ "            border-collapse: collapse;\r\n"
				+ "            margin: 25px 0;\r\n"
				+ "            font-size: 18px;\r\n"
				+ "            text-align: left;\r\n"
				+ "        }\r\n"
				+ "        th, td {\r\n"
				+ "            padding: 12px;\r\n"
				+ "            border: 1px solid #ddd;\r\n"
				+ "        }\r\n"
				+ "        th {\r\n"
				+ "            background-color: #f2f2f2;\r\n"
				+ "        }\r\n"
				+ "    </style></head>"
				+ "<body>\r\n"
				+ "    <h1>Factorial Table</h1>\r\n"
				+ "    <table>\r\n"
				+ "        <thead>\r\n"
				+ "            <tr>\r\n"
				+ "                <th>Number</th>\r\n"
				+ "                <th>Factorial</th>\r\n"
				+ "            </tr>\r\n"
				+ "        </thead>\r\n"
				+ "        <tbody>\r\n"
				+printRows(10)
				+ "        </tbody>\r\n"
				+ "    </table>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
	
	int factorial(int n) {
		if(n==0)
			return 1;
		else
			return(n*factorial(n-1));
	}
	String printRows(int size) {
		String printed="";
		for(int i=0;i<=size;i++) {
			printed+=	 "            <tr>\r\n"
					+ "                <td><var>"+ i +"</var></td>\r\n"
					+ "                <td><var>"+ factorial(i) +"</var></td>\r\n"	
					+ "            </tr>\r\n";
		}
		return printed;
	}

}
