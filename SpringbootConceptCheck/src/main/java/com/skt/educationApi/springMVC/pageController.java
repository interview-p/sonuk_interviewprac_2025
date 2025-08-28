package com.skt.educationApi.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class pageController {

	@GetMapping("/modelcheck")
    public String hellos(Model model) {
        model.addAttribute("name", "Sonu");
        return "hello";  // resolves to hello.html via Thymeleaf
    }
}
