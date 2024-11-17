package util;

import exception.WrongFormatInputException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Order;
import validation.InputValidation;

public final class RegexCheckerUtil {
    private static final String INPUT_ORDER_REGEX = "^\\[([^\\[\\]-]+)-(.+)\\]$";

    public static Order orderRegexChecker(final String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(INPUT_ORDER_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            int purchaseCount = purchaseCountParse(matcher.group(2));
            return new Order(InputValidation.isNotBlank(matcher.group(1)), purchaseCount);
        }
        throw new WrongFormatInputException();
    }

    private static int purchaseCountParse(final String count) throws IllegalArgumentException {
        int purchaseCount = Parse.parseInteger(count);
        if (purchaseCount <= 0) {
            throw new WrongFormatInputException();
        }
        return purchaseCount;
    }
}
