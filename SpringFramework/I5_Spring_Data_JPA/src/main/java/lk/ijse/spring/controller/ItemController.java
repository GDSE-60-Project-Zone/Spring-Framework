package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto){
        return new ResponseUtil("OK","Successfully Registered.!",null);
    }

    @DeleteMapping(params = {"code"})
    public ResponseUtil deleteItem(@RequestParam String code){
        return new ResponseUtil("OK","Successfully Deleted. :"+code  ,null);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto){
        return new ResponseUtil("OK","Successfully Updated. :"+dto.getCode() ,null);
    }

    @GetMapping
    public ResponseUtil getAllItems(){
        ArrayList<ItemDTO> arrayList= new ArrayList<>();
        arrayList.add(new ItemDTO("I001","Lux",100,1000));
        arrayList.add(new ItemDTO("I002","Signal",200,2000));
        arrayList.add(new ItemDTO("I003","Clougard",300,3000));
        arrayList.add(new ItemDTO("I004","Supiriwiki",400,4000));
        arrayList.add(new ItemDTO("I005","Danthalepa",500,5000));
        return new ResponseUtil("OK","Successfully Loaded. :" ,arrayList);
    }

}
