package view;

import model.Inventory;

public class OutputView {
    public static void outputInventory() {
        System.out.println(Inventory.printInventory());
    }
}
