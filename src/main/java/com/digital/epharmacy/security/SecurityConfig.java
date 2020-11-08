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
              .and()
              .withUser("CatalogueItemUser")
              .password(encoder().encode("catlogueitemuserpassword"))
              .roles(User_Role)
              .and()
              .withUser("PharmacyCalatalogueUser")
              .password(encoder().encode("pharmacycataloguepassword"))
              .roles(User_Role)
              .and()
              .withUser("PrescriptionItemUser")
              .passsword(encoder().encode("prescriptitempassword"))
              .roles(User_Role)

      

        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password(encoder().encode("12345"))
                .roles(Admin_Role, User_Role)
                .and()
                .withUser("UserProfile")
                .password(encoder().encode("54321"))
                .roles(User_Role)
                .and()
                .withUser("pharmacyuser")
                .password(encoder().encode("pharmacypassword"))
                .roles(User_Role)
                .and()
                .withUser("bankuser")
                .password(encoder().encode("bankuserpassword"))
                .roles(User_Role)
                .and()
                .withUser("addressuser")
                .password(encoder().encode("addressuserpassword"))
                .roles(User_Role)
                .and()
                .withUser("medicaluser")
                .password(encoder().encode("medicaluserpassword"))
                .roles(User_Role)
                .and()
                .withUser("Driveruser")
                .password(encoder().encode("Driverpassword"))
                .roles(User_Role)
                .and()
                .withUser("Caruser")
                .password(encoder().encode("Carpassword"))
                .roles(User_Role)
                .and()
                .withUser("paymentuser")
                .password("paymentpassword")
                .roles(User_Role)
                .and()
                 .withUser("contactinformationuser")
                 .password("contactinformationpassword")
                 .roles(User_Role)

        


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

                .antMatchers(HttpMethod.POST,"http://localhost:8080/pharmacy/create").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/bankdetails/create").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/address/create").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/medicalaid/create").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/Car/create").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/payment/create").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/contactinfromation/create").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/driverProfile/create").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST, "http://localhost:8080/user/update/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/pharmacy/update").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/bankdetails/update").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/address/update").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/medicalaid/update").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/Car/update").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/payment/update").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/contactinformation/update").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/driverProfile/update").hasRole(Admin_Role)

                .antMatchers(HttpMethod.GET,"http://localhost:8080/user/id/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/pharmacy/id/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/bankdetails/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/bankdetails/account/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/address/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/address/name/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/user/name/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/pharmacy/name/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/medicalaid/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/driverProfile/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/Car/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/payment/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/contactinformation/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/user/all").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/pharmacy/all").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/bankdetails/all").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/address/all").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/medicalaid/all").hasRole(User_Role + Admin_Role)
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



                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/pharmacy/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/bankdetails/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/address/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/medicalaid/delete/**").hasRole(Admin_Role)

                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/driverProfile/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/Car/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/payment/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/contactinformation/delete/**").hasRole(Admin_Role)

                .and()

                //order,orderhistory & order receipt
                .antMatchers(HttpMethod.POST,"http://localhost:8080/order/create").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/orderHistory/create").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/orderReceipt/create").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/order/update/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/orderHistory/update/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.POST,"http://localhost:8080/orderReceipt/update/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/order/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/orderHistory/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/orderReceipt/read/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/order/all").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/orderHistory/all").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/orderReceipt/all").hasRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/order/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/orderHistory/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.DELETE,"http://localhost:8080/orderReceipt/delete/**").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/order/completedOrders").hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/order/trackStatus/**").hasRole(User_Role + Admin_Role)
                .antMatchers(HttpMethod.GET,"http://localhost:8080/order/pastOrders/**").hasRole(User_Role + Admin_Role).and()

                .csrf().disable()
                .formLogin().disable();
    }
    //password encoder needed to encode the password that is stored as a string variable
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();

    }

}
