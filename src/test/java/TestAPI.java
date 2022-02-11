
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Register;
import models.ResponseRegister;
import models.SingleUser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.RequestToCreateNewUser;
import responses.ResponseOfNewUser;

import java.time.Clock;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class TestAPI {

    @BeforeMethod
    public void preCondition() {
        baseURI = "https://reqres.in/";
        // RestAssured.basePath = "api/users/2";
    }

    @Test

    public void getSingleUserer() {
        Specifications.installSpecification(Specifications.requestSpecification(baseURI),
                Specifications.responseSpecification200ok());
        SingleUser user = given()
                .when()
                .get("api/users/2")
                .then()
                .extract().body().as(SingleUser.class);

        System.out.println(user.getData().getAvatar());
        System.out.println(user.getData().getEmail());
        System.out.println(user.getData().getFirst_name());
        System.out.println(user.getData().getLast_name());
        System.out.println(user.getData().getId());
        System.out.println(user.getSupport().toString());
    }

    @Test

    public void createNewUser() {
        Specifications.installSpecification(Specifications.requestSpecification(baseURI),
                Specifications.responseSpecification201ok());

        RequestToCreateNewUser user = RequestToCreateNewUser.builder()
                .name("morpheus")
                .job("leader")
                .build();

        ResponseOfNewUser createdUser = given()
                //   .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("api/users")
                .then()
                // .assertThat().statusCode(201)
                .extract().response().as(ResponseOfNewUser.class);

        System.out.println(createdUser.toString());
    }

    @Test
    public void SuccessfulRegistration() {
        Specifications.installSpecification(Specifications.requestSpecification(baseURI), Specifications.responseSpecification200ok());

        Register register = Register.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();

        ResponseRegister responseRegister = given()
                .body(register)
                .when()
                .post("api/register")
                .then()
                .extract().body().as(ResponseRegister.class);
        Assert.assertNotNull(responseRegister.getId());
        Assert.assertNotNull(responseRegister.getToken());

        Assert.assertEquals(4, responseRegister.getId());
        Assert.assertEquals("QpwL5tke4Pnpja7X4", responseRegister.getToken());

        System.out.println(responseRegister.getId());
        System.out.println(responseRegister.getToken());

        String regex = "(.{5})$"; // regular expression to get substrring from site regex101
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex,"");
        System.out.println(currentTime);
    }


}
