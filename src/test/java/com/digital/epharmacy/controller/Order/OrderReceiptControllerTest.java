package com.digital.epharmacy.controller.Order;

import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.factory.Order.OrderReceiptFactory;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
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

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


class OrderReceiptControllerTest {
    static Date date = new Date();

    OrderReceipt orderReceipt = OrderReceiptFactory.createOrderReceipt(11,2,
            400,"20","99","Disprin", "Cash", date);
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/Order/OrderReceipt";


    @Test
    void create() {

        String url = baseURL + "create";
        System.out.println("URL: " +url);
        System.out.println("Post Data:" + orderReceipt);
        ResponseEntity<OrderReceipt> postResponse = restTemplate.postForEntity(url,orderReceipt,OrderReceipt.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Saved Data:" +orderReceipt);
        assertEquals(orderReceipt.getOrderNumber(),postResponse.getBody().getOrderNumber());
    }

    @Test
    void read() {
        String url = baseURL + "read/" + orderReceipt.getOrderNumber();
        System.out.println("URL: " +url);
        ResponseEntity<OrderReceipt> response = restTemplate.getForEntity(url,OrderReceipt.class);
        assertEquals(orderReceipt.getUserID(), response.getBody().getOrderNumber());
    }

    @Test
    void update() {
        OrderReceipt updated = new OrderReceipt.Builder().copy(orderReceipt).setOrderNumber(30000).build();
        String url = baseURL = "update";
        System.out.println("URL: " +url);
        System.out.println("Post Data: " +updated);
        ResponseEntity<OrderReceipt> response = restTemplate.postForEntity(url,updated,OrderReceipt.class);
        assertEquals(orderReceipt.getOrderNumber(), response.getBody().getOrderNumber());
    }

    @Test
    void getAll() {
        String url = baseURL + "all";
        System.out.println("URL: " +url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    void delete() {
            String url = baseURL +"delete/" + orderReceipt.getOrderNumber();
            System.out.println("URL: " +url);
            restTemplate.delete(url);
        }
}