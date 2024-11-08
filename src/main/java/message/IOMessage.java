package message;

public enum IOMessage {
    INVENTORY_STATUS_MESSAGE("안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n");

    private final String ioMessage;

    IOMessage(final String ioMessage) {
        this.ioMessage = ioMessage;
    }

    public String getMessage() {
        return ioMessage;
    }
}