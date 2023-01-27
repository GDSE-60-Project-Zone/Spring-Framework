package lk.ijse.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nine")
public class IController {

    //How many parts are there in an HTTP request.?
    // There are two parts
    //Headers (Meta Data) "Content-Type=application/json"
    //Body (Context)

    //consume = Content-Type=application/json
    //produce = ?

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public String testOne(){
        return "Method One Invoked";
    }

    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String testTwo(){
        return "Method Two Invoked";
    }
}
