package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class CRUD_StepDef {
	
	Response res;
	
	@Given("I have a base URI of {string}")
	public void i_have_a_base_uri_of(String URL) {
		baseURI = URL;
	    
	}

	@When("I send a GET request to {string}")
	public void i_send_a_get_request_to(String endPoint) {
	    res = given()
	    		.when()
	    		.get(endPoint);
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer stsCode) {
		res.then()
		        .log().all()
		       .statusCode(stsCode);
	    
	}
	
	@When("I send a POST request to {string} with body as {string}")
	public void i_send_a_post_request_to_with_body_as(String endPoint, String reqBody) {
		res = given()
				.log().all()
				.body(reqBody)
				.when()
				   .post(endPoint);
	    
	}

	@Then("the response time less than  {long}")
	public void the_response_time_less_than(Long millSec) {
		res.then()
		     .time(lessThan(millSec));
		
	    
	}


}
