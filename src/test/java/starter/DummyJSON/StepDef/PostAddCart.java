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

public class PostAddCart {

    @Steps
    CartsAPI cartsAPI;

    @Given("Post add new cart with valid json and valid user id {int}")
    public void postAddNewCartWithValidJsonAndValidUserId(int id) {
        File json = new File(Constant.JSON_SCHEMA + "Cart/PostAddNewCartInvalid.json");
    }

    @When("Send request post add new cart")
    public void sendRequestPostAddNewCart()  {
        SerenityRest.when().post(CartsAPI.POST_ADD_CART);
    }

    @And("Response body user id should be {int}")
    public void responseBodyUserIdShouldBe(int userId) {
        SerenityRest.then().body("userId", equalTo(userId));
    }

    @And("Validate json schema post add cart")
    public void validateJsonSchemaPostAddCart(){
        File jsonSchema=new File(Constant.JSON_SCHEMA+"Carts/PostAddNewCartValid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.
                matchesJsonSchema(jsonSchema));
    }

    @Given("Post add new cart with invalid json")
    public void postAddNewCartWithInvalidJson() {
    }
}
