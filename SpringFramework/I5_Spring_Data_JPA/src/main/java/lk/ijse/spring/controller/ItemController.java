package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepo repo;

    @Autowired
    private ModelMapper mapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto){
        if (repo.existsById(dto.getCode())){
            throw new RuntimeException(dto.getCode()+ " : Item already registered.!");
        }
        repo.save(mapper.map(dto, Item.class));
        return new ResponseUtil("OK","Successfully Registered.!",null);
    }

    @DeleteMapping(params = {"code"})
    public ResponseUtil deleteItem(@RequestParam String code){
        if (!repo.existsById(code)){
            throw new RuntimeException(code+ " : Item Not Exists to Delete.!");
        }
        return new ResponseUtil("OK","Successfully Deleted. :"+code  ,null);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto){
        if (!repo.existsById(dto.getCode())){
            throw new RuntimeException(dto.getCode()+ " : Item Not Exist for Update.!");
        }
        repo.save(mapper.map(dto, Item.class));
        return new ResponseUtil("OK","Successfully Updated. :"+dto.getCode() ,null);
    }

    @GetMapping
    public ResponseUtil getAllItems(){
        ArrayList<ItemDTO> list=mapper.map(repo.findAll(),new TypeToken< ArrayList<ItemDTO>>(){}.getType());
        return new ResponseUtil("OK","Successfully Loaded. :" ,list);
    }

}
