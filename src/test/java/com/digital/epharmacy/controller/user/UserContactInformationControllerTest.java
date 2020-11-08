package com.digital.epharmacy.controller.user;

import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
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

import javax.swing.text.html.parser.Entity;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserContactInformationControllerTest {

ContactInformation contactInformation = ContactInformationFactory.createContactInformation("0823151354","0823151353");

    private static String Security_UserName = "contactinformationuser";
    private static String Security_Password = "contactinformationpassword";


@Autowired
private TestRestTemplate restTemplate;
private String baseURL = "http://localhost:8080/contactinformation/";


@Order(1)
    @Test
    void create() {

        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post Data:" + contactInformation);
        ResponseEntity<ContactInformation> postResponse = restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .postForEntity(url, contactInformation,ContactInformation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        contactInformation = postResponse.getBody();
        System.out.println("Saved Data:" + contactInformation);
        assertEquals(contactInformation.getcontactId(), postResponse.getBody().getcontactId());

    }

    @Order(2)
    @Test
    void read() {

        String url = baseURL + "read/" + contactInformation.getcontactId();
        System.out.println("URL: " + url);
        ResponseEntity<ContactInformation> response = restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .getForEntity(url,ContactInformation.class);
        assertEquals(contactInformation.getcontactId(), response.getBody().getcontactId());
    }

    @Order(3)
    @Test
    void update() {

        ContactInformation updated = new ContactInformation.Builder().copy(contactInformation).setUserId("Chervon").build();
        String url = baseURL = "update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        ResponseEntity<ContactInformation> response =restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .postForEntity(url,updated,ContactInformation.class);
        assertEquals(contactInformation.getcontactId(),response.getBody().getcontactId());
    }

    @Order(4)
    @Test
    void getAll() {

        String url = baseURL + "all";
        System.out.println("URL" + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(5)
    @Test
    void delete() {

        String url = baseURL + "delete/" + contactInformation.getcontactId();
        System.out.println("URL " + url);
        restTemplate.withBasicAuth(Security_UserName,Security_Password).delete(url);
        if (url == null){
            System.out.println(HttpStatus.OK);} else
            System.out.println(HttpStatus.FORBIDDEN);
    }
}