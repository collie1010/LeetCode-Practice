package com.example.demo;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class Uber implements FoodDelivery{
	
	@Value("${num}")
	private int NumOrder;
	
	/*@PostConstruct
	public void init() {
		NumOrder = 0;
	}*/
	
	@Override
	public void order(String food) {
		// TODO Auto-generated method stub
		
		
		NumOrder ++;
		System.out.println("Order "+ food + " at Uber");
		System.out.println("The Number of Order: " + NumOrder);
		
	
	}
	
}
