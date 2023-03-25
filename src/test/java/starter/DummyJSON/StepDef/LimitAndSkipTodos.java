package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.TodosAPI;

import static org.hamcrest.CoreMatchers.equalTo;

public class LimitAndSkipTodos {
    @Steps
    TodosAPI todosAPI;
//    POSITIVE CASE
    @Given("Get limit {int} and skip {int} todos")
    public void getLimitLimitAndSkipSkipTodos(int limit,int skip) {
        todosAPI.limitAndSkipTodos(limit,skip);

    }
    @When("Send request get limit and skip")
    public void sendRequestGetLimitAndSkips() {
        SerenityRest.when().get(TodosAPI.LIMIT_AND_SKIP_TODOS);
    }

    @And("responses body limit is {int} and skip is {int}")
    public void responsesBodyLimitIsLimitAndSkipIsSkip(int limit, int skip) {
        SerenityRest.then().body("limit",equalTo(limit)).body("skip",equalTo(skip));
    }
//    NEGATIVE CASE
    @Given("Get limit {int} and invalid skip {string} todos")
    public void getLimitLimitAndInvalidSkipSkipTodos(int limit, String skip) {
        todosAPI.InvalidLimitAndSkipTodos(limit,skip);
    }
}
