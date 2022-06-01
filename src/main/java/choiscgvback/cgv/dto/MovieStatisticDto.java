package choiscgvback.cgv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MovieStatisticDto {
    private final boolean memberSex;
    private final int ageGroup;
    private final int count;
}
