package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@WebAppConfiguration//creat the testing context
@ContextConfiguration(classes = {WebRootConfig.class}) // add configuration for that context
@ExtendWith(SpringExtension.class) // integrate junit with Spring
class CustomerRepoTest {

    @Autowired
    CustomerRepo repo;

    @Test
    void findByName() {
        List<Customer> list = repo.findByName("Ashan Fernando");
        for (Customer customer : list) {
            System.out.println(customer.toString());
        }
    }

    @Test
    void findCustomerByName() {
        Customer ashan = repo.findCustomerByName("Kushan Hansaka");
        System.out.println(ashan.toString());
    }

    @Test
    void testAllMethods() {
        Customer c1 = repo.findCustomerByName("Kushan Hansaka");
        Customer c2 = repo.readCustomerByName("Kushan Hansaka");
        Customer c3 = repo.getCustomerByName("Kushan Hansaka");
        Customer c4 = repo.queryCustomerByName("Kushan Hansaka");
        Customer c5 = repo.searchCustomerByName("Kushan Hansaka");
        Customer c6 = repo.streamCustomerByName("Kushan Hansaka");

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        System.out.println(c5.toString());
        System.out.println(c6.toString());

    }
}