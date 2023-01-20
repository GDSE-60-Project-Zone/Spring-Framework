package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/three")
public class ThreeController {

    //http://localhost:8080/mapping/three/id/C002/Uvindu

//    @GetMapping(path = "/id/{C001}/{Dasun}")
//    public  String testOne11(@PathVariable("C001") String id, @PathVariable("Dasun") String name){
//        System.out.println(id+" "+name);
//        return "Get Method Invoked 1";
//    }

    //http://localhost:8080/mapping/three/id/name/dddd
//    @GetMapping(path = "/id/name/{ijse}")
//    public  String testOne22(@PathVariable("ijse") String id){
//        return "Get Method Invoked 2";
//    }

    @GetMapping(path = "/id/{id}/{name}")
    public  String testOne22(@PathVariable String id,@PathVariable String name){
        return "Get Method Invoked 2 "+id+" "+name;
    }





}
