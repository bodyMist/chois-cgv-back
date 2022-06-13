package choiscgvback.cgv.domain;

public enum SeatType {
    BASIC(0), COUPLE(2000), VIP(5000);
    private final int value;
    SeatType(int value){this.value = value;}

    public int getValue() {
        return value;
    }
}
