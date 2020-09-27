package com.digital.epharmacy.controller.Order;


import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.factory.Order.OrderReceiptFactory;
import com.digital.epharmacy.service.Order.Impl.OrderReceiptServiceImpl;
import com.digital.epharmacy.service.Order.OrderReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/Order/OrderReceipt")
public class OrderReceiptController {

    @Autowired
    private OrderReceiptServiceImpl OrderReceiptService;

    @PostMapping("/create")
    public OrderReceipt create(@RequestBody OrderReceipt orderReceipt) {
        Date date = new Date();
        OrderReceipt createdOrderReceipt = OrderReceiptFactory.createOrderReceipt(orderReceipt.getOrderNumber(),
                orderReceipt.getItemQuantity(),orderReceipt.getPaymentTotal(),orderReceipt.getPharmacyId(),
                orderReceipt.getUserID(),orderReceipt.getItemName(),orderReceipt.getTypeOfPayment(), date);

        return OrderReceiptService.create(createdOrderReceipt);
    }

    @GetMapping("/read/{orderNumber}")
    public OrderReceipt read(@PathVariable String OrderNumber){
        return OrderReceiptService.read(OrderNumber);
    }

    @PostMapping("/update")
    public OrderReceipt update(@RequestBody OrderReceipt orderReceipt){
        return OrderReceiptService.update(orderReceipt);
    }

    @GetMapping("/all")
    public Set<OrderReceipt> getAll(){
        return OrderReceiptService.getAll();
    }

    @DeleteMapping("/delete/{orderNumber}")
    public boolean delete(@PathVariable String OrderNumber){
        return OrderReceiptService.delete(OrderNumber);
    }
}

