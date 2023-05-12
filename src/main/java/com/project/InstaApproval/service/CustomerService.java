package com.project.InstaApproval.service;

import java.util.List;

import com.project.InstaApproval.model.Customer;

public interface CustomerService {

    public Integer doLogin(String email, String password);

    public Customer addCustomer(Customer c);

    public Customer updateCustomer(Customer c);

    public List<Customer> getCustomers(int pageNumber, int pageSize);

    public Customer getCustomerById(int custId);
}
