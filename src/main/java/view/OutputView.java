package view;

import io.Output;
import message.IOMessage;
import model.Inventory;
import model.Receipts;

public class OutputView {
    public static void outputInventory() {
        Output.printlnMessage(IOMessage.INVENTORY_STATUS_MESSAGE.getMessage());
        Output.printlnMessage(Inventory.printInventory());
    }

    public static void outputErrorMessage(IllegalArgumentException error) {
        Output.printlnMessage(error.getMessage());
    }

    public static void outputReceipts() {
        Receipts.print();
    }
}
