package com.digital.epharmacy.controller.Order;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.factory.Order.OrderReceiptFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
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

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


class OrderReceiptControllerTest {

    private static String USERNAME = "UserProfile";
    private static String USER_PASSWORD = "54321";
    private static String ADMIN_USERNAME = "Admin";
    private static String ADMIN_PASSWORD = "12345";

    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem(36, "Mayogel",
            "oral health", 36, 200);
    private static Set<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toSet());

    UserProfile user = UserProfileFactory
            .createUserProfile("Ayabulela","Mahlathini", "male");

    Order order = OrderFactory.createOrder(user, items, "EFT");
    Pharmacy pharmacy = PharmacyFactory.createPharmacy("Lake Side Pharmacy");


    OrderReceipt orderReceipt = OrderReceiptFactory.createOrderReceipt(order, pharmacy);
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/orderReceipt/";


    @Test
    @org.junit.jupiter.api.Order(1)
    void create() {

        String url = baseURL + "create";
        System.out.println("URL: " +url);
        System.out.println("Post Data:" + orderReceipt);
        ResponseEntity<OrderReceipt> postResponse = restTemplate
                .withBasicAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
                .postForEntity(url,orderReceipt,OrderReceipt.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Saved Data:" +orderReceipt);
        assertEquals(orderReceipt.getReceipt_number(),postResponse.getBody().getReceipt_number());
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void read() {
        String url = baseURL + "read/" + orderReceipt.getReceipt_number();
        System.out.println("URL: " +url);
        ResponseEntity<OrderReceipt> response = restTemplate
                .withBasicAuth(USERNAME, USER_PASSWORD)
                .getForEntity(url,OrderReceipt.class);
        assertEquals(orderReceipt.getReceipt_number(), response.getBody().getReceipt_number());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void update() {
        OrderReceipt updated = new OrderReceipt.Builder().copy(orderReceipt).setReceipt_number("30000").build();
        String url = baseURL = "update";
        System.out.println("URL: " +url);
        System.out.println("Post Data: " +updated);
        ResponseEntity<OrderReceipt> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
                .postForEntity(url,updated,OrderReceipt.class);
        assertEquals(orderReceipt.getReceipt_number(), response.getBody().getReceipt_number());
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    void getAll() {
        String url = baseURL + "all";
        System.out.println("URL: " +url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
                .exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    void delete() {
            String url = baseURL +"delete/" + orderReceipt.getReceipt_number();
            System.out.println("URL: " +url);
            restTemplate.withBasicAuth(ADMIN_USERNAME, ADMIN_PASSWORD).delete(url);
        }
}