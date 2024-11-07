package message;

public enum ErrorMessage {
    LOAD_FILE_FAIL_MESSAGE("[ERROR] 파일을 제대로 읽어오지 못했습니다.");

    private final String errorMessage;

    ErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public final String getErrorMessage() {
        return errorMessage;
    }
}
