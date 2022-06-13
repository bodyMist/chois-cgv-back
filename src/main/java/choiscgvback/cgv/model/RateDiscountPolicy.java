package choiscgvback.cgv.model;

import choiscgvback.cgv.model.DiscountPolicy;
import org.hibernate.validator.constraints.Range;

public interface RateDiscountPolicy extends DiscountPolicy {
    @Range(min = 0, max = 100)
    int discountPercent = 10;
}
