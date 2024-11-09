package message;

public enum IOMessage {
    INVENTORY_STATUS_MESSAGE("안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n"),
    ORDER_MESSAGE("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])"),
    PARTIAL_PROMOTION_MESSAGE("현재 %s %d개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)");

    private final String ioMessage;

    IOMessage(final String ioMessage) {
        this.ioMessage = ioMessage;
    }

    public String getMessage() {
        return ioMessage;
    }
}