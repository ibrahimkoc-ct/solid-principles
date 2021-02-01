package com.ba.single.good.service;

import java.util.ArrayList;
import java.util.List;

import com.ba.single.good.entity.Customer;


public interface CustomerService {

	public String addCustomer(Customer customer);
	
	
	public String deleteCustomer(int id);
	
	public String updateCustomer(Customer customer);
	
	public List<Customer> listCustomer();
}
