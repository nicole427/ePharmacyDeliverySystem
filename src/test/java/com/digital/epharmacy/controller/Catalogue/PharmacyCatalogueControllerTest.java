package com.digital.epharmacy.controller.Catalogue;
/*
 * Name: Nelson Mpyana
 * Desc: Pharmacy Catalogue Controller Test
 * Date: 09/26/2020
 */
import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.factory.Catalogue.PharmacyCatalogueFactory;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PharmacyCatalogueControllerTest {

    PharmacyCatalogue pharmacyCat = PharmacyCatalogueFactory.createPharmacyCatalogue(
            "Beauty", "Facial");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/pharmacyCatalogue";

    @Order(1)
    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        System.out.println("POST Data: " + pharmacyCat);

        ResponseEntity<PharmacyCatalogue> response = restTemplate.postForEntity(url, pharmacyCat, PharmacyCatalogue.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        pharmacyCat = response.getBody();
        System.out.println("Saved Data: " + pharmacyCat);
        assertEquals(pharmacyCat.getCatalogueId(), response.getBody().getCatalogueId());
    }
    @Order(2)
    @Test
    void b_readByPharmacyID() {
        String url = baseURL + "/id/" + pharmacyCat.getCatalogueId();
        System.out.println("URL: " + url);
        ResponseEntity<PharmacyCatalogue> response = restTemplate.getForEntity(url, PharmacyCatalogue.class);
        assertEquals(pharmacyCat.getCatalogueId(), response.getBody().getCatalogueId());
    }
    @Order(3)
    @Test
    void c_readByPharmacyCatalogueDesc() {
        String url = baseURL + "/desc/" + pharmacyCat.getCatalogueDescription();
        System.out.println("URL: " + url);
        ResponseEntity<PharmacyCatalogue> response = restTemplate.getForEntity(url, PharmacyCatalogue.class);
        assertEquals(pharmacyCat.getCatalogueDescription(), response.getBody().getCatalogueDescription());
        System.out.println(response);
        System.out.println(response.getBody());
    }
    @Order(4)
    @Test
    void update() {
        PharmacyCatalogue pharmacyUpdate = new PharmacyCatalogue
                .Builder()
                .copy(pharmacyCat)
                .setCatalogueName( " Self-Medication "
                )
                .build();
        String url = baseURL + "/update/" + pharmacyCat.getCatalogueId();

        System.out.println("URL: " + url);
        System.out.println("POST Data: " + pharmacyUpdate);
        ResponseEntity<PharmacyCatalogue> response = restTemplate.postForEntity(url, pharmacyUpdate, PharmacyCatalogue.class);

        pharmacyCat = response.getBody();

        assertEquals(pharmacyCat.getCatalogueDescription(), response.getBody().getCatalogueDescription());
    }

    @Order(5)
    @Test
    void getAll() {
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
        String url = baseURL + "/delete/" + pharmacyCat.getCatalogueId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }


}