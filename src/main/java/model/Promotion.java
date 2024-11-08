package model;

import java.time.LocalDate;
import util.LocalDateUtil;

public record Promotion(String promotionName, int buy, int get, LocalDate startTime, LocalDate endTime) {
    public static boolean currentPromotion(LocalDate startTime, LocalDate endTime) {
        return LocalDateUtil.isWithinPeriod(startTime, endTime);
    }
}