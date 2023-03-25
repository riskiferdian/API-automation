package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.ReqAPI.CommentsAPI;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleComment {
    @Steps
    CommentsAPI commentsApi;

    //Scenario Get single comment by valid post id
    @Given("get comment by post id {int}")
    public void getCommentByPostId(int id) {
        commentsApi.getSingleComment(id);
    }

    @When("send request get comment")
    public void sendRequestGetComment() {
        SerenityRest.when().get(CommentsAPI.GET_COMMENTS);
    }

    @And("response body id should be {int}")
    public void responseBodyIdShouldBeCommentsID(int commentsID) {
        SerenityRest.then()
                .body("'comments'[0].'id'", equalTo(commentsID));
    }

    @And("validate json schema get comments")
    public void validateJsonSchemaGetComments() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Comments/SuccessGetSingleComment.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario Get single comment by invalid post id
    @Given("get comment by invalid post id {string}")
    public void getCommentByInvalidPostId(String invalidID) {
        commentsApi.getSingleCommentWithInvalidId(invalidID);
    }

    @When("send invalid request get comment")
    public void sendInvalidRequestGetComment() {
        SerenityRest.when().get(CommentsAPI.INVALID_GET_COMMENTS);
    }
}
