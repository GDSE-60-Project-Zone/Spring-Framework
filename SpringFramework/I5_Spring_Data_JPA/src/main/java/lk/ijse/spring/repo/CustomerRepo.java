package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findCustomerByName(String name);
    List<Customer> findByName(String name);
    Customer readCustomerByName(String name);
    Customer getCustomerByName(String name);
    Customer queryCustomerByName(String name);
    Customer searchCustomerByName(String name);
    Customer streamCustomerByName(String name);



    Customer countCustomerByName(String name);
    Customer existsCustomerByName(String name);
    Customer deleteCustomerByName(String name);
    Customer removeCustomerByName(String name);

}
