package utils;

public enum BalanceSummaryHeaders {

    DATE("Date"),
    CREDIT("Credit"),
    DEBIT("Debit"),
    BALANCE("Balance");

    private final String value;
    BalanceSummaryHeaders(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
