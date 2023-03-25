package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.TodosAPI;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

public class PostAddNewTodos {
    @Steps
    TodosAPI todosAPI;

//    POSITIVE CASE
    @Given("Post add new todos with valid data json file")
    public void postAddNewTodosWithValidDataJsonFile() {
        File jsonTodos = new File(Constant.JSON_REQUEST+"Todos/PostAddNewTodos.json");
        todosAPI.postAddaNewTodos(jsonTodos);
    }
    @When("Send request post add new todos")
    public void sendRequestPostAddNewTodos() {
        SerenityRest.when().post(TodosAPI.POST_ADD_NEW_TODOS);
    }
    @And("Add validate json schema add new todos")
    public void addValidateJsonSchemaAddNewTodos() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Todos/PostAddNewTodos.json");
        todosAPI.postAddaNewTodos(jsonSchema);
    }
//    NEGATIVE CASE
    @Given("Post add new todos with invalid data json body file")
    public void postAddNewTodosWithInvalidDataJsonBodyFile() {
        File jsonTodos = new File(Constant.JSON_REQUEST+"Todos/PostAddNewTodosInvalid.json");
        todosAPI.PostInvalidAddNewTodos(jsonTodos);

    }
    @When("Send request invalid post add new todos")
    public void sendRequestInvalidPostAddNewTodos() {
        SerenityRest.when().post(TodosAPI.POST_ADD_NEW_TODOS);
    }
}
