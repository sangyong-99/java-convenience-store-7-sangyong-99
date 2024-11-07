package controller;

import config.PathConfig;
import dto.ProductDTO;
import java.util.List;
import model.Promotions;
import util.FileUtil;
import util.SplitUtil;

public final class LoadDataController {
    public static void loadData() {
        promotionsData();
        productsData();
    }

    public static void productsData() {
        List<String> fileContents = FileUtil.readFile(PathConfig.PRODUCTS_FILE_PATH.getFilePath());
        for(String content: fileContents) {
            ProductDTO productDTO = SplitUtil.createProductDTOFromContent(content);
        }
    }

    public static void promotionsData() {
        List<String> fileContents = FileUtil.readFile(PathConfig.PROMOTIONS_FILE_PATH.getFilePath());
        fileContents.stream()
                .map(SplitUtil::createPromotionFromContent)
                // 처음 promotions.promotion에 현재 기간에 행사 진행하는 것만 넣을 건지 다 넣을 건지 filter
//                .filter(promotion -> Promotion.currentPromotion(promotion.startTime(), promotion.endTime()))
                .forEach(Promotions::add);
    }
}
