package nextstep.subway.line.dto;

import lombok.Getter;

@Getter
public class LineRequest {
    private String name;
    private String color;
    private Long upStationId;
    private Long downStationId;
    private int distance;
    private int duration;
    private int extraCharge;
}
