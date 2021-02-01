package com.ba.single.good.service;

import java.util.ArrayList;
import java.util.List;

import com.ba.single.good.entity.Customer;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public String addCustomer(Customer customer) {
		return "add Customer";
	}

	@Override
	public String deleteCustomer(int id) {
		return "delete Customer";
	}

	@Override
	public String updateCustomer(Customer customer) {
		return "update Customer";
	}

	@Override
	public List<Customer> listCustomer() {
		Customer customer= new Customer();
		List<Customer> customers= new ArrayList<Customer>();
		customers.add(customer);
		return customers;
	}
}
