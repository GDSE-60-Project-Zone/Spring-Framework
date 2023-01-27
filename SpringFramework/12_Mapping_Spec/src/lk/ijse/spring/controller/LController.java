package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class LController {

   // @RequestParam (queryString/x-www) (not required)
   // @ModelAttribute (queryString/x-www) (not required)
   //RequestBody (State that the parameter is going to inject values from JSON object) (required annotation)

   //Let's Handle a JSON request with Spring

   @PutMapping
   public CustomerDTO saveCustomer(@RequestBody CustomerDTO dto){


      return dto ;
   }


}
