package com.example.demo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class FoodPanda implements FoodDelivery{
	
	private int NumOrder;
	
	@PostConstruct
	public void init() {
		NumOrder = 0;
	}
	
	@Override
	public void order(String food) {
		// TODO Auto-generated method stub
		NumOrder ++;
		System.out.println("Order "+ food + " at FoodPanda ");
		System.out.println("The Number of Order: " + NumOrder);
	}
	
	

}
