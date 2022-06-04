package qaautomation.may2022;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIRegress {

	String name = "";

	@Test
	public void loginAPI() {

		RestAssured.baseURI = "https://reqres.in/";
		String payload = "{\"name\":\"morpheus\",\"job\":\"leader\"}";

		Response responseLogin = RestAssured.given().contentType("application/json").body(payload).when()
				.post("/api/users");

		
		name = responseLogin.jsonPath().get("name");
		System.out.println(name);

	}

}

