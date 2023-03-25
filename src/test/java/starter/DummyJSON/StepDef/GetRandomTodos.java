package starter.DummyJSON.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.TodosAPI;

public class GetRandomTodos {

    @Steps
    TodosAPI todosAPI;

//    POSITIVE CASE
    @Given("Get a random todos with valid parameter")
    public void getARandomTodoWithValidParameter() {
        todosAPI.getRandomTodos();
    }
    @When("Send request get a random todos")
    public void sendRequestGetARandomTodo() {
        SerenityRest.when().get(TodosAPI.GET_RANDOM_TODOS);
    }

//    NEGATIVE CASE

    @When("Send request invalid get a random todos")
    public void sendRequestInvalidGetARandomTodo() {
        SerenityRest.when().get(TodosAPI.GET_INVALID_RANDOM_TODOS);
    }

    @Given("Get a random todos with invalid parameter id {int}")
    public void getARandomTodoWithInvalidParameterIdId(int id) {
        todosAPI.getInvalidRandomTodos(id);

    }
}
