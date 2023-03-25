package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.CartsAPI;
import starter.DummyJSON.Utils.Constant;

import java.io.File;


public class GetCartOfUser {

    @Steps
    CartsAPI cartsAPI;
    @Given("Get cart of user with valid id {int}")
    public void getCartOfUserWithValidId(int id) {cartsAPI.getCartOfUser(id);}

    @When("Send request get cart of user")
    public void sendRequestGetCartOfUser()  {
        SerenityRest.when().get(CartsAPI.GET_CART_OF_USER);
    }

    @Given("Get cart of user with invalid id {int}")
    public void getCartOfUserWithInvalidId(int id) {cartsAPI.getCartOfUser(id);
    }

    @And("Validate json schema get cart of user Invalid")
    public void validateJsonSchemaGetCartOfUserInvalid() {
        File jsonSchema=new File(Constant.JSON_SCHEMA+"Carts/GetCartOfUserInvalid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }
}
