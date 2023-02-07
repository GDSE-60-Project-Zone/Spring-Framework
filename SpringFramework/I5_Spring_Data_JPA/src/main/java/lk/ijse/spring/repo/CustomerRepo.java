package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findCustomerByName(String name);
    List<Customer> findByName(String name);
    Customer readCustomerByName(String name);
    Customer getCustomerByName(String name);
    Customer queryCustomerByName(String name);
    Customer searchCustomerByName(String name);
    Customer streamCustomerByName(String name);



    Long countCustomerByName(String name);
    Boolean existsCustomerByName(String name);

    void deleteCustomerByName(String name);
    void removeCustomerByName(String name);

    Customer findCustomerByNameAndAddress(String name,String address);


    //Native SQL
    @Query(value = "select * from Customer",nativeQuery = true)
    List<Customer> methodOne();



}
