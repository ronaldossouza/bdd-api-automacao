package bdd.automation.api.steps;

import bdd.automation.api.support.api.PetApi;
import io.cucumber.java.pt.Dada;
import io.cucumber.java.pt.Entao;
import org.apache.http.HttpStatus;
import bdd.automation.api.support.domain.Pet;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PetStepDefinition {

    private static final String CREATE_PET_ENDPOINT = "/v3/pet";
    private static final String PET_ENDPOINT = "/v3/pet/{nome}";

    private Pet expectedPet;
    private PetApi petApi;

    public PetStepDefinition(){
        petApi = new PetApi();
    }

    @Dada("crio um pet")
    public void crioUmPet() {
        expectedPet = Pet.builder().build();

        petApi.creatPet(expectedPet);
    }

    @Entao("o pet é salvo no sistema")
    public void oPetÉSalvoNoSistema() {
       int actualPetname = petApi.getPetname(expectedPet);

       assertThat(actualPetname, is(expectedPet.getId()));

    }


}