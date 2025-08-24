package com.cart.shoppingCart.Tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import com.cart.shoppingCart.Entity.Model.CartItem;

@Service
public class ShoppingCartMCPServer {

	
	private static final Map<String, Double> PRODUCTS = Map.of(
            "iPhone", 79999.0,
            "MacBook Air", 129999.0,
            "Boat Airdopes", 1999.0
    );
	
	private static final Map<String,CartItem> cart = new HashMap<>();
	
	@Tool(name = "addToCart",
            description = "Add a product to the shopping cart. If the product already exists, it updates the quantity.")
    public String addToCart(@ToolParam String productName, @ToolParam int quantity){

        if(!PRODUCTS.containsKey(productName)){
            return "product not found";
        }

        Double price = PRODUCTS.get(productName);

        CartItem cartItem= cart.getOrDefault(productName, null);

        if(cartItem==null){
            cartItem = new CartItem();
            cartItem.setProductName(productName);
            cartItem.setQuantity(quantity);
        }else{
            cartItem.setQuantity(cartItem.getQuantity()+quantity);
        }
        cartItem.setPrice(cartItem.getQuantity()*price);
        cart.put(productName, cartItem);
        return quantity + " " + productName + " added to cart. Total price: " + (cartItem.getPrice());
    }
	
	    @Tool(
	            name = "removeCart",
	            description = "Remove a product from the shopping cart."
	    )
	    public String removeCart(@ToolParam String productName){
	        cart.remove(productName);
	        return productName + " removed from cart.";
	    }

	    @Tool(
	            name = "getCarts",
	            description = "Retrieve the current shopping cart items."
	    )
	    public List<CartItem> getCarts(){
	    	   List<CartItem> allProduct = new ArrayList<>(cart.values());
	    	   return allProduct;
	    }
	
}
