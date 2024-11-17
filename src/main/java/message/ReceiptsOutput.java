package message;

public enum ReceiptsOutput {
    PURCHASE_MESSAGE("==============W 편의점================\n" + "상품명\t\t수량\t금액"),
    PURCHASE_FORMAT_MESSAGE("%s		%,d 	%,d"),
    GIFT_MESSAGE("=============증\t정==============="),
    GIFT_FORMAT_MESSAGE("%s		%,d"),
    SEPARATION("===================================="),
    TOTAL_PRICE("총구매액\t\t%,d\t%,d"),
    PROMOTION_TOTAL_PRICE("행사할인\t\t\t-%,d"),
    MEMBERSHIP_DISCOUNT_PRICE("멤버십할인\t\t\t-%,d"),
    SUBMIT_MONEY("내실돈\t\t\t %,d");

    private final String receiptsMessage;

    ReceiptsOutput(final String receiptsMessage) {
        this.receiptsMessage = receiptsMessage;
    }

    public final String getReceiptsMessage() {
        return receiptsMessage;
    }
}
