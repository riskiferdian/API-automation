package starter.DummyJSON.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.TodosAPI;

public class DeleteTodos {
    @Steps
    TodosAPI todosAPI;

//    POSITIVE CASE
    @Given("Delete todos with valid id {int}")
    public void deleteTodosWithValidId(int id) {
        todosAPI.DeleteTodos(id);

    }
    @When("Send request delete todos")
    public void sendRequestDeleteTodos() {
        SerenityRest.when().delete(TodosAPI.DELETE_TODOS);
    }

//    NEGATIVE CASE
    @Given("Delete todos with invalid id {int}")
    public void deleteTodosWithInvalidId(int id) {
        todosAPI.InvalidDeleteTodos(id);
    }

    @When("Send request invalid delete todos")
    public void sendRequestInvalidDeleteTodos() {
        SerenityRest.when().delete(TodosAPI.DELETE_INVALID_TODOS);
    }
}
