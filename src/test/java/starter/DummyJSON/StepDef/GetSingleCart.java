package starter.DummyJSON.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.CartsAPI;


public class GetSingleCart {

    @Steps
    CartsAPI cartsAPI;
    @Given("Get single cart with valid id {int}")
    public void getSingleCartWithValidId(int id) {CartsAPI.getSingleCart(id);}

    @When("Send request get single cart")
    public void sendRequestGetSingleCart() {
        SerenityRest.when().get(CartsAPI.GET_SINGLE_CART);
    }

}
