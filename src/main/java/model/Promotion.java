package model;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;

public record Promotion(String promotionName, int buy, int get, LocalDate startTime, LocalDate endTime) {
    public static boolean currentPromotion(LocalDate startTime, LocalDate endTime) {
        LocalDate now = DateTimes.now().toLocalDate();
        return !now.isBefore(startTime) && !now.isAfter(endTime);
    }
}