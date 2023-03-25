package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.ProductsAPI;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

public class PostAddNewProduct {
    @Steps
    ProductsAPI productsAPI;
    //Positive Case
    @Given("Post new product with valid json")
    public void postNewProductWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"Products/AddNewProduct.json");
        productsAPI.getAddNewProduct(json);
    }

    @When("Send request post new product")
    public void sendRequestPostNewProduct() {
        SerenityRest.when().post(ProductsAPI.POST_ADD_PRODUCT);
    }

    @And("Response body page is new product with id")
    public void responseBodyPageIsNewProductWithId() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Products/AddNewProduct.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Case
    @Given("Post new product with empty json")
    public void postNewProductWithEmptyJson() {
        File json = new File(Constant.JSON_REQUEST+"Products/InvalidAddNewProduct.json");
        productsAPI.getInvalidAddNewProduct(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int status) {
        SerenityRest.then().statusCode(status);
    }
}
