package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute ItemDTO dto){
        return new ResponseUtil("OK","Successfully Registered.!",null);
    }

    @DeleteMapping(params = {"code"})
    public ResponseUtil deleteCustomer(@RequestParam String code){
        return new ResponseUtil("OK","Successfully Deleted. :"+code ,null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody ItemDTO dto){
        return new ResponseUtil("OK","Successfully Updated. :"+dto.getCode() ,null);
    }

    @GetMapping
    public ResponseUtil getAllCustomers(){
        ArrayList<ItemDTO> arrayList= new ArrayList<>();
        arrayList.add(new ItemDTO("I001","Lux",100,1000));
        arrayList.add(new ItemDTO("I002","Signal",200,2000));
        arrayList.add(new ItemDTO("I003","Clougard",300,3000));
        arrayList.add(new ItemDTO("I004","Supiriwiki",400,4000));
        arrayList.add(new ItemDTO("I005","Danthalepa",500,5000));
        return new ResponseUtil("OK","Successfully Loaded. :" ,arrayList);
    }

}
