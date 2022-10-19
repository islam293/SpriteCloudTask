package apiTests.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


//This Class contains all the test modules to be tested
public class Tests extends TestBase{

    SoftAssert softAssert;
    @Test (priority = 1)
    //Test that you can successfully add new pet to the system
    //and Assert that the added pet is now exist
    public void createNewPetTest(){
        Response postResponse = postNewPet();
        softAssert = new SoftAssert();
        String bodyPetId = getParameterValue("id","NewPet");
        String bodyPetName = getParameterValue("name","NewPet");

        softAssert.assertEquals(200,postResponse.getStatusCode());
        softAssert.assertEquals(bodyPetId,postResponse.jsonPath().get("id").toString());
        softAssert.assertEquals(bodyPetName,postResponse.jsonPath().get("name").toString());

        Response getResponse = getPetById(bodyPetId);
        softAssert.assertEquals(200,postResponse.getStatusCode());
        softAssert.assertEquals(bodyPetId,getResponse.jsonPath().get("id").toString());
        softAssert.assertAll();

    }

    @Test (priority = 3)
    //Test that you can successfully edit data for an existing pet to the system
    //and Assert that the pet data is now changed
    public void EditPetDetailsTest(){
        Response editResponse = editPetData();
        softAssert = new SoftAssert();
        String bodyPetId = getParameterValue("id","EditPet");
        String bodyPetName = getParameterValue("name","EditPet");

        softAssert.assertEquals(200,editResponse.getStatusCode());
        softAssert.assertEquals(bodyPetId,editResponse.jsonPath().get("id").toString());
        softAssert.assertEquals(bodyPetName,editResponse.jsonPath().get("name").toString());


        Response getResponse = getPetById(bodyPetId);
        softAssert.assertEquals(200,getResponse.getStatusCode());
        softAssert.assertEquals(bodyPetId,getResponse.jsonPath().get("id").toString());
        softAssert.assertAll();

    }

    @Test (priority = 2)
    //Test that you can successfully delete an existing pet to the system using its id
    //and Assert that the pet data is now not existed
    public void DeletePetTest(){
        String bodyPetId = getParameterValue("id","NewPet");
        Response deleteResponse = deletePetById(bodyPetId);
        softAssert = new SoftAssert();
        softAssert.assertEquals(200,deleteResponse.getStatusCode());
        softAssert.assertEquals(bodyPetId,deleteResponse.jsonPath().get("message").toString());

        Response getResponse = getPetById(bodyPetId);
        softAssert.assertEquals(404,getResponse.getStatusCode());
        softAssert.assertEquals("Pet not found",getResponse.jsonPath().get("message").toString());
        softAssert.assertAll();

    }
}
