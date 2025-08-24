package com.cart.shoppingCart;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cart.shoppingCart.Tool.ShoppingCartMCPServer;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

	@Bean
	public List<ToolCallback> shoppingCartToolCallback(ShoppingCartMCPServer cartMcpService){
		return List.of(ToolCallbacks.from(cartMcpService));
	}
	
}
