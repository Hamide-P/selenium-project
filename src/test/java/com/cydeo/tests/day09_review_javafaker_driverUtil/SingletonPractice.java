package com.cydeo.tests.day09_review_javafaker_driverUtil;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test
    public void singleton_understanding_test1(){


        //The Singleton pattern allows consistent retrieval of the same instance, regardless of the calling class or package. Whenever the "getDriver" method is called, it checks if the driver instance exists and returns it; otherwise, it creates a new instance and returns it.

        String str1 = Singleton.getWord(); // call the method which created in the singleton class
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);



    }
}
