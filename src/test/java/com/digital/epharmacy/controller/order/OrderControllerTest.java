package com.digital.epharmacy.controller.Order;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderControllerTest {

    //as per business rule, we need items on the db to place order
    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem(36, "Mayogel",
            "oral health", 36, 200);

    @Autowired
    private static TestRestTemplate restTemplateItem;
    private static final String baseURLItem = "http://localhost:8080/catalogueItem";
    private static String itemUrl = baseURLItem + "/create";

    private static ResponseEntity<CatalogueItem> item1 = restTemplateItem.postForEntity(itemUrl, catalogueItem, CatalogueItem.class);

    private  static List<CatalogueItem> items = Stream.of(item1.getBody()).collect(Collectors.toList());



    private static UserProfile user = UserProfileFactory
            .createUserProfile("Ayabulela","Mahlathini", "male");

    private static Order order = OrderFactory
            .createOrder(user.getUserId(), items, "yoco");


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/order/";

    @org.junit.jupiter.api.Order(1)
    @Test
    public void a_create() {

        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("POST data: " + order);
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, order, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        order = postResponse.getBody();
        System.out.println("Saved data:" + order);
        assertEquals(order.getOrderNumber(), postResponse.getBody().getOrderNumber());

    }

    @org.junit.jupiter.api.Order(2)
    @Test
    public void b_read() {
        String url = baseURL + "read/" + order.getOrderNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);
        assertEquals(order.getOrderNumber(), response.getBody().getOrderNumber());
    }

    @org.junit.jupiter.api.Order(3)
    @Test
    public void c_update() {
        Order updatedOrder = new Order.Builder().copy(order).setOrderStatus("completed").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("POST data: " + updatedOrder);
        ResponseEntity<Order> response = restTemplate.postForEntity(url, updatedOrder, Order.class);
        System.out.println("Response: " + response.getBody());
        assertEquals(order.getOrderNumber(), response.getBody().getOrderNumber());
    }

    @org.junit.jupiter.api.Order(8)
    @Test
    public void h_delete() {
        String url = baseURL + "delete/" + order.getOrderNumber();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @org.junit.jupiter.api.Order(4)
    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @org.junit.jupiter.api.Order(5)
    @Test
    public void e_getAllCompletedOrders() {

        String url = baseURL + "completedOrders";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @org.junit.jupiter.api.Order(6)
    @Test
    public void f_trackOrderStatus() {
        String url = baseURL + "read/" + order.getOrderNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);
        assertEquals("completed", response.getBody().getOrderStatus());
    }

    @org.junit.jupiter.api.Order(7)
    @Test
    public void g_getAllOrdersByUser() {

        String url = baseURL + "pastOrders/"+ user
                .getUserId();

        OrderFactory.createOrder(user.getUserId(), items,"yoco");

        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}