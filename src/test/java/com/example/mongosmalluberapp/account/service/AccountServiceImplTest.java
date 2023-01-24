package com.example.mongosmalluberapp.account.service;

import com.example.mongosmalluberapp.account.accountrExeption.LoginExeption;
import com.example.mongosmalluberapp.account.dto.request.CreateAccountRequest;
import com.example.mongosmalluberapp.account.dto.request.LoginRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class AccountServiceImplTest {
    @Autowired
    UberAccountSerivice uberAccountSerivice;
    CreateAccountRequest createAccountRequest1;
    CreateAccountRequest createAccountRequest2;
    CreateAccountRequest createAccountRequest3;
    CreateAccountRequest createAccountRequest4;
    LoginRequest loginRequest1;
    @BeforeEach
    void setUp() {
        loginRequest1 = new  LoginRequest();
        loginRequest1.setFirstName("samuel");
        loginRequest1.setIdentifier("goat");
        loginRequest1.setPassword("goat");
        //<<===================================================================================>>>
        createAccountRequest1 = new CreateAccountRequest();
        createAccountRequest1.setIdentifier("goat");
        createAccountRequest1.setPassword("goat");
        createAccountRequest1.setContactNumber("09099332737");
        createAccountRequest1.setFirstName("samuel");
        createAccountRequest1.setLastName("shola");
        createAccountRequest1.setUserEmail("samuelShola.gmail.com");

        //<<===================================================================================>>>
        createAccountRequest2 = new CreateAccountRequest();
        createAccountRequest2.setIdentifier("horse");
        createAccountRequest2.setPassword("boneshaker");
        createAccountRequest2.setContactNumber("08142345678");
        createAccountRequest2.setFirstName("samuel");
        createAccountRequest2.setLastName("segun");
        createAccountRequest2.setUserEmail("samuelsegun.gmail.com");
        //<<===================================================================================>>>
        createAccountRequest3 = new CreateAccountRequest();
        createAccountRequest3.setIdentifier("ship");
        createAccountRequest3.setPassword("ship");
        createAccountRequest3.setContactNumber("09099667787");
        createAccountRequest3.setFirstName("ayo");
        createAccountRequest3.setLastName("mide");
        createAccountRequest3.setUserEmail("ayomide.gmail.com");
        //<<===================================================================================>>>
        createAccountRequest4 = new CreateAccountRequest();
        createAccountRequest4.setIdentifier("cow");
        createAccountRequest4.setPassword("cow");
        createAccountRequest4.setContactNumber("08156673432");
        createAccountRequest4.setFirstName("pelumi");
        createAccountRequest4.setLastName("juno");
        createAccountRequest4.setUserEmail("pelumi.gmail.com");
        //<<===================================================================================>>>
    }

    @AfterEach
    @Test
    void tearDown() {
        uberAccountSerivice.deleteAllUberAccount();

    }
    @Test
    void testThatWeCanCreateAccount(){
        uberAccountSerivice.createUberAccount(createAccountRequest1);
        assertEquals(1, uberAccountSerivice.countExistingAccount());
    }
    @Test
    void testThatWeCanDeleteUberAccountByIdentifier(){

        uberAccountSerivice.createUberAccount(createAccountRequest1);
        uberAccountSerivice.createUberAccount(createAccountRequest2);
        uberAccountSerivice.createUberAccount(createAccountRequest3);
        uberAccountSerivice.createUberAccount(createAccountRequest4);
        assertEquals(4, uberAccountSerivice.countExistingAccount());
     uberAccountSerivice.deleteByIdentifier("horse");
        assertEquals(3, uberAccountSerivice.countExistingAccount());

    }

    @Test
    void  testThatWeCandeleteAllAccount(){
        uberAccountSerivice.deleteAllUberAccount();
        assertEquals(0, uberAccountSerivice.countExistingAccount());
    }
    @Test
    void testThatWeCanFindByIdentifier(){
        uberAccountSerivice.createUberAccount(createAccountRequest1);
        uberAccountSerivice.createUberAccount(createAccountRequest2);
        uberAccountSerivice.createUberAccount(createAccountRequest3);
        uberAccountSerivice.createUberAccount(createAccountRequest4);
        assertEquals(4, uberAccountSerivice.countExistingAccount());
assertEquals("samuel", uberAccountSerivice.findByIdentifier("horse").getFirstName());
    }

    @Test
    void testThatWeCanChangeFirstName(){
        uberAccountSerivice.createUberAccount(createAccountRequest1);
        uberAccountSerivice.createUberAccount(createAccountRequest2);
        uberAccountSerivice.createUberAccount(createAccountRequest3);
        uberAccountSerivice.createUberAccount(createAccountRequest4);

        uberAccountSerivice.changeFirstName("horse","sonOfGod");
        
assertEquals("sonOfGod", uberAccountSerivice.findByIdentifier("horse").getFirstName());
    } @Test
    void testThatWeCanChangeLastName(){
        uberAccountSerivice.createUberAccount(createAccountRequest1);
        uberAccountSerivice.createUberAccount(createAccountRequest2);
        uberAccountSerivice.createUberAccount(createAccountRequest3);
        uberAccountSerivice.createUberAccount(createAccountRequest4);

        uberAccountSerivice.changeLastName("horse","sonOfGrace");

assertEquals("sonOfGrace", uberAccountSerivice.findByIdentifier("horse").getLastName());
    }
    @Test
    void testThatWeCanChangePassword(){
        uberAccountSerivice.createUberAccount(createAccountRequest1);
        uberAccountSerivice.createUberAccount(createAccountRequest2);
        uberAccountSerivice.createUberAccount(createAccountRequest3);
        uberAccountSerivice.createUberAccount(createAccountRequest4);
        uberAccountSerivice.changePassword("ship","aneeka");
        assertEquals("aneeka", uberAccountSerivice.findByIdentifier("ship").getPassword());
    }
    @Test
    void testThatWeCanChangerPhoneNumber(){
        uberAccountSerivice.createUberAccount(createAccountRequest1);
        uberAccountSerivice.createUberAccount(createAccountRequest2);
        uberAccountSerivice.createUberAccount(createAccountRequest3);
        uberAccountSerivice.createUberAccount(createAccountRequest4);
assertEquals(4, uberAccountSerivice.countExistingAccount());
uberAccountSerivice.changeContactNumber("ship","09099332737");
    }

    @Test
    void testThatAccountCanLogging() throws LoginExeption {

        uberAccountSerivice.createUberAccount(createAccountRequest1);
        uberAccountSerivice.createUberAccount(createAccountRequest2);
        uberAccountSerivice.createUberAccount(createAccountRequest3);
        uberAccountSerivice.createUberAccount(createAccountRequest4);
        assertEquals(4, uberAccountSerivice.countExistingAccount());

        uberAccountSerivice.loginToUberAccount(loginRequest1);
        uberAccountSerivice.loginToUberAccount(loginRequest1);
        assertEquals(2, uberAccountSerivice.countLoggedInAccount());


    }
}