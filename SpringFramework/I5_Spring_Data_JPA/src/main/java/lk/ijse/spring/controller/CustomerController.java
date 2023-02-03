package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//response format
//state
//message
//data

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto){
        if (dto.getId().equals("C001")){
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
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
        arrayList.add(new CustomerDTO("C001","Ushan","Galle",1000));
        arrayList.add(new CustomerDTO("C002","Ashan","Galle",2000));
        arrayList.add(new CustomerDTO("C003","Malshan","Panadura",3000));
        arrayList.add(new CustomerDTO("C004","Kalshan","Kaluthara",4000));
        arrayList.add(new CustomerDTO("C005","Rashan","Panaudra",5000));
        return new ResponseUtil("OK","Successfully Loaded. :" ,arrayList);
    }

}
