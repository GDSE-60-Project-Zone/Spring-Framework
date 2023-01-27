package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {


    //response format
    //state
    //message
    //data

    @PostMapping
    public void saveCustomer(CustomerDTO dto){
        System.out.println(dto.toString());
    }

}
