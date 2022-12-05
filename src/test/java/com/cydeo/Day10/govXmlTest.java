package com.cydeo.Day10;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class govXmlTest {

    @Test
    public  void test1(){

        Response response = get("https://data.ct.gov/resource/y6p2-px98.xml")
                .then().statusCode(200).extract().response();

        XmlPath xmlPath = response.xmlPath();

       List<Integer> farmerId = xmlPath.getList("response.rows.row.farmer_id");
        System.out.println("farmerId = " + farmerId);

        List<Integer> zipcode = xmlPath.getList("response.rows.row.zipcode");
        System.out.println("zipcode = " + zipcode);

        String item = xmlPath.getString("response.rows.row[2].item");
        System.out.println("item = " + item);


        String address = xmlPath.getString("response.rows.row[4].@_address");
        System.out.println("address = " + address);
    }
}
