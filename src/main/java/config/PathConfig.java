package config;

public enum PathConfig {
    PRODUCTS_FILE_PATH("src/main/resources/products.md"),
    PROMOTIONS_FILE_PATH("src/main/resources/promotions.md");

    private final String filePath;

    PathConfig(final String filePath) {
        this.filePath = filePath;
    }

    public final String getFilePath() {
        return this.filePath;
    }
}