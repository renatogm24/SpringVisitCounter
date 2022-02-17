package com.codingdojo.springvisitcounter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {

		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			int count = (int) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		int count = 0;
		if (session.getAttribute("count") != null) {
			count = (int) session.getAttribute("count");
		}		
		
		model.addAttribute("count", count);
		
		return "counter.jsp";
	}
	
	@RequestMapping("/countertwo")
	public String countertwo(HttpSession session, Model model) {
		int count = 0;
		if (session.getAttribute("count") != null) {
			count = (int) session.getAttribute("count");
			count += 2;
		}		
		
		session.setAttribute("count", count);
		model.addAttribute("count", count);
		
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session, Model model) {
		int count = 0;
		if (session.getAttribute("count") != null) {
			session.invalidate();
		}		
		
		//session.setAttribute("count", count);
		model.addAttribute("count", count);
		
		return "counter.jsp";
	}
	

}
