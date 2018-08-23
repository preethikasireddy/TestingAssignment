package myproject.homepage;

import base.BaseScenario;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiScenario extends BaseScenario {
  Map<String, Response> dataMap = new HashMap<String, Response>();

  @Given("^get operation$")
  public void get_operation() throws Throwable {
    RestAssured.baseURI ="https://reqres.in";
    RequestSpecification request = RestAssured.given();
    String url ="/api/users?page=2";
    Response response = request.get(url);
    dataMap.put("GET",response);

    assertEquals(dataMap.get("GET").getStatusCode(),200);
    assertEquals(dataMap.get("GET").jsonPath().get("page"),2);
  }

  public RequestSpecification requestHeaders(){

    RequestSpecification request = RestAssured.given();
    Header h1= new Header("Content-Type", "application/json");
    List<Header> list = new ArrayList<Header>();
    list.add(h1);
    Headers header = new Headers(list);
    return request.headers(header);
  }
  @Given("^post operation$")
  public void post_operation() throws Throwable {
    RequestSpecification request = RestAssured.given();
    String url ="/api/users";
    RequestSpecification  rh = requestHeaders();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode requestParams = mapper.createObjectNode();
    ((ObjectNode) requestParams).put("name","morpheus");
    ((ObjectNode) requestParams).put("job","leader");
    rh.body(requestParams);
    Response response = rh.post(url);
    dataMap.put("POST",response);
    assertEquals(dataMap.get("POST").getStatusCode(),201);
    assertEquals(dataMap.get("POST").jsonPath().get("name"),"morpheus");
    assertEquals(dataMap.get("POST").jsonPath().get("job"),"leader");
  }

  @Given("^put operation$")
  public void put_operation() throws Throwable {
   RequestSpecification request = RestAssured.given();
    String url ="/api/users/2";
    RequestSpecification  rh = requestHeaders();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode requestParams = mapper.createObjectNode();
    ((ObjectNode) requestParams).put("name","morpheus");
    ((ObjectNode) requestParams).put("job","zion resident");
    rh.body(requestParams);
    Response response = rh.put(url);
    dataMap.put("PUT",response);
    assertEquals(dataMap.get("PUT").getStatusCode(),200);
    assertEquals(dataMap.get("PUT").jsonPath().get("name"),"morpheus");
    assertEquals(dataMap.get("PUT").jsonPath().get("job"),"zion resident");
  }

  @Given("^delete operation$")
  public void delete_operation() throws Throwable {
   RequestSpecification request = RestAssured.given();
    String url ="/api/users/2";
    Response response = request.delete(url);
    dataMap.put("PUT",response);
    assertEquals(dataMap.get("PUT").getStatusCode(),204);
  }

}
