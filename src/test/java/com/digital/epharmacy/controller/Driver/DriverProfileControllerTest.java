package com.digital.epharmacy.controller.Driver;

import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.factory.Driver.DriverProfileFactory;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class DriverProfileControllerTest {

    DriverProfile driverProfile = DriverProfileFactory.createDriverProfile("Chaddy","Boswell","Belville");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/driverProfile/";

    @Test
    void create() {

        String url = baseURL + "create";
        System.out.println("URL: " +url);
        System.out.println("Post Data:" + driverProfile);
        ResponseEntity<DriverProfile> postResponse = restTemplate.postForEntity(url,driverProfile,DriverProfile.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Saved Data:" +driverProfile);
        assertEquals(driverProfile.getDriverId(),postResponse.getBody().getDriverId());
    }

    @Test
    void read() {

        String url = baseURL + "read/" + driverProfile.getDriverId();
        System.out.println("URL: " +url);
        ResponseEntity<DriverProfile> response = restTemplate.getForEntity(url,DriverProfile.class);
        assertEquals(driverProfile.getDriverId(), response.getBody().getDriverId());
    }

    @Test
    void update() {

        DriverProfile updated = new DriverProfile.Builder().copy(driverProfile).setDriverLocation("Kuislriver").builder();
        String url = baseURL = "update";
        System.out.println("URL: " +url);
        System.out.println("Post Data: " +updated);
        ResponseEntity<DriverProfile> response = restTemplate.postForEntity(url,updated,DriverProfile.class);
        assertEquals(driverProfile.getDriverId(), response.getBody().getDriverId());
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

        String url = baseURL +"delete/" +driverProfile.getDriverId();
        System.out.println("URL: " +url);
        restTemplate.delete(url);
    }
}