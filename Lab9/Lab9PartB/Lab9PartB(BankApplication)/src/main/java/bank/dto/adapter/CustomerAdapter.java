package bank.dto.adapter;

import bank.domain.Customer;
import bank.dto.CustomerDTO;


import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter {
    public static Customer getCustomerFromCustomerDTO(CustomerDTO customerDTO){
      return new Customer(customerDTO.getName());
    }
    public static CustomerDTO getCustomerDTOFromCustomer(Customer Customer){
       return new CustomerDTO(Customer.getName());
    }
    public static List<CustomerDTO> getCustomerDTOsFromCustomer(List<Customer>accounts){
        List<CustomerDTO> customerDTOs=new ArrayList<CustomerDTO>();
        for(Customer customer:accounts){
            customerDTOs.add(getCustomerDTOFromCustomer(customer));}
        return customerDTOs;
        }
    }
