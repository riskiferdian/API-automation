package starter.DummyJSON.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.ProductsAPI;
import starter.DummyJSON.ReqAPI.TodosAPI;

public class GetAllTodos {

    @Steps
    TodosAPI todosAPI;

//    POSITIVE CASE
    @Given("Get all todos with valid parameter")
    public void getAllTodoWithValidParameter() {
        todosAPI.getAllTodos();
    }
    @When("Send request get all todos")
    public void sendRequestGetAllTodo() {
        SerenityRest.when().get(TodosAPI.GET_ALL_TODOS);
    }
//    NEGATIVE CASE
    @Given("Get all todos with invalid parameter id {int}")
    public void getAllTodoWithInvalidParameterIdId(int id) {
        todosAPI.getInvalidAllTodos(id);
    }

    @When("Send request invalid get all todos")
    public void sendRequestInvalidGetAllTodo() {
        SerenityRest.when().get(TodosAPI.GET_INVALID_ALL_TODOS);
    }
}
