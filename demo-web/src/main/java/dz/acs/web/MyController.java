package dz.acs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/home")
	public String home(ModelMap mm) {
		mm.addAttribute("message", "ELIT DEMO");
		
		mm.addAttribute("title", "HELLO");
		
		mm.addAttribute("user_list", null);
		return "test";
		
	}

}
