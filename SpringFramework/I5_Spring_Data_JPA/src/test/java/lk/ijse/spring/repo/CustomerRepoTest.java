package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@WebAppConfiguration//creat the testing context
@ContextConfiguration(classes = {WebRootConfig.class}) // add configuration for that context
@ExtendWith(SpringExtension.class) // integrate junit with Spring
@Transactional
class CustomerRepoTest {

    @Autowired
    CustomerRepo repo;

    @Test
    void addCustomers(){
        Customer c1 = new Customer("C011", "Wimal", "Galle", new BigDecimal(100000));
        Customer c2 = new Customer("C012", "Amal", "Panadura", new BigDecimal(200000));
        repo.save(c1);
        repo.save(c2);
    }

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

    @Test
    void testAllMethods2() {
        Long count = repo.countCustomerByName("Ashan Fernando");
        System.out.println(count);

        Boolean available = repo.existsCustomerByName("Ashan Fernando");
        System.out.println(available);

        repo.deleteCustomerByName("Wasuka");
        repo.removeCustomerByName("Ramal Wasuka");

    }

    @Test
    void testAllMethods3() {
        Customer c1 = repo.findCustomerByNameAndAddress("Danuka Perera", "Colombo");
        System.out.println(c1.toString());
    }

    @Test
    void queryTest() {
        List<Customer> customers = repo.methodOne();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

    }

    @Test
    void queryTest1() {
        Customer customer = repo.methodTwo();
        System.out.println(customer.toString());

        Customer customer1 = repo.methodThree("C002","Kushan Hansaka");
        System.out.println(customer1.toString());

        Customer customer2 = repo.methodFour("C002","Kushan Hansaka");
        System.out.println(customer2.toString());

    }

    @Test
    void queryTest2() {
        List<Customer> jpql = repo.getCustomerWithJPQL();
        for (Customer c : jpql) {
            System.out.println(c.toString());
        }
        System.out.println("=============");

        List<Customer> hql = repo.getCustomerWithHQL();
        for (Customer c1 : hql) {
            System.out.println(c1.toString());
        }
    }


}