package com.Hanzlaweb.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//Adduser
		@RequestMapping("/checkuser")
		@ResponseBody
		public void Adduser(HttpServletRequest request){
			String  email =request.getParameter("email");
			System.out.println("This is user email   " + email);
			String  password =request.getParameter("password");
			System.out.println("This is user paswoord   " + password);
			String query = "SELECT email FROM log WHERE (email=?)";
			Object result1 = jdbcTemplate.queryForObject(query, new Object[]{email}, String.class);
			System.out.println(result1);
			String query2 = "SELECT password FROM log WHERE (password=?)";
			Object result2 = jdbcTemplate.queryForObject(query2, new Object[]{password}, String.class);
			System.out.println(result2);
			System.out.println("Successfully Loged In");
			


		}
	

}
