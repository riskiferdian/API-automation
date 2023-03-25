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

import static org.hamcrest.CoreMatchers.equalTo;

public class PutUpdateCart {

    @Steps
    CartsAPI cartsAPI;

    //Positive Case

    @Given("Put update a cart with valid json and id {int}")
    public void putUpdateACartWithValidJsonAndId(int id) {
        File json= new File(Constant.JSON_REQUEST + "Carts/PutUpdateCartValid.json");
        cartsAPI.putUpdateCart(id, json);

    }

    @When("Send request put update a cart")
    public void sendRequestPutUpdateACart() {
        SerenityRest.when().put(CartsAPI.PUT_UPDATE_CART);
    }

    @And("Response body should be id {int}")
    public void responseBodyShouldBeId(int id) {SerenityRest.then().body("id", equalTo(id));
    }

    @And("Validate json schema put update cart")
     public void validateJsonSchemaPutUpdateCart() {
     File jsonSchema=new File(Constant.JSON_SCHEMA+"Carts/PutUpdateCartValid.json");
     SerenityRest.then().assertThat().body(JsonSchemaValidator.
     matchesJsonSchema(jsonSchema));
    }


    //Negative Case
    @Given("Put update a cart with id {int} invalid json")
    public void putUpdateACartWithInvalidJson(int id) {
        File json=new File(Constant.JSON_REQUEST+"Carts/PutUpdateCartInvalid.json");
        cartsAPI.putUpdateCart(id, json);
    }

    @And("Validate json schema put update cart invalid json")
    public void validateJsonSchemaPutUpdateCartInvalidJson() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Carts/PutUpdateCartInvalidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }
}
