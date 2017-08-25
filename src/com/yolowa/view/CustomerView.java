package com.yolowa.view;

import java.util.List;

import com.yolowa.model.CustomerDTO;

public class CustomerView {
	
	public static void print(List<CustomerDTO> customer_list){
		for(CustomerDTO customer_dto : customer_list){
			System.out.println(customer_dto);
		}
	}
	
	public static void print(CustomerDTO customer_dto){
		System.out.println(customer_dto);
	}
	
	public static void print(String msg){
		System.out.println(msg);
	}

}
