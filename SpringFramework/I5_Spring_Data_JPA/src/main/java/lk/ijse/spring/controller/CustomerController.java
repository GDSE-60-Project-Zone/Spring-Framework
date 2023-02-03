package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto){
        if (repo.existsById(dto.getId())){
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, Customer.class));
        return new ResponseUtil("OK","Successfully Registered.!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteCustomer(@RequestParam String id){
        if (!repo.existsById(id)){
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(id);
        return new ResponseUtil("OK","Successfully Deleted. :"+id ,null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        if (!repo.existsById(dto.getId())){
            throw new RuntimeException("Customer Not Exist. Please Enter Valid ID..!");
        }
        repo.save(mapper.map(dto, Customer.class));
        return new ResponseUtil("OK","Successfully Updated. :"+dto.getId() ,null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers(){
        ArrayList<CustomerDTO> allList=mapper.map(repo.findAll(),new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
        return new ResponseUtil("OK","Successfully Loaded. :" ,allList);
    }

}
