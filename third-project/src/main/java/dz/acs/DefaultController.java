package dz.acs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("def")
public class DefaultController {
	
	@RequestMapping("start")	
	public ModelAndView def() {
		
		ModelAndView mav = new ModelAndView("start","message", "Fast WEBMVC project");		
		return mav ;
	}
	
	

}
