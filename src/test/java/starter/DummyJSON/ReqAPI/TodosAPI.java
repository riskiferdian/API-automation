package starter.DummyJSON.ReqAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

public class TodosAPI {

    public static String GET_ALL_TODOS = Constant.BASE_URL +"todos";
    public static String GET_INVALID_ALL_TODOS = Constant.BASE_URL+"todos/{id}";
    public static String GET_SINGLE_TODOS = Constant.BASE_URL+"todos/{id}";
    public static String GET_RANDOM_TODOS = Constant.BASE_URL+"todos/random";
    public static String GET_INVALID_RANDOM_TODOS = Constant.BASE_URL+"todos/random/{id}";
    public static String GET_All_TODOS_BY_USER = Constant.BASE_URL+"todos/user/{id}";
    public static String GET_INVALID_ALL_TODOS_BY_USER = Constant.BASE_URL+"todos/user/{id}";
    public static String LIMIT_AND_SKIP_TODOS = Constant.BASE_URL+"todos?limit={limit}&skip={skip}";
    public static String POST_ADD_NEW_TODOS = Constant.BASE_URL+"todos/add";
    public static String PUT_UPDATE_TODOS = Constant.BASE_URL+"todos/{id}";
    public static String PUT_INVALID_UPDATE_TODOS = Constant.BASE_URL+"todos/2";
    public static String DELETE_TODOS = Constant.BASE_URL+"todos/{id}";
    public static String DELETE_INVALID_TODOS = Constant.BASE_URL+"todos/{id}";

    //    SCENARIO 1
    @Step("Get all todos")
    public void getAllTodos(){
        SerenityRest.given();
    }
    @Step("Get invalid all todos")
    public void getInvalidAllTodos(int id){
        SerenityRest.given().pathParam("id",id);
    }
    //    SCENARIO 2
    @Step("Get single todos")
    public void getSingleTodos(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get invalid single todos")
    public void getInvalidSingleTodos(String id){
        SerenityRest.given().pathParam("id",id);
    }
    //    SCENARIO 3
    @Step("Get random todos")
    public void getRandomTodos(){
        SerenityRest.given();
    }
    @Step("Get invalid random todos")
    public void getInvalidRandomTodos(int id){
        SerenityRest.given().pathParam("id",id);
    }
    //    SCENARIO 4
    @Step("Get all todos by user")
    public void getTodosByUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get invalid all todos by user")
    public void getInvalidAllTodosByUser(String id) {
        SerenityRest.given().pathParam("id",id);
    }
    //    SCENARIO 5
    @Step("Post add new todos")
    public void postAddaNewTodos(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post invalid add new todos")
    public void PostInvalidAddNewTodos(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    //    SCENARIO 6
    @Step("Put update todos")
    public void putUpdateTodos(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Put update todos invalid body json")
    public void putUpdateTodosInvalidBodyJson(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    //    SCENARIO 7
    @Step("Delete todos")
    public void DeleteTodos(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Invalid delete todos")
    public void InvalidDeleteTodos(int id){
        SerenityRest.given().pathParam("id",id);
    }
    //    SCENARIO 8
    @Step("Limit and skip todos")
    public void limitAndSkipTodos(int limit, int skip){
        SerenityRest.given()
                .pathParam("limit",limit)
                .pathParam("skip",skip);
    }
    @Step("Invalid limit and skip todos")
    public void InvalidLimitAndSkipTodos(int limit, String skip) {
        SerenityRest.given()
                .pathParam("limit", limit)
                .pathParam("skip", skip);
    }


}
