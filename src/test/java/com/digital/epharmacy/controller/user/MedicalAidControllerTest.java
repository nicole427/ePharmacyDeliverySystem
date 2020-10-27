package com.digital.epharmacy.controller.user;

import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.factory.User.MedicalAidFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicalAidControllerTest {
    MedicalAid medicalAid = MedicalAidFactory.createMedicalAid(
           485723,
           "Health Med",
           "High Benefits"
    );

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/medicalaid";

    @Order(1)
    @Test
    public void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        System.out.println("POST Data: " + medicalAid);

        ResponseEntity<MedicalAid> response = restTemplate.postForEntity(url, medicalAid, MedicalAid.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        medicalAid = response.getBody();

        System.out.println("Saved Data: " + medicalAid);
        assertEquals(medicalAid.getMedicalAidName(), response.getBody().getMedicalAidName());
    }

    @Order(2)
    @Test
    public void b_read() {
        String url = baseURL + "/read/" + medicalAid.getMedicalAidName();
        System.out.println("URL: " + url);

        ResponseEntity<MedicalAid> response = restTemplate.getForEntity(url, MedicalAid.class);
        assertEquals(medicalAid.getMedicalAidName(), response.getBody().getMedicalAidName());
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(3)
    @Test
    public void c_update() {
        MedicalAid medicalAidUpdate = new MedicalAid
                .Builder()
                .copy(medicalAid)
                .setMedicalAidName(
                        "Grants Medical"
                )
                .build();
        String url = baseURL + "/update/" + medicalAid.getMedicalAidId();

        System.out.println("URL: " + url);
        System.out.println("POST Data: " + medicalAidUpdate);

        ResponseEntity<MedicalAid> response = restTemplate.postForEntity(url, medicalAidUpdate, MedicalAid.class);
        medicalAid = response.getBody();
        assertEquals(medicalAid.getMedicalAidName(), response.getBody().getMedicalAidName());

    }

    @Order(4)
    @Test
    public void d_getAll() {
        String url = baseURL + "/all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(5)
    @Test
    public void e_delete() {
        String url = baseURL + "/delete/" + medicalAid.getMedicalAidId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}