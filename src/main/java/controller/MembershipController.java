package controller;

import java.util.Objects;
import model.Receipts;
import view.InputView;

public final class MembershipController {
    public static void membership() {
        String input = InputView.membershipDiscount();
        if (Objects.equals(input, "Y")){
            Receipts.isMembershipDiscount();
        }
    }
}
