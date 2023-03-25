package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.ProductsAPI;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

public class GetCategoryOfProduct {
    @Steps
    ProductsAPI productsAPI;
    //Positive Case
    @Given("Get products of category with valid parameter {string}")
    public void getProductsOfCategoryWithValidParameter(String category) {
        productsAPI.getCategoryProduct(category);
    }

    @When("Send request get category of product")
    public void sendRequestGetCategoryOfProduct() {
        SerenityRest.when().get(ProductsAPI.CATEGORY_OF_PRODUCT);
    }

    @And("Validate category json schema")
    public void validateCategoryJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Products/CategoryOfProduct.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get products of category with invalid path {string}")
    public void getProductsOfCategoryWithInvalidPath(String category) {
        productsAPI.getInvalidCategoryProduct(category);
    }
}
