package apiBuilders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

//This class is to build the requests that will be used in our test
public class RequestBuilders {

    //Declare the request specification and the url used
    static RequestSpecBuilder reqBuilder;
    static RequestSpecification reqSpec;
    static String baseURI = "https://petstore.swagger.io/v2/pet";

    //Create and return the request specification to search about a pet using id
    public static RequestSpecification requestBuilderGetPetParameters(String pathParameter){

        reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(baseURI);
        reqBuilder.setBasePath(pathParameter);
        reqSpec = reqBuilder.build();

        return reqSpec;
    }

    //Create and return the request specification to add a new pet to the server
    public static RequestSpecification requestBuilderPostNewPet(){

        reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(baseURI).
                setContentType("application/json").
                setAccept("application/json");
        reqSpec = reqBuilder.build();

        return reqSpec;
    }

    //Create and return the request specification to edit existing pet
    public static RequestSpecification requestBuilderEditPet(){

        reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(baseURI).
                setContentType("application/json").
                setAccept("application/json");
        reqSpec = reqBuilder.build();

        return reqSpec;
    }

    //Create and return the request specification to delete a pet from the  server
    public static RequestSpecification requestBuilderDeletePet(String pathParameter){

        reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(baseURI);
        reqBuilder.setBasePath(pathParameter);
        reqSpec = reqBuilder.build();

        return reqSpec;
    }

}
