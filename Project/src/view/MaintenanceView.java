package view;

import model.Item;
import model.Slot;
import model.VendingMachine;

import java.util.Map;

public class MaintenanceView {

    public void displayUnfilteredStock(Slot[] slots) {
        boolean hasItem = false;
        System.out.println("Vending Machine Stocks:");
        for (int i = 0; i < slots.length; ++i) {
            Item currItem = slots[i].getItem();
            if(currItem != null) {
                System.out.println("[" + (i + 1) + "] - " + currItem.getName() + " -> Qty: " +
                        slots[i].getAmount() +
                        " -> Calories: " + currItem.getCalories() + " -> Price: ₱" + currItem.getPrice());
            } else {
                System.out.println("[" + (i + 1) + "] - " + "No item");
            }
            hasItem = true;
        }

        if (!hasItem) {
            System.out.println("The Vending Machine currently doesn't have stocks");
        }

        System.out.println("\n\n");
    }

    public void displayTotalMoneyCollected(int totalMoney) {
        System.out.println("Total Money Collected: ₱" + totalMoney);
        System.out.println("\n\n");
    }

    public void displayDenomination(Map<Integer, Integer> currency) {
        System.out.println("Denomination:");
        for (Map.Entry<Integer, Integer> entry : currency.entrySet()) {
            System.out.println("₱" + entry.getKey() + " -> Amt: " + entry.getValue());
        }
        System.out.println("\n\n");
    }

    public void displayError(String ...errors) {
        for (String error : errors) {
            System.out.printf("Maintenance Error: {%s}\n", error);
        }
        System.out.println("\n\n");
    }
}