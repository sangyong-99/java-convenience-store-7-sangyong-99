package message;

public enum ErrorMessage {
    LOAD_FILE_FAIL_MESSAGE("[ERROR] 파일을 제대로 읽어오지 못했습니다."),
    WRONG_INPUT("[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.");

    private final String errorMessage;

    ErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public final String getErrorMessage() {
        return errorMessage;
    }
}
