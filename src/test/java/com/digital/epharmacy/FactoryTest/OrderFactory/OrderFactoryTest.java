package com.digital.epharmacy.FactoryTest.OrderFactory;
//Matthew Pearce - Test to create new order - 05 July
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class OrderFactoryTest {

    CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem(36, "Mayogel",
            "oral health", 36, 200);
    List<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toList());

    @Test
    public void createOrder() {

        Order order = OrderFactory.createOrder("Random", items, "EFT");

        String orderNumber = order.getOrderNumber();

        assertEquals("Random", order.getUserID());
        assertEquals(orderNumber ,order.getOrderNumber());
        assertEquals(1, order.getItems().size());
        assertEquals(10.00, order.getOrderTotal().doubleValue(), 0);
        assertEquals(10,order.getTotalCatalogueItems());
        assertEquals("delivered", order.getOrderStatus());
        assertEquals("EFT",order.getPaymentType());
        assertEquals("02-9-2020",order.getDate());
    }


}