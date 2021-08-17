package bdd.automation.api.steps;

import bdd.automation.api.support.api.PetApi;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class Config {

    private PetApi petApi;

    public Config(){
        petApi = new PetApi();
    }
    @Before
    public void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.baseURI = "https://petstore3.swagger.io";
        RestAssured.basePath = "/api";

        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("Autorization", getToken()).
                setContentType(ContentType.JSON).
                build();

      //  RestAssured.responseSpecification = new ResponseSpecBuilder().
         //       expectContentType(ContentType.JSON).
           //     build();

    }
    private String getToken(){
        return "grat access";
    }


    @After("@deleteAllPet")
    public void deleteAllUsers(){
        petApi.deleteAllPet();
    }

}
