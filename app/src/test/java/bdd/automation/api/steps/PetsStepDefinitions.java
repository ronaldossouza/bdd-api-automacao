package bdd.automation.api.steps;


import bdd.automation.api.support.api.PetsApi;
import bdd.automation.api.support.domain.Pets;
import io.cucumber.java.pt.Dada;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

public class PetsStepDefinitions {

    private PetsApi petsApi;
    private List<Pets> actualPets;

    public PetsStepDefinitions(){
        petsApi = new PetsApi();
    }

    @Dada("que possua animais available")
    public void quePossuaAnimaisAvailable()  {

    }

    @Quando("eu pesquiso por todos os animais {word}")
    public void euPesquisoPorTodosOsAnimaisAvailable(String status) {
        actualPets = petsApi.getPetsByStatus(status);
    }

    @Entao("eu recebo a lista de animais available")
    public void euReceboAListaDeAnimaisAvailable() {
        assertThat(actualPets, is(not(empty())));
    }
}
