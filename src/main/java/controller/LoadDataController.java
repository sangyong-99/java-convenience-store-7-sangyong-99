package controller;

import config.PathConfig;
import java.util.List;
import model.Promotion;
import model.Promotions;
import util.FileUtil;
import util.SplitUtil;

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
                .map(SplitUtil::createPromotionFromContent)
                .filter(promotion -> Promotion.currentPromotion(promotion.startTime(), promotion.endTime()))
                .forEach(Promotions::add);
    }
}
