package view;

import io.Output;
import java.util.List;
import message.IOMessage;
import model.Inventory;
import model.Purchase;

public class OutputView {
    public static void outputInventory() {
        Output.printlnMessage(IOMessage.INVENTORY_STATUS_MESSAGE.getMessage());
        Output.printlnMessage(Inventory.printInventory());
    }

    public static void outputErrorMessage(IllegalArgumentException error) {
        Output.printlnMessage(error.getMessage());
    }

    public static void outputReceipts(List<Purchase> receipts) {
        ReceiptsOutput printer = new ReceiptsOutput(receipts);
        printer.print();
    }
}
