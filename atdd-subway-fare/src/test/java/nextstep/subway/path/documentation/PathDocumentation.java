package nextstep.subway.path.documentation;

import io.restassured.RestAssured;
import nextstep.subway.common.Documentation;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class PathDocumentation extends Documentation {

    @Test
    void path() {
        RestAssured
                .given().log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .queryParam("source", 1L)
                .queryParam("target", 2L)
                .when().get("/paths")
                .then().log().all().extract();
    }
}
