package view;

import model.Item;
import model.VendingMachine;

import java.util.Map;

public class MaintenanceView {

    public void displayUnfilteredStock(VendingMachine vendingMachine) {
        boolean hasItem = false;
        System.out.println("Vending Machine Stocks:");
        for (int i = 0; i < vendingMachine.getSlots().length; ++i) {
            Item currItem = vendingMachine.getSlots()[i].getItem();
            if(currItem != null) {
                System.out.println("[" + (i + 1) + "] - " + currItem.getName() + " -> Qty: " +
                        vendingMachine.getSlots()[i].getAmount() +
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

    public void displayDenomination(VendingMachine vendingMachine) {
        System.out.println("Denomination:");
        for (Map.Entry<Integer, Integer> entry : vendingMachine.getDenomination().getCurrency().entrySet()) {
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