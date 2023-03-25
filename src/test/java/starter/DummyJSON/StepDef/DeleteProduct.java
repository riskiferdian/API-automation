package starter.DummyJSON.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.ProductsAPI;

public class DeleteProduct{

    @Steps
    ProductsAPI productsAPI;

    @Given("Delete product with valid parameter id {int}")
    public void deleteAProductWithValidParameterIdId(int id) {
        productsAPI.deleteProduct(id);
    }

    @When("Send request delete product")
    public void sendRequestDeleteProduct() {
        SerenityRest.when().delete(ProductsAPI.DELETE_PRODUCT);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int status) {
        SerenityRest.then().statusCode(status);
    }

    @Given("Delete product with invalid id {string}")
    public void deleteProductWithInvalidIdId(String id) {
        productsAPI.invalidDeleteProduct(id);
    }
}
