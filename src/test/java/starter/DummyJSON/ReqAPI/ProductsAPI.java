package starter.DummyJSON.ReqAPI;

import io.cucumber.java.eo.Se;
import io.restassured.http.ContentType;
import org.checkerframework.checker.units.qual.C;
import starter.DummyJSON.Utils.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ProductsAPI {

    public static String GET_SINGLE_PRODUCT = Constant.BASE_URL +"products/{id}";
    public static String GET_ALL_PRODUCT = Constant.BASE_URL +"products";
    public static String POST_ADD_PRODUCT = Constant.BASE_URL +"products/add";
    public static String POST_SEARCH_PRODUCT = Constant.BASE_URL +"products/search?q={string}";
    public static String UPDATE_PRODUCT = Constant.BASE_URL +"products/{id}";
    public static String LIMIT_SKIP_PRODUCT = Constant.BASE_URL+"products?limit={limit}&skip={skip}&select=title,price";
    public static String All_PRODUCT_CATEGORIES = Constant.BASE_URL+"products/categories";
    public static String CATEGORY_OF_PRODUCT = Constant.BASE_URL+"products/category/{category}";
    public static String DELETE_PRODUCT = Constant.BASE_URL+"products/{id}";


    @Step("get all product")
    public void getAllProduct(){
        SerenityRest.given();
    }

    @Step("get invalid all product")
    public void getInvalidAllProduct(){
        SerenityRest.given();
    }

    @Step("get single product")
    public void getSingleProduct(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("get invalid single product")
    public void getInvalidSingleProduct(String id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("post add new product")
    public void getAddNewProduct(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("post invalid add new product")
    public void getInvalidAddNewProduct(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("get search product")
    public void getSearchProduct(String string){
        SerenityRest.given()
                .pathParam("string",string);
    }

    @Step("get invalid search product")
    public void getInvalidSearchProduct(String string){
        SerenityRest.given()
                .pathParam("string",string);
    }

    @Step("put update a product")
    public void putUpdateProduct(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("put invalid update a product")
    public void putInvalidUpdateProduct(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("get limit and skip product")
    public void getLimitSkipProduct(int limit, int skip){
        SerenityRest.given()
                .pathParam("limit",limit)
                .pathParam("skip",skip);
    }
    @Step("get invalid limit and skip product")
    public void getInvalidLimitSkipProduct(String limit, String skip){
        SerenityRest.given()
                .pathParam("limit",limit)
                .pathParam("skip",skip);
    }

    @Step("get all products categories")
    public void allProductsCategories(){
        SerenityRest.given();
    }

    @Step("get invalid all products categories")
    public void allInvalidProductsCategories(){
        SerenityRest.given();
    }

    @Step("get category of product")
    public void getCategoryProduct(String category){
        SerenityRest.given().pathParam("category",category);
    }
    @Step("get invalid category of product")
    public void getInvalidCategoryProduct(String category){
        SerenityRest.given().pathParam("category",category);
    }

    @Step("delete a product")
    public void deleteProduct(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("delete a product")
    public void invalidDeleteProduct(String id){
        SerenityRest.given().pathParam("id",id);
    }
}
