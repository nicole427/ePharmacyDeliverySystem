package com.digital.epharmacy.controller.pharmacy;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PharmacyControllerTest {

    Pharmacy pharmacy = PharmacyFactory.createPharmacy("Fred's Pharmacy");

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/pharmacy";

    @Order(1)
    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        System.out.println("POST Data: " + pharmacy);

        ResponseEntity<Pharmacy> response = restTemplate.postForEntity(url, pharmacy, Pharmacy.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        pharmacy = response.getBody();
        System.out.println("Saved Data: " + pharmacy);
        assertEquals(pharmacy.getPharmacyId(), response.getBody().getPharmacyId());
    }

    @Order(2)
    @Test
    void b_readByPharmacyID() {
        String url = baseURL + "/id/" + pharmacy.getPharmacyId();
        System.out.println("URL: " + url);
        ResponseEntity<Pharmacy> response = restTemplate.getForEntity(url, Pharmacy.class);
        assertEquals(pharmacy.getPharmacyId(), response.getBody().getPharmacyId());
    }

    @Order(3)
    @Test
    void c_readByPharmacyName() {
        String url = baseURL + "/name/" + pharmacy.getPharmacyName();
        System.out.println("URL: " + url);
        ResponseEntity<Pharmacy> response = restTemplate.getForEntity(url, Pharmacy.class);
        assertEquals(pharmacy.getPharmacyName(), response.getBody().getPharmacyName());
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(4)
    @Test
    void update() {
        Pharmacy pharmacyUpdate = new Pharmacy
                .Builder()
                .copy(pharmacy)
                .setPharmacyName(
                        "Glen's Pharmacy"
                )
                .build();
        String url = baseURL + "/update/" + pharmacy.getPharmacyId();

        System.out.println("URL: " + url);
        System.out.println("POST Data: " + pharmacyUpdate);
        ResponseEntity<Pharmacy> response = restTemplate.postForEntity(url, pharmacyUpdate, Pharmacy.class);

        pharmacy = response.getBody();

        assertEquals(pharmacy.getPharmacyName(), response.getBody().getPharmacyName());
    }

    @Order(5)
    @Test
    void getAl() {
        String url = baseURL + "/all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(6)
    @Test
    void delete() {
        String url = baseURL + "/delete/" + pharmacy.getPharmacyId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}