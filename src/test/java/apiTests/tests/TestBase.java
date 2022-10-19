package apiTests.tests;

import apiBuilders.RequestBuilders;
import apiTests.utils.ReadingJsonfile;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

//This class has all method used  in test
public class TestBase {

    Response response;

    //A method to get a string parameter value from json format
    public String getParameterValue(String parameter, String methodName){
        if (methodName.contentEquals("NewPet")){
            JSONObject bodyJsonPath = new JSONObject(ReadingJsonfile.readingJsonFiles("newPetData.json"));
            return bodyJsonPath.get(parameter).toString();
        }else if (methodName.contentEquals("EditPet")){
            JSONObject bodyJsonPath = new JSONObject(ReadingJsonfile.readingJsonFiles("changePetData.json"));
            return bodyJsonPath.get(parameter).toString();
        }else{
            return "";
        }
    }

    public Response getPetById(String id){
        //create the get method and return the response
        return response = given().
                spec(RequestBuilders.requestBuilderGetPetParameters(id)).
                get().
                then().
                log().all().
                and().extract().response();
    }

    public Response postNewPet(){
        //create the post method and return the response
        return response = given().spec(RequestBuilders.requestBuilderPostNewPet()).
                body(ReadingJsonfile.readingJsonFiles("newPetData.json")).
                when().
                post().
                then().
                log().all().
                and().extract().response();
    }

    public Response editPetData(){
        //create the put method and return the response
        return response = given().spec(RequestBuilders.requestBuilderEditPet()).
                body(ReadingJsonfile.readingJsonFiles("changePetData.json")).
                when().
                post().
                then().
                log().all().
                and().extract().response();
    }

    public Response deletePetById(String id){
        //create the delete method and return the response
        return response = given().spec(RequestBuilders.requestBuilderDeletePet(id)).
                delete().
                then().
                log().all().
                and().extract().response();
    }
}
