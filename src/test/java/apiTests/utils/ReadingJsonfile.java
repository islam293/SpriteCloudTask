package apiTests.utils;

import io.restassured.internal.util.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

//A class to read the body from a json file
public class ReadingJsonfile {
    private static FileInputStream fileStream;
    private static String streamedBody;

    //Reading a json file to get requests body
    public static String readingJsonFiles(String fileName) {

        try {
            fileStream = new FileInputStream("src/test/java/apiTests/resources/" + fileName);
            streamedBody = new String(IOUtils.toByteArray(fileStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return streamedBody;
    }
}
