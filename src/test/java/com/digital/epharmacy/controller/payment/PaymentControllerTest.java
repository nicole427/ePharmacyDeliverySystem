package com.digital.epharmacy.controller.payment;

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.factory.Payment.PaymentFactory;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class PaymentControllerTest {

    Payment payment = PaymentFactory.makePayment(
            "Matthew",
            "25242",
            "Clicks",
            "EFT",
            50.0);

    private static String Security_UserName = "paymentuser";
    private static String Security_Password = "paymentpassword";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/payment";

    @Order(1)
    @Test
    void create() {

        String url = baseURL + "/create";
        System.out.println("URL: " +url);
        System.out.println("Post Data:" + payment);
        ResponseEntity<Payment> postResponse = restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .postForEntity(url,payment,Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Saved Data:" +payment);
        assertEquals(payment.getUserID(),postResponse.getBody().getUserID());
    }

    @Order(2)
    @Test
    void read() {

        String url = baseURL + "read/" + payment.getUserID();
        System.out.println("URL: " +url);
        ResponseEntity<Payment> reponse = restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .getForEntity(url,Payment.class);
        assertEquals(payment.getUserID(), reponse.getBody().getUserID());
    }

    @Order(3)
    @Test
    void update() {

        Payment updated = new Payment.Builder().copy(payment).setOrderNumber("30000").build();
        String url = baseURL = "update";
        System.out.println("URL: " +url);
        System.out.println("Post Data: " +updated);
        ResponseEntity<Payment> response = restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .postForEntity(url,updated,Payment.class);
        assertEquals(payment.getUserID(), response.getBody().getUserID());
    }

    @Order(4)
    @Test
    void getAll() {

        String url = baseURL + "all";
        System.out.println("URL: " +url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(Security_UserName,Security_Password)
                .exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(5)
    @Test
    void delete() {

        String url = baseURL +"delete/" +payment.getUserID();
        System.out.println("URL: " +url);
        restTemplate.withBasicAuth(Security_UserName,Security_Password).delete(url);
        if (url == null){
            System.out.println(HttpStatus.OK);} else
            System.out.println(HttpStatus.FORBIDDEN);
    }
}