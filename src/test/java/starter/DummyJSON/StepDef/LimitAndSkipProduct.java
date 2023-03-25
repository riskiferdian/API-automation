package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.ProductsAPI;

import static org.hamcrest.CoreMatchers.equalTo;

public class LimitAndSkipProduct {
    @Steps
    ProductsAPI productsAPI;
    //Positive Case
    @Given("Get limit {int} and skip {int} product")
    public void getLimitLimitAndSkipSkipProduct(int limit, int skip) {
        productsAPI.getLimitSkipProduct(limit, skip);
    }

    @When("Send request get limit and skip product")
    public void sendRequestGetLimitAndSkip() {
        SerenityRest.when().get(ProductsAPI.LIMIT_SKIP_PRODUCT);
    }

    @And("response body limit is {int} and skip is {int}")
    public void responseBodyLimitIsLimitAndSkipIsSkip(int limit, int skip) {
        SerenityRest.then()
                .body("limit",equalTo(limit))
                .body("skip",equalTo(skip));
    }

    //Negative Case
    @Given("Get invalid limit {string} and skip {string} product")
    public void getInvalidLimitLimitAndSkipSkipProduct(String limit, String skip){
        productsAPI.getInvalidLimitSkipProduct(limit, skip);
    }
}
