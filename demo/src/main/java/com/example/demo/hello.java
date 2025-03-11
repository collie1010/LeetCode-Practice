package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
	 @Autowired
	 @Qualifier("foodPanda")
	 private FoodDelivery fd;
	 
	
	 @RequestMapping("/test")
	    public String test() {
	        fd.order("鹹酥雞");
	        return "Hello World";
	    }
	 @RequestMapping("/product")
	    public food product() {
	        food f = new food();
	        List<String> list = new ArrayList<>();
	        list.add("apple");
	        list.add("guava");
	        list.add("banana");
	        f.setFoodList(list);
	        return f;
	        
	
	    }
	 
	 
	 
}
