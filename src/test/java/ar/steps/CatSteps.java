package ar.steps;

import api.config.EntityConfiguration;
import api.model.Genre;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class CatSteps extends PageSteps {


    @When("^realizo una peticion '(.*)' a '(.*)' al endpoint de categorias - '(.*)'$")
    public void seEjecutaLaOperation(String operation, String entity, String request)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
        EntityConfiguration.valueOf(entity).getEntityService().getMethod(operation.toLowerCase(), String.class).invoke("", request);
    }

    @Then("obtengo el status code '(.*)'")
    public void obtengoElStatusCodeStatusCode(int expCode) {
        int statusCode = APIManager.getLastResponse().getStatusCode();
        Assert.assertEquals(statusCode, expCode);
    }

    @And("los datos son correctos")
    public void losDatosSonCorrectos() {
        Genre genres = (Genre) APIManager.getLastResponse().getResponse();
        Assert.assertEquals(genres.getId(), 121);
        Assert.assertEquals(genres.getName(), "Rap alemán");
        Assert.assertEquals(genres.getPicture(),"https://api.deezer.com/genre/121/image");
    }

    @When("realizo una peticion '(.*)' a '(.*)' al endpoint de genero - '(.*)'$")
    public void realizoUnaPeticionOperationAEntityAlEndpointDeGeneroRequest(String operacion, String entity, String request) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        EntityConfiguration.valueOf(entity).getEntityService().getMethod(operacion.toLowerCase(), String.class).invoke("", request);
    }

}
