package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.Utils.Constant;
import starter.DummyJSON.ReqAPI.ProductsAPI;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetSingleProduct {
    @Steps
    ProductsAPI productsAPI;

    //POSITIVE CASE
    @Given("Get single product with valid id {int}")
    public void getAllProductValid(int id) {
        productsAPI.getSingleProduct(id);
    }

    @When("Send request get single product")
    public void sendRequestGetAllProduct() {
        SerenityRest.when().get(ProductsAPI.GET_SINGLE_PRODUCT);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int status) {
        SerenityRest.then().statusCode(status);
    }

    @And("Response body id should be {int}")
    public void responseBodyGetIdShouldBe(int id) {
        SerenityRest.then().body("id",equalTo(id));
    }

    @And("validate json schema get all products")
    public void validateJsonSchemaGetAllProducts() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Products/GetSingleProduct.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    //NEGATIVE CASE

    @Given("Get single product with invalid id {string}")
    public void getiSingleProductWithInvalidId(String id) {
        productsAPI.getInvalidSingleProduct(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeBadRequest(int status) {
        SerenityRest.then().statusCode(status);
    }
}
