package choiscgvback.cgv.model;

public class CultureDayDiscountPolicy implements RateDiscountPolicy {
    @Override
    public int discount(int price) {
        return price * discountPercent / 100;
    }
}
