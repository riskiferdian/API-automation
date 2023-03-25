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

public class GetAllCategories {
    @Steps
    ProductsAPI productsAPI;
    @Given("Get all products categories with valid path")
    public void getAllProductsCategoriesWithValidPath() {
        productsAPI.allProductsCategories();
    }

    @When("Send request get all categories")
    public void sendRequestGetAllCategories() {
        SerenityRest.when().get(ProductsAPI.All_PRODUCT_CATEGORIES);
    }

    @And("Validate all categories json schema")
    public void validateAllCategoriesJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Products/AllCategories.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get all products categories with invalid path")
    public void getAllProductsCategoriesWithInvalidPath() {
        productsAPI.allInvalidProductsCategories();
    }

    @When("Send request get invalid all categories")
    public void sendRequestGetInvalidAllCategories() {
        SerenityRest.when().get(ProductsAPI.All_PRODUCT_CATEGORIES+"s");
    }
}
