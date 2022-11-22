package com.cydeo.Day4;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class CBTrainingApiWithJsonPath {

    //BeforeAll is a annotation equals to @BeforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://api.cydeo.training.com";
    }
}
