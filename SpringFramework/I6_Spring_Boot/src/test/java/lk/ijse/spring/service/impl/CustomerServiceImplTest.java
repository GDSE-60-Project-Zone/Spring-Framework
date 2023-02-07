package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService service;

    @Test
    public void test(){
        ArrayList<CustomerDTO> allCustomers = service.getAllCustomers();
        for (CustomerDTO c : allCustomers) {
            System.out.println(c.toString());
        }
    }

}