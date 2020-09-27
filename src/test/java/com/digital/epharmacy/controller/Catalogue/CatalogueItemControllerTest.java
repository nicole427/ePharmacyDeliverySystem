
package com.digital.epharmacy.controller.Catalogue;
/*
 * Name: Nelson Mpyana
 * Desc: Catalogue Item controller Test
 * Date: 09/26/2020
 */
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import org.junit.jupiter.api.Test;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
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
class CatalogueItemControllerTest {

    CatalogueItem catItem = CatalogueItemFactory.createCatalogueItem(5585, "Mayo gel", " Heartburn medicine",
            10, 500);
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/pharmacyCatalogue";


    @Order(1)
    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        System.out.println("POST Data: " + catItem);

        ResponseEntity<CatalogueItem> response = restTemplate.postForEntity(url, catItem, CatalogueItem.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        catItem = response.getBody();
        System.out.println("Saved Data: " + catItem);
        assertEquals(catItem.getItemNumber(), response.getBody().getItemNumber());
    }

    @Order(2)
    @Test
    void b_readByItemNumber() {
        String url = baseURL + "/itemNumber/" + catItem.getItemNumber();
        System.out.println("URL: " + url);
        ResponseEntity<CatalogueItem> response = restTemplate.getForEntity(url, CatalogueItem.class);
        assertEquals(catItem.getItemNumber(), response.getBody().getItemNumber());
    }

    @Order(3)
    @Test
    void c_readByCatalogueDesc() {
        String url = baseURL + "/desc/" + catItem.getItemDescription();
        System.out.println("URL: " + url);
        ResponseEntity<CatalogueItem> response = restTemplate.getForEntity(url, CatalogueItem.class);
        assertEquals(catItem.getItemDescription(), response.getBody().getItemDescription());
        System.out.println(response);
        System.out.println(response.getBody());
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

    @Order(4)
    @Test
    void update() {
        CatalogueItem catalogueItemUpdate = new CatalogueItem
                .Builder()
                .copy(catItem)
                .setItemQuantity( 20
                )
                .build();
        String url = baseURL + "/update/" + catItem.getItemQuantity();

        System.out.println("URL: " + url);
        System.out.println("POST Data: " + catalogueItemUpdate);
        ResponseEntity<CatalogueItem> response = restTemplate.postForEntity(url, catalogueItemUpdate, CatalogueItem.class);

        catItem = response.getBody();

        assertEquals(catItem.getItemQuantity(), response.getBody().getItemQuantity());
    }

    @Order(6)
    @Test
    void delete() {
        String url = baseURL + "/delete/" + catItem.getItemNumber();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
    @Order(6)
    @Test
    void deleteByPrescriptionNumber() {
        String url = baseURL + "/delete/" + catItem;
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}