package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.CartsAPI;
import starter.DummyJSON.Utils.Constant;

import java.io.File;


public class DeleteCart {
    @Steps
    CartsAPI cartsAPI;


    //Positive Case
    @Given("Delete a cart with valid id {int}")
    public void deleteACartWithValidId(int id) {
        CartsAPI.deleteCart(id);
    }

    @When("Send request delete a cart")
    public void sendRequestDeleteACart()  {
        SerenityRest.when().delete(CartsAPI.DELETE_CART);
    }

    @Then("Should return code {int}")
    public void shouldReturnCode(int code)  {
        SerenityRest.then().statusCode(code);
    }

    @And("Validate schema delete a cart")
    public void validateSchemaDeleteACart() {
        File jsonSchema=new File(Constant.JSON_SCHEMA+"Carts/DeleteCartValid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }


    //Negative Case
    @Given("Delete a cart with invalid id {int}")
    public void deleteACartWithInvalidId(int id) {CartsAPI.deleteCart(id);
    }

    @And("Validate schema delete a cart invalid id")
    public void validateSchemaDeleteACartInvalidId() {
        File jsonSchema=new File(Constant.JSON_SCHEMA+"Carts/DeleteCartInvalid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }
}
