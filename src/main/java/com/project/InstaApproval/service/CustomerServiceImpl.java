package com.project.InstaApproval.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.InstaApproval.repository.CustomerRepository;
import com.project.InstaApproval.exceptions.AlreadyRegisteredException;
import com.project.InstaApproval.exceptions.NotFoundException;
import com.project.InstaApproval.model.Customer;
import com.project.InstaApproval.service.CustomerService;

@Service
@Primary
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private Logger logger = Logger.getLogger(getClass());

    @Override
    public Customer addCustomer(Customer c) {
        Customer customer = customerRepository.checkCustomer(c.getEmail(), c.getAdhaar(), c.getPan(), c.getPhone());
        if (customer != null) {
            throw new AlreadyRegisteredException("Customer Already Registered: " + customer.getId());
        }
        return customerRepository.save(customer);
    }

    @Override
    public Integer doLogin(String email, String password) {
        Integer customerId = null;
        try {
            customerId = customerRepository.findCustomerByEmailAndPassword(email, password);
            logger.info("Customer: " + customerId + " Logged In Successfully");
            return customerId;
        } catch (Exception e) {
            throw new NotFoundException("Customer Not Found: " + customerId);
        }
    }

    public Customer updateCustomer(Customer c) {
        Customer customer = customerRepository.findById(c.getId())
                .orElseThrow(() -> new NotFoundException("Customer Not Found: " + c.getId()));
        BeanUtils.copyProperties(c, customer);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return customerRepository.findAll(pageable).toList();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException("Customer Not Found: " + customerId));
        logger.info("Customer Found: " + customerId);
        return customer;
    }

}