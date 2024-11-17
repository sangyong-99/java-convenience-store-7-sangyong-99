package controller;

import java.util.Objects;
import model.Membership;
import model.Receipts;
import view.InputView;

public final class MembershipController {
    public static final int MAX_LIMIT = 8000;

    public static void membership() {
        String input = InputView.membershipDiscount();
        if (Objects.equals(input, "Y")){
            Membership.setMembershipDiscount(membershipCalculate());
            return;
        }
        Membership.setMembershipDiscount(0);
    }

    public static int membershipCalculate() {
        int discountPrice = (Receipts.membershipDiscountEligiblePrice() * 30) / 100;
        return Math.min(discountPrice, MAX_LIMIT);
    }
}
