package com.skt.educationApi.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.skt.educationApi.beanscope.session.ShoppingCart;

@Controller
@SessionAttributes("shcart")
public class CartControllersh {

	   @ModelAttribute("shcart")
	    public ShoppingCart initCart() {
	        System.out.println(">> New Cart Created");
	        return new ShoppingCart();
	    }

	    @GetMapping("/add")
	    public String addItem(@ModelAttribute("shcart") ShoppingCart cart) {
	        cart.getItems().add("Apple");
	        return "cartView";
	    }
}
