package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.TodosAPI;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PutUpdateTodos {
    @Steps
    TodosAPI todosAPI;

//    POSITIVE CASE
    @Given("Put update todos with valid id {int}")
    public void putUpdateTodosWithValidId(int id) {
        todosAPI.putUpdateTodos(id);

    }
    @When("Send request put update todos")
    public void sendRequestPutUpdateTodos() {
        SerenityRest.when().put(TodosAPI.PUT_UPDATE_TODOS);
    }
//    NEGATIVE CASE
    @Given("Given Put update todos with invalid data json file")
    public void givenPutUpdateTodosWithInvalidDataJsonFile() {
        File jsonTodos = new File(Constant.JSON_REQUEST+"Todos/PutUpdateTodos.json");
        todosAPI.putUpdateTodosInvalidBodyJson(jsonTodos);
    }

    @Then("Status cde should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badrequest) {
        SerenityRest.then().statusCode(badrequest);
    }

    @When("Send request put update invalid todos")
    public void sendRequestPutUpdateInvalidTodos() {
        SerenityRest.when().put(TodosAPI.PUT_INVALID_UPDATE_TODOS);
    }
}
