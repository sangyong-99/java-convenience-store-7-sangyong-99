package constant;

public enum OutputConstant {
    PROMOTION_PRODUCT_STR_FORMAT("- %s %,d원 %s %s"),
    COMMON_PRODUCT_STR_FORMAT("- %s %,d원 %s"),
    NO_INVENTORY("재고 없음"),
    COUNT("개");

    private final String constant;

    OutputConstant(final String constant) {
        this.constant = constant;
    }

    public final String getConstant() {
        return this.constant;
    }
}
