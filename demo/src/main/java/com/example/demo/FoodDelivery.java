package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public interface FoodDelivery {
	void order(String food);
}
