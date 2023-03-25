package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.ProductsAPI;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

public class GetSearchProduct {
    @Steps
    ProductsAPI productsAPI;

    //Positive Case
    @Given("Get search product with valid path {string}")
    public void getSearchProductWithValidPath(String string) {
        productsAPI.getSearchProduct(string);
    }

    @When("Send request get search product")
    public void sendRequestPostSearchProduct() {
        SerenityRest.when().get(ProductsAPI.POST_SEARCH_PRODUCT);
    }

    @And("Validate json schema search product")
    public void validateJsonSchemaSearchProduct() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Products/GetSearchProduct.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Case
    @Given("Get search product with invalid parameter {string}")
    public void getSearchProductWithInvalidParameter(String string){
        productsAPI.getInvalidSearchProduct(string);
    }
}
