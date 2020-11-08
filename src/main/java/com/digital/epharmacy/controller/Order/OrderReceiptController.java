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
@RequestMapping("/orderReceipt")
public class OrderReceiptController {

    @Autowired
    private OrderReceiptServiceImpl OrderReceiptService;

    @PostMapping("/create")
    public OrderReceipt create(@RequestBody OrderReceipt orderReceipt) {
        Date date = new Date();
        OrderReceipt createdOrderReceipt = OrderReceiptFactory.createOrderReceipt(orderReceipt.getOrder(), orderReceipt.getPharmacy());

        return OrderReceiptService.create(createdOrderReceipt);
    }

    @GetMapping("/read/{orderNumber}")
    public OrderReceipt read(@PathVariable String receiptNumber){
        return OrderReceiptService.read(receiptNumber);
    }

    @PostMapping("/update")
    public OrderReceipt update(@RequestBody OrderReceipt orderReceipt){
        return OrderReceiptService.update(orderReceipt);
    }

    @GetMapping("/all")
    public Set<OrderReceipt> getAll(){
        return OrderReceiptService.getAll();
    }

    @DeleteMapping("/delete/{receiptNumber}")
    public boolean delete(@PathVariable String receiptNumber){
        return OrderReceiptService.delete(receiptNumber);
    }
}

