package com.digital.epharmacy.controller.user;

import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.apache.catalina.User;
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
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserProfileControllerTest {
    UserProfile userProfile = UserProfileFactory.createUserProfile("Nicole", "Hawthorne", "Female");

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/user";
    @Order(1)
    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL:" + url);
        System.out.println("Post data: " + userProfile);

        ResponseEntity<UserProfile> postResponse= restTemplate.postForEntity(url, userProfile, UserProfile.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        userProfile = postResponse.getBody();
        System.out.println("Saved data:" + userProfile);
        assertEquals(userProfile.getUserId(), postResponse.getBody().getUserId());
    }
    @Order(2)
    @Test
    void b_read(){
        String url = baseURL + "/id/" + userProfile.getUserId();
        System.out.println("Url: " + url);
        ResponseEntity<UserProfile> response = restTemplate.getForEntity(url,UserProfile.class);
        assertEquals(userProfile.getUserId(), response.getBody().getUserId());
        System.out.println(response);
        System.out.println(response.getBody());

    }

    @Order(3)
    @Test
    void c_FindByUserProfileName(){
        String url = baseURL + "/name/" + userProfile.getUserName();
        System.out.println("Url: " + url);
        ResponseEntity<UserProfile> response = restTemplate.getForEntity(url,UserProfile.class);
        assertEquals(userProfile.getUserName(), response.getBody().getUserName());
        System.out.println(response);
        System.out.println(response.getBody());

    }
    @Order(5)
    @Test
    void d_getAll() {
        String url = baseURL + "/all";
        System.out.println("Url: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }

    @Order(4)
    @Test
    void c_update(){
        UserProfile UserProfileUpdated = new UserProfile.Builder().copy(userProfile).setGender("Male").build();
        String url = baseURL = "/update/" + userProfile.getUserId();
        System.out.println("Url: " + url);
        System.out.println("Post data: " + UserProfileUpdated);
        ResponseEntity<UserProfile> response = restTemplate.postForEntity(url, UserProfileUpdated, UserProfile.class);
        userProfile = response.getBody();
        assertEquals(userProfile.getGender(),response.getBody().getGender());
    }

    @Order(6)
    @Test
    void e_delete(){
        String url = baseURL + "/delete/" + userProfile.getUserId();
        System.out.println("Url: " + url);
        restTemplate.delete(url);

    }

}