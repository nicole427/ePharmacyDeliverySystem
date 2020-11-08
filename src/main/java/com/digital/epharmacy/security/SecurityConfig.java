package com.digital.epharmacy.security;
/*
* Author: Nicole Hawthorne
* Date: 5/11/2020
* DESC: Security Configuration file for adding users and marking their roles
* */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//basic users for userprofile
    private static final String User_Role = "USER";
    private static final String Admin_Role = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication().
              withUser("Admin")
              .password(encoder().encode("12345"))
              .roles(Admin_Role, User_Role)
              .and()
              .withUser("UserProfile")
              .password(encoder().encode("54321"))
              .roles(User_Role)
              .and().withUser("CatalogueItemUser").password(encoder().encode("catlogueitemuserpassword")).roles(User_Role)
                      .and().withUser("PharmacyCalatalogueUser").password(encoder().encode("pharmacycataloguepassword")).roles(User_Role)
                      .and().withUser("PrescriptionItemUser").passsword(encoder().encode("prescriptitempassword")).roles(User_Role)
              )
      ;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //roles for admin and userprofile based on user
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"http://localhost:8080/user/create").hasRole(User_Role + Admin_Role)

                .antMatchers(HttpMethod.POST, "http://localhost:8080/user/update/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/pharmacyCatalogue/create").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/pharmacyCatalogue/update").hasRole( Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/user/id/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/user/name/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/user/all").hasRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/user/delete/**").hasRole(Admin_Role)

                //prescription Item, Catalogue Item and Pharmacy catalogue
                .antMatchers(HttpMethod.POST,"http://localhost:8080/pharmacyCatalogue/create").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/pharmacyCatalogue/update/**").hasRole( Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/pharmacyCatalogue/create").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/pharmacyCatalogue/all/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/pharmacyCatalogue/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/presctiptionItem/create").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/presctiptionItem/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/presctiptionItem//**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/presctiptionItem/all").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/presctiptionItem/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/catalogueItem/all").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/catalogueItem/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/catalogueItem/delete/**").hasRole( Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/catalogueItem/create").hasRole( Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/catalogueItem/update/**").hasRole( Admin_Role)


                .and()
                .csrf()
                .disable();
    }
//password encoder needed to encode the password that is stored as a string variable
    @Bean
    public PasswordEncoder encoder(){
       return new BCryptPasswordEncoder();

    }

}
