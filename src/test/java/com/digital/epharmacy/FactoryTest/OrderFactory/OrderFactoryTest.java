package com.digital.epharmacy.FactoryTest.OrderFactory;
//Matthew Pearce - Test to create new order - 05 July
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class OrderFactoryTest {

    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem(36, "Mayogel",
            "oral health", 36, 200);
    private static Set<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toSet());
    UserProfile user = UserProfileFactory
            .createUserProfile("Ayabulela","Mahlathini", "male");


    @Test
    public void createOrder() {


         Order order = OrderFactory.createOrder(user, items, "EFT");

        String orderNumber = order.getOrderNumber();

        assertEquals(user.getUserId(), order.getUser().getUserId());
        assertEquals(orderNumber ,order.getOrderNumber());
        assertEquals(1, order.getItems().size());
        assertEquals(7200.00, order.getOrderTotal().doubleValue(), 0);
        assertEquals(1,order.getTotalCatalogueItems());
        assertEquals("Processing", order.getOrderStatus());
        assertEquals("EFT",order.getPaymentType());
        //assertEquals("02-9-2020",order.getDate());
    }


}