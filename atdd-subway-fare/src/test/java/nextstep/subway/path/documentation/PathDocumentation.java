package nextstep.subway.path.documentation;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import nextstep.subway.common.Documentation;
import nextstep.subway.common.DocumentationUtils;
import nextstep.subway.path.acceptance.PathUtils;
import nextstep.subway.path.application.PathService;
import nextstep.subway.path.domain.PathType;
import nextstep.subway.path.dto.PathResponse;
import nextstep.subway.station.dto.StationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static nextstep.subway.common.DocumentationUtils.given;
import static nextstep.subway.path.acceptance.PathUtils.경로_조회_성공;
import static nextstep.subway.path.acceptance.PathUtils.두_역의_경로_조회를_요청;
import static nextstep.subway.path.documentation.PathDocumentationUtils.getRequestParametersSnippet;
import static nextstep.subway.path.documentation.PathDocumentationUtils.getResponseFieldsSnippet;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class PathDocumentation extends Documentation {
    @MockBean
    PathService pathService;

    @ParameterizedTest(name = "두 역의 최소 경로를 조회한다. [{arguments}]")
    @EnumSource(PathType.class)
    void path(PathType type) {
        // given
        PathResponse pathResponse = new PathResponse(
                Arrays.asList(
                        new StationResponse(1L, "강남역", LocalDateTime.now(), LocalDateTime.now()),
                        new StationResponse(2L, "역삼역", LocalDateTime.now(), LocalDateTime.now()),
                        new StationResponse(3L, "선릉역", LocalDateTime.now(), LocalDateTime.now())
                ),
                5,5
        );

        when(pathService.findPath(anyLong(), anyLong(), any())).thenReturn(pathResponse);

        RequestSpecification requestSpecification =
                given(spec, "path", getRequestParametersSnippet(), getResponseFieldsSnippet());

        Map<String, Object> paramas = new HashMap<>();
        paramas.put("source", 1L);
        paramas.put("target", 3L);
        paramas.put("type", type.name());

        // when
        ExtractableResponse<Response> 조회_응답 = 두_역의_경로_조회를_요청(requestSpecification, paramas);

        // then
        경로_조회_성공(조회_응답, Arrays.asList(1L, 2L, 3L));
    }

}
