package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseOrderController {

    @PostMapping
    public ResponseUtil purchaseOrder(@RequestBody OrdersDTO dto){
        System.out.println(dto.toString());
        return new ResponseUtil();
    }

}
