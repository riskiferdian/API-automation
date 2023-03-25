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

public class CreateNewComments {
    @Steps
    CommentsAPI commentsApi;

    //Scenario Post add new comment with invalid path
    @Given("Post add new comment with valid json")
    public void postAddNewCommentWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"Comments/RequestPostComment.json");
        commentsApi.postNewComment(json);
    }

    @When("send invalid request post comment")
    public void sendInvalidRequestPostComment() {
        SerenityRest.when().post(CommentsAPI.INVALID_POST_COMMENTS);
    }

    //Scenario Post add new comment with valid path
    @When("send request post comment")
    public void sendRequestPostComment() {
        SerenityRest.when().post(CommentsAPI.POST_COMMENTS);
    }

    @And("response body post ID should be {int}, user ID {int}, and body {string}")
    public void responseBodyPostIDShouldBeUserIDAndBody(int postID, int userID, String body) {
        SerenityRest.then()
                .body("postId", equalTo(postID))
                .body("user.id", equalTo(userID))
                .body("body", equalTo(body));
    }

    @And("validate json schema post comments")
    public void validateJsonSchemaPostComments() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Comments/SuccessPostNewComment.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
