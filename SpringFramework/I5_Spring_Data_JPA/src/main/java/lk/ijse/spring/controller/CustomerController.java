package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;

//response format
//state
//message
//data

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo repo;

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto){
        if (dto.getId().equals("C001")){
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
        Customer customer = new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
        repo.save(customer);

        return new ResponseUtil("OK","Successfully Registered.!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteCustomer(@RequestParam String id){
        if (id.equals("C001")){
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        return new ResponseUtil("OK","Successfully Deleted. :"+id ,null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        if (dto.getId().equals("C001")){
            throw new RuntimeException("Wrong ID..No Such a Customer to Update..!");
        }
        return new ResponseUtil("OK","Successfully Updated. :"+dto.getId() ,null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers(){
        ArrayList<CustomerDTO> arrayList= new ArrayList<>();
        arrayList.add(new CustomerDTO("C001","Ushan","Galle",new BigDecimal(100)));
        arrayList.add(new CustomerDTO("C002","Ashan","Galle",new BigDecimal(100)));
        arrayList.add(new CustomerDTO("C003","Malshan","Panadura",new BigDecimal(100)));
        arrayList.add(new CustomerDTO("C004","Kalshan","Kaluthara",new BigDecimal(100)));
        arrayList.add(new CustomerDTO("C005","Rashan","Panaudra",new BigDecimal(100)));
        return new ResponseUtil("OK","Successfully Loaded. :" ,arrayList);
    }

}
