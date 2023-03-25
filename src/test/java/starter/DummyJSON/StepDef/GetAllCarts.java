package starter.DummyJSON.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.CartsAPI;
import starter.DummyJSON.ReqAPI.ProductsAPI;

public class GetAllCarts {

    @Steps
    CartsAPI cartsAPI;

    //Positive Case
    @Given("Get all carts list")
    public void getAllCartsList() {
        cartsAPI.getAllCarts();
    }

    @When("Send request get all carts")
    public void sendRequestGetAllCarts() {
        SerenityRest.when().get(CartsAPI.GET_ALL_CARTS);
    }


    @Then("Status code should {int} OK")
    public void statusCodeShouldOK(int status) {
        SerenityRest.then().statusCode(status);
    }


    //Negative Case
    @Given("Get invalid all carts")
    public void getInvalidAllCarts()  {CartsAPI.getInvalidAllCarts();}

    @When("Send invalid Get all carts")
    public void sendInvalidGetAllCarts() {SerenityRest.when().get(CartsAPI.GET_ALL_CARTS+"x");
    }
}
