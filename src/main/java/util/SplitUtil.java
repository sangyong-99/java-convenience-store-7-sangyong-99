package util;

import dto.ProductDTO;
import model.Promotion;
import model.Promotions;

public final class SplitUtil {
    public static final String COMMA = ",";
    public static Promotion createPromotionFromContent(final String content) {
        String[] splitContent = content.split(COMMA);
        return new Promotion(
                splitContent[0],
                Integer.parseInt(splitContent[1]),
                Integer.parseInt(splitContent[2]),
                LocalDateUtil.parse(splitContent[3]),
                LocalDateUtil.parse(splitContent[4])
        );
    }

    public static ProductDTO createProductDTOFromContent(final String content) {
        String[] splitContent = content.split(COMMA);
        return new ProductDTO(
                splitContent[0],
                Integer.parseInt(splitContent[1]),
                Integer.parseInt(splitContent[2]),
                Promotions.getPromotion(splitContent[3])
        );
    }
}
