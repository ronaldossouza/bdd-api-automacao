package bdd.automation.api.support.api;

import bdd.automation.api.support.domain.Pets;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetsApi {
    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "v3/pet/findByStatus?status={status}";

    public List<Pets> getPetsByStatus(String status){
        return given().
            pathParam("status", status).
        when().
          get(FIND_PETS_BY_STATUS_ENDPOINT).
        then().
          extract().body().jsonPath().getList("", Pets.class);
    }

}
