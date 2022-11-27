package com.cydeo.Day6;

import com.cydeo.pojo.Spartan;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.cydeo.utilities.SpartanTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanPojoGetRequestTest extends SpartanTestBase {

    @DisplayName("GET one spartan and convert it to Spartan Object")
    @Test
    public void oneSpartanPojo(){

       Response response = given().accept(ContentType.JSON)
               .and().pathParam("id",15)
               .when().get("/api/spartans/{id}")
               .then().statusCode(200)
               .extract().response();

       //De serialize  --> JSON to POJO (java custom class)
        //2. Different way to do this
        //1. using as() method
        Spartan spartan15 = response.as(Spartan.class);
        System.out.println(spartan15);
        System.out.println("spartan15.getId() = " + spartan15.getId());
        System.out.println("spartan15.getGender() = " + spartan15.getGender());

    }


}
