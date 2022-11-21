package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class HRTestBase {

    //BeforeAll is a annotation equals to @BeforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://3.86.103.110:1000/ords/hr";
    }
}
