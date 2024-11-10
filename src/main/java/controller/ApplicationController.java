package controller;

import java.util.Objects;
import model.Orders;
import model.Receipts;
import view.InputView;
import view.OutputView;

public final class ApplicationController {
    public void run() {
        LoadDataController.loadData();
        do {
            runTurn();
        } while (!exitCheck());
    }

    public void runTurn() {
        clear();
        OutputView.outputInventory();
        OrderController.order();
        PurchaseController.purchaseExec();
        MembershipController.membership();
        OutputView.outputReceipts(Receipts.getPurchases());
    }

    public void clear() {
        Orders.clearOrders();
        Receipts.clear();
    }

    public boolean exitCheck() {
        String input = InputView.exitCheck();
        return Objects.equals(input, "N");
    }
}
