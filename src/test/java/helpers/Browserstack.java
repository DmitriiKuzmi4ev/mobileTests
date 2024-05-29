package helpers;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .spec(RestAssuredSpec.requestSpec())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}