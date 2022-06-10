package choiscgvback.cgv.model;

public class BaseDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(int price) {
        return price;
    }
}
