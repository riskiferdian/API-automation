package starter.DummyJSON.ReqAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

public class CartsAPI {
    public static String GET_ALL_CARTS = Constant.BASE_URL + "carts";

    public static String GET_SINGLE_CART = Constant.BASE_URL + "carts/{id}";

    public static String POST_ADD_CART = Constant.BASE_URL + "carts/add";

    public static String DELETE_CART = Constant.BASE_URL + "carts/{id}";

    public static String GET_CART_OF_USER = Constant.BASE_URL + "carts/users/{id}";

    public static String PUT_UPDATE_CART = Constant.BASE_URL + "carts/{id}";

    //Pengerjaan Hari Rabu
    @Step("Get All Carts")
    public void getAllCarts() {
        SerenityRest.given();
    }

    @Step("Get Invalid All Carts")
    public static void getInvalidAllCarts() {
        SerenityRest.given();
    }

    @Step("Get Single Cart")
    public static void getSingleCart(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get Invalid Single Cart")
    public void getInvalidSingleCart(String id) {
        SerenityRest.given().pathParam("id", id);
    }

    //Pengerjaan Hari Kamis
    @Step("Delete Cart With Id")
    public static void deleteCart(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Post cart")
    public void postCart(int id, File json) {
        SerenityRest.given().pathParam("id", id).body(json).contentType(ContentType.JSON);
    }

    @Step("Post cart invalid")
    public void postCarts(File json) {
        SerenityRest.given().body(json).contentType(ContentType.JSON);
    }

    @Step("Get cart of user")
    public void getCartOfUser(int id) {
        SerenityRest.given().pathParam("id", id);

    }

    @Step("Put update cart")
    public void putUpdateCart(int id, File json){
        SerenityRest.given().pathParam("id", id).body(json).contentType(ContentType.JSON);
    }
}

