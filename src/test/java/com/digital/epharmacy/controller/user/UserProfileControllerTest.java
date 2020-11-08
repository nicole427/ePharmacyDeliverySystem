package com.digital.epharmacy.controller.user;

import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.apache.catalina.User;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
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
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserProfileControllerTest {

    UserProfile userProfile = UserProfileFactory.createUserProfile("Ronnie", "Michaelson", "Female");
   private static String Security_UserName = "Admin";
   private static String Security_Password = "12345";

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/user";
    @Order(1)
    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL:" + url);
        System.out.println("Post data: " + userProfile);

        ResponseEntity<UserProfile> postResponse= restTemplate
               .withBasicAuth(Security_UserName,Security_Password)
                .postForEntity(url, userProfile, UserProfile.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        userProfile = postResponse.getBody();
        System.out.println("Saved data:" + userProfile);
        assertEquals(HttpStatus.CREATED,postResponse.getStatusCode());

        assertEquals(userProfile.getUserId(), postResponse.getBody().getUserId());
    }
    @Order(2)
    @Test
    void b_read(){
        String url = baseURL + "/id/" + userProfile.getUserId();
        System.out.println("Url: " + url);
        ResponseEntity<UserProfile> response = restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .getForEntity(url,UserProfile.class);
        assertEquals(HttpStatus.FOUND,response.getStatusCode());
        assertEquals(userProfile.getUserId(), response.getBody().getUserId());
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        System.out.println(response);
        System.out.println(response.getBody());

    }

    @Order(3)
    @Test
    void c_FindByUserProfileName(){
        String url = baseURL + "/name/" + userProfile.getUserName();
        System.out.println("Url: " + url);
        ResponseEntity<UserProfile> response = restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .getForEntity(url,UserProfile.class);
        assertEquals(HttpStatus.FOUND,response.getStatusCode());
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
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
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .exchange(url, HttpMethod.GET,entity,String.class);
        assertEquals(HttpStatus.FOUND,response.getStatusCode());
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
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
        ResponseEntity<UserProfile> response = restTemplate
                .withBasicAuth(Security_UserName,Security_Password)
                .postForEntity(url, UserProfileUpdated, UserProfile.class);
        userProfile = response.getBody();
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertEquals(userProfile.getGender(),response.getBody().getGender());
    }

    @Order(6)
    @Test
    void e_delete(){
        String url = baseURL + "/delete/" + userProfile.getUserId();
        System.out.println("Url: " + url);
        restTemplate.withBasicAuth(Security_UserName,Security_Password).delete(url);
        if (url == null){
        System.out.println(HttpStatus.OK);} else
            System.out.println(HttpStatus.FORBIDDEN);
    }


}