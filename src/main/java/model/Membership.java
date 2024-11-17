package model;

public final class Membership {
    private static int membershipDiscount = 0;

    private Membership() {
    }

    public static void setMembershipDiscount(int membershipDiscount) {
        Membership.membershipDiscount = membershipDiscount;
    }

    public static int getMembershipDiscount() {
        return membershipDiscount;
    }
}
