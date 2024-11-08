package util;

import exception.WrongInputException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Order;
import validation.InputValidation;

public final class RegexCheckerUtil {
    public static final String INPUT_ORDER_REGEX =  "^\\[(.+)-(\\d+)\\]$";

    public static Order orderRegexChecker(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(INPUT_ORDER_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            int purchaseCount = purchaseCountParse(matcher.group(2));
            return new Order(InputValidation.isNotBlank(matcher.group(1)), purchaseCount);
        } else {
            throw new WrongInputException();
        }
    }

    private static int purchaseCountParse(String count) throws IllegalArgumentException {
        int purchaseCount = Parse.parseInteger(count);
        if (purchaseCount <= 0) {
            throw new WrongInputException();
        }
        return purchaseCount;
    }
}