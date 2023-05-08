package com.spring6framework.spring6restmvc.mappers;

import com.spring6framework.spring6restmvc.entities.Customer;
import com.spring6framework.spring6restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
