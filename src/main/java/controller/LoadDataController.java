package controller;

import config.PathConfig;
import java.util.List;
import model.Promotion;
import model.Promotions;
import util.FileUtil;
import util.LocalDateUtil;

public final class LoadDataController {
    public static void loadData() {
//        productsData();
        promotionsData();
    }

    public static void productsData() {
        List<String> fileContents = FileUtil.readFile(PathConfig.PRODUCTS_FILE_PATH.getFilePath());
        System.out.println(fileContents);
    }

    public static void promotionsData() {
        List<String> fileContents = FileUtil.readFile(PathConfig.PROMOTIONS_FILE_PATH.getFilePath());

        fileContents.stream()
                .map(LoadDataController::createPromotionFromContent)
                .filter(promotion -> Promotion.currentPromotion(promotion.startTime(), promotion.endTime()))
                .forEach(Promotions::add);
    }

    private static Promotion createPromotionFromContent(String content) {
        String[] splitContent = content.split(",");
        return new Promotion(
                splitContent[0],
                Integer.parseInt(splitContent[1]),
                Integer.parseInt(splitContent[2]),
                LocalDateUtil.parse(splitContent[3]),
                LocalDateUtil.parse(splitContent[4])
        );
    }
}
