package bdd.automation.api.support.api;

import bdd.automation.api.support.domain.Pet;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class PetApi {
    private static final String CREATE_PET_ENDPOINT = "/v3/pet";
    private static final String PET_ENDPOINT = "/v3/pet/{nome}";

    public void creatPet(Pet pet) {
        given().
                body(pet).
                when().
                post(CREATE_PET_ENDPOINT).
                then().
                statusCode(HttpStatus.SC_OK);
    }

    public int getPetname(Pet pet) {
        return given().
                pathParam("nome", pet.getId()).
                when().
                get(PET_ENDPOINT).
                thenReturn().
                path("id");

    }
     public void deleteAllPet(){
        List<String> petList = Arrays.asList("10");

        for (String pet: petList){
            given().
                    pathParam("nome", pet).
            when().
                    delete(PET_ENDPOINT).
            then().
                  statusCode(HttpStatus.SC_OK);

        }

     }
   // https://petstore3.swagger.io/api/v3/pet/10

}
