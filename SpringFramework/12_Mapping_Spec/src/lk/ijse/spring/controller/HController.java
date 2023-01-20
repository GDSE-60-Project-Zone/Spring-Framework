package lk.ijse.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eight")
public class HController {

    //How many parts are there in an HTTP request.?
    // There are two parts
    //Headers (Meta Data) "Content-Type=application/json"
    //Body (Context)

    //We can narrow down request using headers also

//    @GetMapping(consumes = {"application/json"})
    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String testOne(){
        return "Method One Invoked";
    }

    @GetMapping(consumes = {"text/html"})
    public String testTwo(){
        return "Method Two Invoked";
    }
}
