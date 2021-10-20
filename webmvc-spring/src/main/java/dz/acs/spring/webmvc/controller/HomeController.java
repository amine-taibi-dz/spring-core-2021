package dz.acs.spring.webmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dz.acs.spring.webmvc.model.User;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		
		return new ModelAndView("home","elit","hello Spring");
	}
	
	@RequestMapping(value="/ident")
	public String ident(ModelMap mm) throws IOException{
		
		mm.addAttribute("elit", "Identification");
		mm.addAttribute("user", new User("ataibi", "ataibi@gmail.com"));
		return "home";
	}
}
