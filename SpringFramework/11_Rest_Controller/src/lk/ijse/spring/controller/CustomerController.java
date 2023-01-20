package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping
    public String testOne(){
        // we can return any compatible data type with rest controllers.
        //no need of view resolvers
        return "Hello";
    }

    @GetMapping
    public String testTwo(){
        return "Hello";
    }
}
