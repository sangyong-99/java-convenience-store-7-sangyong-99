package controller;

import config.PathConfig;
import java.util.List;
import util.FileUtil;

public final class LoadDataController {
    public static void loadData() {
        promotionsData();
        productsData();
    }

    public static void productsData() {
        List<String> fileContents = readData(PathConfig.PRODUCTS_FILE_PATH.getFilePath());
        System.out.println(fileContents);
    }

    public static void promotionsData() {
        List<String> fileContents = readData(PathConfig.PROMOTIONS_FILE_PATH.getFilePath());
        System.out.println(fileContents);
    }

    public static List<String> readData(final String filePath) {
        List<String> fileContents = FileUtil.readFile(filePath);
        return fileContents;
    }
}
