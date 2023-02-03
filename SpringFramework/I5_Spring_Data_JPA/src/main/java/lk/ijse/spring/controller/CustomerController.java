package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
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
    private CustomerService service;

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto){
        service.saveCustomer(dto);
        return new ResponseUtil("OK","Successfully Registered.!",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteCustomer(@RequestParam String id){
        service.deleteCustomer(id);
        return new ResponseUtil("OK","Successfully Deleted. :"+id ,null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        service.updateCustomer(dto);
        return new ResponseUtil("OK","Successfully Updated. :"+dto.getId() ,null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,service.getAllCustomers());
    }

}
