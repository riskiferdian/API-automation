package starter.DummyJSON.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.TodosAPI;

public class GetTodosByUser {

    @Steps
    TodosAPI todosAPI;

//    POSITIVE CASE
    @Given("Get todos by user with valid parameter id {int}")
    public void getTodoByUserWithValidParameterId(int id) {
        todosAPI.getTodosByUser(id);

    }
    @When("Send request get todos by user")
    public void sendRequestGetTodoByUser() {
        SerenityRest.when().get(TodosAPI.GET_All_TODOS_BY_USER);

    }
//    NEGATIVE CASE
    @Given("Get all todos by user with invalid parameter {string}")
    public void getAllTodosByUserWithInvalidParameter(String id) {
        todosAPI.getInvalidAllTodosByUser(id);
    }

    @When("Send request invalid get todos by user")
    public void sendRequestInvalidGetTodoByUser() {
        SerenityRest.when().get(TodosAPI.GET_INVALID_ALL_TODOS_BY_USER);
    }
}
