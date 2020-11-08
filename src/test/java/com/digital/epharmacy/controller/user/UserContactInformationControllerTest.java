package com.digital.epharmacy.controller.user;

import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
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

import javax.swing.text.html.parser.Entity;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserContactInformationControllerTest {

ContactInformation contactInformation = ContactInformationFactory.createContactInformation("0823151354","0823151353");

@Autowired
private TestRestTemplate restTemplate;
private String baseURL = "http://localhost:8080/contactinformation/";

    @Test
    void create() {

        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post Data:" + contactInformation);
        ResponseEntity<ContactInformation> postResponse = restTemplate.postForEntity(url, contactInformation,ContactInformation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        contactInformation = postResponse.getBody();
        System.out.println("Saved Data:" + contactInformation);
        assertEquals(contactInformation.getcontactId(), postResponse.getBody().getcontactId());

    }

    @Test
    void read() {

        String url = baseURL + "read/" + contactInformation.getcontactId();
        System.out.println("URL: " + url);
        ResponseEntity<ContactInformation> response = restTemplate.getForEntity(url,ContactInformation.class);
        assertEquals(contactInformation.getcontactId(), response.getBody().getcontactId());
    }

    @Test
    void update() {

        ContactInformation updated = new ContactInformation.Builder().copy(contactInformation).setUserId("Chervon").build();
        String url = baseURL = "update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        ResponseEntity<ContactInformation> response =restTemplate.postForEntity(url,updated,ContactInformation.class);
        assertEquals(contactInformation.getcontactId(),response.getBody().getcontactId());
    }

    @Test
    void getAll() {

        String url = baseURL + "all";
        System.out.println("URL" + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    void delete() {

        String url = baseURL + "delete/" + contactInformation.getcontactId();
        System.out.println("URL " + url);
        restTemplate.delete(url);
    }
}