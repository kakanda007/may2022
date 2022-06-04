package qaautomation.may2022;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIFocus {

	String token = "";
	String expired ="";

	@Test
	public void loginAPI() {

		RestAssured.baseURI = "https://focusgl.focusolusi.id";
		String payload = "{\"username\":\"stive\",\"password\":\"focus\"}";

		Response responseLogin = RestAssured.given().contentType("application/json").body(payload).when()
				.post("/api/auth");

		
		token = responseLogin.jsonPath().get("access_token");
		expired = responseLogin.jsonPath().get("expires_in_hours");
		System.out.println(token);
		System.out.println(expired);

	}

}

