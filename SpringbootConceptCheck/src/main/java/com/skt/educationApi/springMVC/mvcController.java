package com.skt.educationApi.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user1")
public class mvcController {

	/*
	I am facing a issue like when i put @restController at class level it won't make session user1 bcoz
	
	@SessionAttributes("user1") only works in Spring MVC controllers returning views (Thymeleaf/JSP).
    It promotes model attributes → session only when rendering a view.
    In your case, you are using @RestController, which bypasses the view rendering phase.
    That’s why "user1" never makes it into the session → "expected session attribute 'user1'" error.
	
	With @RestController, you usually don’t rely on @SessionAttributes.
    Instead, you should work with HttpSession or @SessionAttribute directly
	*/
	
	@GetMapping("/start")
    public String start(Model model) {
		Student usr = new Student();
		//usr.setName("sonu");
        model.addAttribute("user1", usr);
        return "hello";
    }

	@GetMapping("/saveStep1")
	@ResponseBody
    public String saveStep1(@ModelAttribute("user1") Student user) {
        // 'user' is automatically retrieved from session and updated
    	    user.setName("sonu");
    	    System.out.println(" name set in savestep1 method");
        return "hello name is = "+user.getName();
    }

    @GetMapping("/profile")
    public String showProfile(@ModelAttribute("user1") Student user) {
        // Fetches 'user' from HttpSession directly
    	    System.out.println("name fetch from profile name is = "+user.getName());
        return " hello name is = "+user.getName();
    }
    
}
