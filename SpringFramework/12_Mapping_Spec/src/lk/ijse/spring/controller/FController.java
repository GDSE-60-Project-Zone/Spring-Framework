package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/six")
public class FController {

    //Duel Wild Card Mapping

    //http://localhost:8080/mapping/five/path/1ormore/A/B

    @GetMapping(path = "/path/**/A/B")
    public String testOne(){
        return "Method One Invoked";
    }

    @GetMapping(path = "/**/myPath/A/C")
    public String testTwo(){
        return "Method Two Invoked";
    }

}
