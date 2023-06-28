package com.mycompany.group234.integrationtest;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.group234.SpringApp;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "spring.config.location=classpath:application-test.yml" })
class ControllerTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private final ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private WebApplicationContext context;
  @LocalServerPort
  private int port;

  @BeforeEach
  void setup() {
    RestAssuredMockMvc.webAppContextSetup(context);
  }

  
  
   private JsonNode getJSONFromFile(String filePath) throws IOException {
    try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)){
      JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
      return jsonNode;
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  
  private String getPayload(String filePath) throws IOException {
	  String jsonString = mapper.writeValueAsString( getJSONFromFile(filePath) );
	  return jsonString;
  }

  @Test
  void testRetrieveServiceDocument() {
    final String xml = given()
        .accept(ContentType.XML)
        .when()
        .get("/generated_app/")
        .then()
        .statusCode(HttpStatusCode.OK.getStatusCode())
        .contentType(ContentType.XML)
        .extract()
        .asString();

    final XmlPath path = new XmlPath(xml);
    final Collection<Node> n = ((Node) ((Node) path.get("service")).get("workspace")).get("collection");
    assertNotNull(n);
    assertFalse(n.isEmpty());
  }

  @Test
  void  testRetrieveMetadataDocument() {
    final String xml = given()
        .when()
        .get("/generated_app/$metadata")
        .then()
        .statusCode(HttpStatusCode.OK.getStatusCode())
        .contentType(ContentType.XML)
        .extract()
        .asString();

    final XmlPath path = new XmlPath(xml);
    final Node n = ((Node) ((Node) path.get("edmx:Ed mx")).get("DataServices")).get("Schema");
    assertNotNull(n);
    assertEquals("generated_app", n.getAttribute("Namespace"));
    assertNotNull(n.get("EntityContainer"));
  }

	

	
  @Test
  void  testCreateCompetativeAnalysisInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("CompetativeAnalysisInstance.json"))
        .when()
        .post("/generated_app/CompetativeAnalysis")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsCompetativeAnalysis() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("CompetativeAnalysisInstance.json"))
        .when()
        .post("/generated_app/CompetativeAnalysis")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/generated_app/CompetativeAnalysis?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ID", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/generated_app/CompetativeAnalysis/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateDataAnalysisInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("DataAnalysisInstance.json"))
        .when()
        .post("/generated_app/DataAnalysis")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsDataAnalysis() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("DataAnalysisInstance.json"))
        .when()
        .post("/generated_app/DataAnalysis")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/generated_app/DataAnalysis?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).DataAnalysisID", equalTo("'<<replace_with_keyFieldValue>>'"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/generated_app/DataAnalysis/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateSurveyInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("SurveyInstance.json"))
        .when()
        .post("/generated_app/Surveys")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsSurvey() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("SurveyInstance.json"))
        .when()
        .post("/generated_app/Surveys")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/generated_app/Surveys?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).SurveyID", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/generated_app/Surveys/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateAdvertisingAgencyInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("AdvertisingAgencyInstance.json"))
        .when()
        .post("/generated_app/AdvertisingAgencies")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsAdvertisingAgency() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("AdvertisingAgencyInstance.json"))
        .when()
        .post("/generated_app/AdvertisingAgencies")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/generated_app/AdvertisingAgencies?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ID", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/generated_app/AdvertisingAgencies/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateMediaPlanAndBuyingInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("MediaPlanAndBuyingInstance.json"))
        .when()
        .post("/generated_app/MediaPlanAndBuyings")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsMediaPlanAndBuying() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("MediaPlanAndBuyingInstance.json"))
        .when()
        .post("/generated_app/MediaPlanAndBuyings")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/generated_app/MediaPlanAndBuyings?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ID", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/generated_app/MediaPlanAndBuyings/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateBrandPerceptionInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("BrandPerceptionInstance.json"))
        .when()
        .post("/generated_app/BrandPerceptions")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsBrandPerception() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("BrandPerceptionInstance.json"))
        .when()
        .post("/generated_app/BrandPerceptions")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/generated_app/BrandPerceptions?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).ID", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/generated_app/BrandPerceptions/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateFocusGroupInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("FocusGroupInstance.json"))
        .when()
        .post("/generated_app/FocusGroups")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsFocusGroup() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("FocusGroupInstance.json"))
        .when()
        .post("/generated_app/FocusGroups")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/generated_app/FocusGroups?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).FGID", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/generated_app/FocusGroups/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateMarketResearchInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("MarketResearchInstance.json"))
        .when()
        .post("/generated_app/MarketResearches")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsMarketResearch() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("MarketResearchInstance.json"))
        .when()
        .post("/generated_app/MarketResearches")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/generated_app/MarketResearches?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).MRID", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/generated_app/MarketResearches/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
	

	
  @Test
  void  testCreateTargetMarketIdentificationInstance() throws IOException {
    given()
        .contentType("application/json")
        .body(getPayload("TargetMarketIdentificationInstance.json"))
        .when()
        .post("/generated_app/TargetMarketIdentifications")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
    
  }
	
	
  
   
  
   @Test
  public void testSystemFilterOptionsTargetMarketIdentification() throws IOException {
  
  given()
        .contentType("application/json")
        .body(getPayload("TargetMarketIdentificationInstance.json"))
        .when()
        .post("/generated_app/TargetMarketIdentifications")
        .then()
        .statusCode(HttpStatusCode.CREATED.getStatusCode());
   given()
            .when()
            .get("/generated_app/TargetMarketIdentifications?$top=1")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body("value.get(0).TargetMarketID", equalTo("<<replace_with_keyFieldValue>>"))
            .body("value.size()", is(1));
    given()
            .when()
            .get("/generated_app/TargetMarketIdentifications/$count")
            .then()
            .statusCode(HttpStatusCode.fromStatusCode(200).getStatusCode())
            .body(is("1"));
            
            
    
    } 
	
           
       
  
  
  
  
 
  @AfterEach
  void  teardown() {
    jdbcTemplate.execute("DELETE FROM generated_app.CompetativeAnalysis");
    jdbcTemplate.execute("DELETE FROM generated_app.DataAnalysis");
    jdbcTemplate.execute("DELETE FROM generated_app.Survey");
    jdbcTemplate.execute("DELETE FROM generated_app.AdvertisingAgency");
    jdbcTemplate.execute("DELETE FROM generated_app.MediaPlanAndBuying");
    jdbcTemplate.execute("DELETE FROM generated_app.BrandPerception");
    jdbcTemplate.execute("DELETE FROM generated_app.FocusGroup");
    jdbcTemplate.execute("DELETE FROM generated_app.MarketResearch");
    jdbcTemplate.execute("DELETE FROM generated_app.TargetMarketIdentification");
     jdbcTemplate.execute("DELETE FROM generated_app.FocusGroupFeedback2");
     jdbcTemplate.execute("DELETE FROM generated_app.MarketResearchConducts");
     jdbcTemplate.execute("DELETE FROM generated_app.MarketResearchAnalysis");
     jdbcTemplate.execute("DELETE FROM generated_app.SurveyFeedback1");
     jdbcTemplate.execute("DELETE FROM generated_app.AdvertisingAgencyPerforms");
     jdbcTemplate.execute("DELETE FROM generated_app.AdvertisingAgencyBrandevaluation");
     jdbcTemplate.execute("DELETE FROM generated_app.DataAnalysisFeedback3");
     jdbcTemplate.execute("DELETE FROM generated_app.MarketResearchDoes");
     jdbcTemplate.execute("DELETE FROM generated_app.AdvertisingAgencyCompetitorAnalysis");
     jdbcTemplate.execute("DELETE FROM generated_app.AdvertisingAgencyMediabuying");

    RestAssuredMockMvc.reset();
  }
}
