package controller;

import model.Receipts;
import view.OutputView;

public final class ApplicationController {
    public void run() {
        LoadDataController.loadData();
        while(true) {
            OutputView.outputInventory();
            OrderController.order();
            PurchaseController.purchaseExec();
            Receipts.print();
        }

    }
}
