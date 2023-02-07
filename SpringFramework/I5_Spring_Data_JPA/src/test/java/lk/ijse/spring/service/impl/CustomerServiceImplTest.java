package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration//creat the testing context
@ContextConfiguration(classes = {WebRootConfig.class}) // add configuration for that context
@ExtendWith(SpringExtension.class) // integrate junit with Spring
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerService service;

    @Test
    void saveCustomer() {
        //valid data test ok
        CustomerDTO customerDTO = new CustomerDTO("C011","Ramal Wasuka","Galle",new BigDecimal(1000));
       assertDoesNotThrow(()->{
           service.saveCustomer(customerDTO);
       });


        //set invalid data if this throws error
        CustomerDTO customerDTO2 = new CustomerDTO("C001","Ramal Wasuka","Galle",new BigDecimal(1000));
        assertThrows(RuntimeException.class,()->{
            service.saveCustomer(customerDTO2);
        });
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void getAllCustomers() {
        assertTrue(true);
        assertFalse(false);
    }

    @Test
    void searchCustomerWithName() {
        //valid info
        CustomerDTO data = service.searchCustomerWithName("Ramal Wasuka");
        assertNotNull(data);

        //invalid
        CustomerDTO data1 = service.searchCustomerWithName("Ramali Wasuka");
        assertNull(data1);

    }
}