package view;

import model.Item;
import model.Slot;
import model.VendingMachine;

public class MaintenanceView {

    public void displayUnfilteredStock(VendingMachine vendingMachine) {
        boolean hasItem = false;
        System.out.println("Vending Machine Stocks:");
        for (int i = 0; i < vendingMachine.getSlots().length; ++i) {
            Item currItem = vendingMachine.getSlots()[i].getItem();
            if(currItem != null) {
                System.out.println("[" + (i + 1) + "] -" + currItem.getName() + " -> Qty: " +
                        vendingMachine.getSlots()[i].getAmount() +
                        " -> Calories: " + currItem.getCalories());
            } else {
                System.out.println("[" + (i + 1) + "] -" + "No item");
            }
            hasItem = true;
        }

        if (!hasItem) {
            System.out.println("The Vending Machine currently doesn't have stocks");
        }
    }

    public void displayError(String ...errors) {
        for (String error : errors) {
            System.out.printf("Error: {%s}\n", error);
        }
    }
}