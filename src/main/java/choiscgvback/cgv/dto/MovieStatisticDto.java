package choiscgvback.cgv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MovieStatisticDto {
    private final Boolean memberSex;
    private final Integer ageGroup;
    private final Long count;

    @Override
    public String toString() {
        return "\n통계정보{" +
                "memberSex=" + memberSex +
                ", ageGroup=" + ageGroup +
                ", count=" + count +
                '}';
    }
}
