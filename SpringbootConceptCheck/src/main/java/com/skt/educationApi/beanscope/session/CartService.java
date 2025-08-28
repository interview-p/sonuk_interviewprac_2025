package com.skt.educationApi.beanscope.session;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	 private final ShoppingCart shoppingCart;

	    @Autowired
	    public CartService(ShoppingCart shoppingCart) {
	        this.shoppingCart = shoppingCart;
	    }

	    public void addProduct(String product) {
	        shoppingCart.addItem(product);
	    }

	    public List<String> viewCart() {
	        return shoppingCart.getItems();
	    }

	    public void clearCart() {
	        shoppingCart.clear();
	    }
}
