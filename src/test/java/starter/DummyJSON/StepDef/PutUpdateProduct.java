package starter.DummyJSON.StepDef;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import org.checkerframework.checker.units.qual.C;
import starter.DummyJSON.ReqAPI.ProductsAPI;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

public class PutUpdateProduct {
    @Steps
    ProductsAPI productsAPI;
    //Positive Case
    @Given("Put update a product with valid id {int} and json body")
    public void putUpdateAProductWithValidIdIdAndJsonBody(int id) {
        File json = new File(Constant.JSON_REQUEST+"Products/PutUpdateProduct.json");
        productsAPI.putUpdateProduct(id,json);
    }

    @When("Send request put update product")
    public void sendRequestPutUpdateProduct() {
        SerenityRest.when().put(ProductsAPI.UPDATE_PRODUCT);
    }

    @And("Validate json schema update product")
    public void validateJsonSchemaUpdateProduct() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Products/PutUpdateProduct.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Negative Case
    @Given("Put update a product with valid id {int} and invalid json body")
    public void putUpdateAProductWithValidIdIdAndInvalidJsonBody(int id) {
        File json = new File(Constant.JSON_REQUEST+"Products/PutInvalidUpdateProduct.json");
        productsAPI.putInvalidUpdateProduct(id,json);
    }
}
