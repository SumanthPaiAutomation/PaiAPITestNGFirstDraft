package APIActions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;
import org.awaitility.Awaitility;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static io.restassured.RestAssured.given;


public class DelayedActions {
    public static io.restassured.response.Response restAresponse;
        public static int getTotalSize() throws ExecutionException, InterruptedException {
            Future<Response> responseFuture = Dsl.asyncHttpClient().prepareGet("https://reqres.in/api/users?delay=5").execute();
            Response response = responseFuture.get();

            int totalSize = 0;  // Initialize totalSize

            if (response.getStatusCode() == 200) {
                // Convert the response body to String and then parse it using JsonPath
                JsonPath jsonPath = new JsonPath(response.getResponseBody());
                totalSize = jsonPath.get("total");
                System.out.println("The total size is " + totalSize);
            }

            return totalSize;
        }

        public static int getTotalSizeByAwaitility(){
            int totalSize;
            Awaitility.await()
                    .atMost(Duration.ofSeconds(10))
                    .pollInterval(Duration.ofSeconds(2))
                    .until(()->{
                        restAresponse=
                                given().
                                        contentType(ContentType.JSON)
                                        .when()
                                        .get("https://reqres.in/api/users?delay=5")
                                        .then()
                                        .log().all()
                                        .extract().response();
                        return restAresponse.statusCode()==200;
                    });
                    JsonPath jsonPath = new JsonPath(restAresponse.asString());
                    totalSize=jsonPath.get("total");
                    return totalSize;
        }

//package APIActions;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.asynchttpclient.Dsl;
//import org.asynchttpclient.Response;
//
//import java.io.IOException;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//
//public class DelayedActions {
//
//    public static int getTotalSize() throws ExecutionException, InterruptedException {
//        Future<Response> responseFuture = Dsl.asyncHttpClient().prepareGet("https://reqres.in/api/users?delay=5").execute();
//        Response response = responseFuture.get();
//
//        int totalSize = 0;  // Initialize totalSize
//
//        if (response.getStatusCode() == 200) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            try {
//                UsersResponse usersResponse = objectMapper.readValue(response.getResponseBody(), UsersResponse.class);
//                totalSize = usersResponse.getTotal();
//                System.out.println("The total size is " + totalSize);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return totalSize;
//    }
//
//    public static void main(String[] args) {
//        try {
//            getTotalSize();
//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}

    //@Test
    //public void cloneTest() {
    //    List<Part> parts = new ArrayList<Part>();
    //    Part part1 = new Part(1);
    //    parts.add(part1);
    //    Part part2 = new Part(2);
    //    parts.add(part2);
    //    try {
    //        ObjectMapper objectMapper = new ObjectMapper();
    //        String jsonStr = objectMapper.writeValueAsString(parts);
    //
    //        List<Part> cloneParts = objectMapper.readValue(jsonStr, new TypeReference<ArrayList<Part>>() {});
    //    } catch (Exception e) {
    //        //fail("failed.");
    //        e.printStackTrace();
    //    }
    //

    //}

    }

