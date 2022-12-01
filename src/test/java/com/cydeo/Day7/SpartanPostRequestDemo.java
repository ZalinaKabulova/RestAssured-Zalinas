package com.cydeo.Day7;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SpartanPostRequestDemo extends SpartanTestBase {


    @Test
    public void postMethod1(){

        String requestJsonBody ="{\"gender\": \"Female\",\n" +
                "\"name\": \"VivienLee\",\n" +
                "\"phone\": 46575766767}";

        Response response = given().accept(ContentType.JSON).and()
                .contentType(ContentType.JSON)
                .body(requestJsonBody)
                .when()
                .post("/api/spartans");


        //verify status code
        assertThat(response.statusCode(),is(201));
        assertThat(response.contentType(),is("application/json"));

        String expectedResponseMessage = "A Spartan is Born!";
        assertThat(response.path("success"),is(expectedResponseMessage));
        assertThat(response.path("data.name"),is("VivienLee"));
        assertThat(response.path("data.gender"),is("Female"));
        assertThat(response.path("data.phone"),is(46575766767L));

}



}
