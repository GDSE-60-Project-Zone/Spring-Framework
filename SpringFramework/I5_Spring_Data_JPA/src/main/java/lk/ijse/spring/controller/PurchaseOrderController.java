package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrdersRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseOrderController {

    @Autowired
    private OrdersRepo repo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseUtil purchaseOrder(@RequestBody OrdersDTO dto){
        Orders ord = mapper.map(dto, Orders.class);
        if (repo.existsById(ord.getOid())) {
            throw new RuntimeException("Order"+ord.getOid()+" Already added.!");
        }
        repo.save(ord);

        //Update Item Qty
        for (OrderDetails od : ord.getOrderDetails()) {
            Item item = itemRepo.findById(od.getItemCode()).get();
            item.setQtyOnHand(item.getQtyOnHand()-od.getQty());
            itemRepo.save(item);
        }
        return new ResponseUtil("Ok","Successfully Purchased.!",null);
    }

}
