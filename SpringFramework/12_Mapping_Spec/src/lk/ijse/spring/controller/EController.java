package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/five")
public class EController {

    //Wild Card Mapping

    //http://localhost:8080/mapping/C1DEF

    @GetMapping(path = "/path/*/A/B")
    public String testOne(){
        return "Method One Invoked";
    }

    @GetMapping(path = "/*/myPath/A/C")
    public String testTwo(){
        return "Method Two Invoked";
    }

}
