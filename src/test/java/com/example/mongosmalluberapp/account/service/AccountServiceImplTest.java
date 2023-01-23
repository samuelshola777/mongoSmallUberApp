package com.example.mongosmalluberapp.account.service;

import com.example.mongosmalluberapp.account.dto.request.AccountRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class AccountServiceImplTest {
    @Autowired
AccountSerivice accountSerivice;
    AccountRequest accountRequest1;
    AccountRequest accountRequest2;
    AccountRequest accountRequest3;
    AccountRequest accountRequest4;
    @BeforeEach
    void setUp() {
        accountRequest1 = new AccountRequest();
        accountRequest1.setIdentifier("goat");
        accountRequest1.setPassword("goat");
        accountRequest1.setContactNumber("09099332737");
        accountRequest1.setFirstName("samuel");
        accountRequest1.setLastName("shola");
        accountRequest1.setUserEmail("samuelShola.gmail.com");


        accountRequest2 = new AccountRequest();
        accountRequest2.setIdentifier("horse");
        accountRequest2.setPassword("boneshaker");
        accountRequest2.setContactNumber("08142345678");
        accountRequest2.setFirstName("samuel");
        accountRequest2.setLastName("segun");
        accountRequest2.setUserEmail("samuelsegun.gmail.com");

        accountRequest3 = new AccountRequest();
        accountRequest3.setIdentifier("ship");
        accountRequest3.setPassword("ship");
        accountRequest3.setContactNumber("09099667787");
        accountRequest3.setFirstName("ayo");
        accountRequest3.setLastName("mide");
        accountRequest3.setUserEmail("ayomide.gmail.com");

        accountRequest4 = new AccountRequest();
        accountRequest4.setIdentifier("cow");
        accountRequest4.setPassword("cow");
        accountRequest4.setContactNumber("08156673432");
        accountRequest4.setFirstName("pelumi");
        accountRequest4.setLastName("juno");
        accountRequest4.setUserEmail("pelumi.gmail.com");
    }

    @AfterEach
    @Test
    void tearDown() {
        accountSerivice.deleteAllUberAccount();

    }
    @Test
    void testThatWeCanCreateAccount(){
        accountSerivice.createUberAccount(accountRequest1);
        assertEquals(1, accountSerivice.countAccount());
    }
    @Test
    void testThatWeCanDeleteUberAccountByIdentifier(){

        accountSerivice.createUberAccount(accountRequest1);
        accountSerivice.createUberAccount(accountRequest2);
        accountSerivice.createUberAccount(accountRequest3);
        accountSerivice.createUberAccount(accountRequest4);
        assertEquals(4, accountSerivice.countAccount());
     accountSerivice.deleteByIdentifier("horse");
        assertEquals(3, accountSerivice.countAccount());

    }

    @Test
    void  testThatWeCandeleteAllAccount(){
        accountSerivice.deleteAllUberAccount();
        assertEquals(0, accountSerivice.countAccount());
    }
    @Test
    void testThatWeCanFindByIdentifier(){
        accountSerivice.createUberAccount(accountRequest1);
        accountSerivice.createUberAccount(accountRequest2);
        accountSerivice.createUberAccount(accountRequest3);
        accountSerivice.createUberAccount(accountRequest4);
        assertEquals(4, accountSerivice.countAccount());
assertEquals("samuel",accountSerivice.findByIdentifier("horse").getFirstName());
    }

    @Test
    void testThatWeCanChangeFirstName(){
        accountSerivice.createUberAccount(accountRequest1);
        accountSerivice.createUberAccount(accountRequest2);
        accountSerivice.createUberAccount(accountRequest3);
        accountSerivice.createUberAccount(accountRequest4);

        accountSerivice.changeFirstName("horse","sonOfGod");
        
assertEquals("sonOfGod", accountSerivice.findByIdentifier("horse").getFirstName());
    } @Test
    void testThatWeCanChangeLastName(){
        accountSerivice.createUberAccount(accountRequest1);
        accountSerivice.createUberAccount(accountRequest2);
        accountSerivice.createUberAccount(accountRequest3);
        accountSerivice.createUberAccount(accountRequest4);

        accountSerivice.changeLastName("horse","sonOfGrace");

assertEquals("sonOfGrace", accountSerivice.findByIdentifier("horse").getLastName());
    }
    @Test
    void testThatWeCanChangePassword(){
        accountSerivice.createUberAccount(accountRequest1);
        accountSerivice.createUberAccount(accountRequest2);
        accountSerivice.createUberAccount(accountRequest3);
        accountSerivice.createUberAccount(accountRequest4);
        accountSerivice.changePassword("ship","aneeka");
        assertEquals("aneeka",accountSerivice.findByIdentifier("ship").getPassword());
    }
    @Test
    void testThatWeCanChangerPhoneNumber(){
        accountSerivice.createUberAccount(accountRequest1);
        accountSerivice.createUberAccount(accountRequest2);
        accountSerivice.createUberAccount(accountRequest3);
        accountSerivice.createUberAccount(accountRequest4);
assertEquals(4,accountSerivice.countAccount());

accountSerivice.changeContactNumber("ship","09099332737");

    }
}