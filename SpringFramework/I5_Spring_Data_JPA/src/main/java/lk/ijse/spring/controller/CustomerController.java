package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping(path = "/{name}")
    public ResponseUtil searchCustomerByName(@PathVariable String name){
        return new ResponseUtil("OK","Successfully Loaded. :" ,service.searchCustomerWithName(name));
    }

}
