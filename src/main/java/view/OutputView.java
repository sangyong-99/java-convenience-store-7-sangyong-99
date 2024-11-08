package view;

import io.Output;
import message.IOMessage;
import model.Inventory;

public class OutputView {
    public static void outputInventory() {
        Output.printlnMessage(IOMessage.INVENTORY_STATUS_MESSAGE.getMessage());
        Output.printlnMessage(Inventory.printInventory());
    }

    public static void outputErrorMessage(IllegalArgumentException error) {
        Output.printlnMessage(error.getMessage());
    }
}
