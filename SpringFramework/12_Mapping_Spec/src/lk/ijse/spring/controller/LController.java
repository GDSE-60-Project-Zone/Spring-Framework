package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class LController {

    // @RequestParam (queryString/x-www) (not required)
    // @ModelAttribute (queryString/x-www) (not required)
    //RequestBody (State that the parameter is going to inject values from JSON object) (required annotation)

    //Let's Handle a JSON request with Spring

    @PutMapping
    public ArrayList<CustomerDTO> saveCustomer(@RequestBody CustomerDTO dto) {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        allCustomers.add(new CustomerDTO("C001", "Dasun", "Galle", 100));
        allCustomers.add(new CustomerDTO("C001", "Dasun", "Galle", 100));
        allCustomers.add(new CustomerDTO("C001", "Dasun", "Galle", 100));
        allCustomers.add(new CustomerDTO("C001", "Dasun", "Galle", 100));
        return allCustomers;
    }


}
