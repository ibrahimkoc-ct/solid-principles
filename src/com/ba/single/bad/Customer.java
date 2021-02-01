package com.ba.single.bad;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private int id;
	private String name;
	private String surname;
	

	public String addCustomer(Customer customer) {
		return "add Customer";
	}
	
	
	public String deleteCustomer(int id) {
		return "deleted Customer";
	}
	
	public String updateCustomer(Customer customer) {
		return "update Customer";
	}
	
	public List<Customer> ListCustomer() {
		
		Customer customer= new Customer();
		List<Customer> customers= new ArrayList<Customer>();
		customers.add(customer);
		return customers;
	}
	
}
