package com.skt.educatonApi.beanscope.session;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/carts")
public class CartController {

	private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add/{item}")
    public String addItem(@PathVariable String item) {
        cartService.addProduct(item);
        return "Added: " + item;
    }

    @GetMapping("/items")
    public List<String> viewItems() {
        return cartService.viewCart();
    }

    @PostMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "Cart cleared!";
    }
}
