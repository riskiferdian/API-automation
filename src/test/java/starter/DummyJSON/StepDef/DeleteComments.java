package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.CommentsAPI;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class DeleteComments {
    @Steps
    CommentsAPI commentsApi;

    //Scenario Delete comment with valid id
    @Given("Delete comment with id {int}")
    public void deleteCommentWithId(int id) {
        commentsApi.deleteSingleComment(id);
    }

    @When("send request delete comment")
    public void sendRequestDeleteComment() {
        SerenityRest.when().delete(CommentsAPI.DELETE_SINGLE_COMMENTS);
    }

    @Then("API should return status code {int}")
    public void apiShouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("response body id should be {int} and user ID {int}, and Username {string}")
    public void responseBodyIdShouldBeAndIsDeleted(int id, int userID, String userName) {
        SerenityRest.then()
                .body("id", equalTo(id))
                .body("user.id", equalTo(userID))
                .body("user.username", equalTo(userName));
    }

    @And("validate json schema success delete comments")
    public void validateJsonSchemaSuccessDeleteComments() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Comments/SuccessDeleteSingleComment.json");
        SerenityRest.then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario Delete comment with invalid id
    @Given("Delete comment with id {string}")
    public void deleteCommentWithId(String id) {
        commentsApi.deleteSingleCommentWithInvalidId(id);
    }

    @When("send invalid request delete comment")
    public void sendInvalidRequestDeleteComment() {
        SerenityRest.when().delete(CommentsAPI.INVALID_DELETE_SINGLE_COMMENTS);
    }

    @And("response body error should be {string}")
    public void responseBodyErrorShouldBe(String errorMessage) {
        SerenityRest.then()
                .body("message", equalTo(errorMessage));
    }

    @And("validate json schema failed delete comments")
    public void validateJsonSchemaFailedDeleteComments() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Comments/FailedDeleteSingleComment.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario Delete comments with filter
    @Given("Delete comments with limit {int} and skip {int}")
    public void deleteCommentsWithLimitAndSkip(int limit, int skip) {
        commentsApi.deleteCommentsWithFilter(limit, skip);
    }

    @When("send request delete comment with filter")
    public void sendRequestDeleteCommentWithFilter() {
        SerenityRest.when().delete(CommentsAPI.INVALID_DELETE_COMMENTS);
    }
}
