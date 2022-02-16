package nextstep.subway.path.documentation;

import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.restdocs.request.RequestParametersSnippet;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;

public class PathDocumentationUtils {

    private PathDocumentationUtils() {
    }

    public static RequestParametersSnippet getRequestParametersSnippet() {
        return requestParameters(
                parameterWithName("source").description("출발역 고유번호"),
                parameterWithName("target").description("도착역 고유번호"),
                parameterWithName("type").description("DISTANCE: 거리, DURATION: 시간")
        );
    }

    public static ResponseFieldsSnippet getResponseFieldsSnippet() {
        return responseFields(
                fieldWithPath("stations").description("최소 경로 역 목록"),
                fieldWithPath("stations[].id").description("역 고유번호"),
                fieldWithPath("stations[].name").description("역 이름"),
                fieldWithPath("stations[].createdDate").description("역 생성일자"),
                fieldWithPath("stations[].modifiedDate").description("역 최근 수정일자"),
                fieldWithPath("distance").description("전체 거리"),
                fieldWithPath("duration").description("소요 시간")
        );
    }
}
