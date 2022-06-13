package choiscgvback.cgv.model;

import org.hibernate.validator.constraints.Range;

public interface FixDiscountPolicy extends DiscountPolicy {
    @Range(min = 0,max = 5000) int discountAmount = 1000;
}
