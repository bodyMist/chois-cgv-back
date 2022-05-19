package choiscgvback.cgv.dto;

public class MorningDiscountPolicy implements FixDiscountPolicy{
    @Override
    public int discount(int price) {
        return price - discountAmount;
    }
}
