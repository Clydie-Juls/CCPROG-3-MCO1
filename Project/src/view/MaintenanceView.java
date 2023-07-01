package view;

import model.Item;
import model.Slot;

import java.util.Map;

/**
 * The MaintenanceView class acts as the display of the maintenance.
 */
public class MaintenanceView {

    /**
     * Displays the stock of the vending machine regardless if it has an item or not.
     * @param slots Slot number of the vending machine.
     */
    public void displayUnfilteredStock(Slot[] slots) {
        boolean hasItem = false;
        System.out.println("Vending Machine Stocks:");
        // loops through each vending machine slots
        for (int i = 0; i < slots.length; ++i) {
            Item currItem = slots[i].getItem();
            // if the current item exists
            if(currItem != null) {
                // Prompts item and slot information
                System.out.println("[" + (i + 1) + "] - " + currItem.getName() + " -> Qty: " +
                        slots[i].getAmount() +
                        " -> Calories: " + currItem.getCalories() + " -> Price: ₱" + currItem.getPrice());
            } else {
                System.out.println("[" + (i + 1) + "] - " + "No item");
            }
            hasItem = true;
        }

        // If there are no stocks in the vending machine
        if (!hasItem) {
            System.out.println("The Vending Machine currently doesn't have stocks");
        }

        System.out.println("\n\n");
    }

    /**
     * Displays the total amount of money the maintenance service has collected.
     * @param totalMoney Total money collected by the maintenance.
     */
    public void displayTotalMoneyCollected(int totalMoney) {
        System.out.println("Total Money Collected: ₱" + totalMoney);
        System.out.println("\n\n");
    }

    /**
     * Displays the vending machine's denomination.
     * @param currency The denomination's currency.
     */
    public void displayDenomination(Map<Integer, Integer> currency) {
        System.out.println("Denomination:");
        for (Map.Entry<Integer, Integer> entry : currency.entrySet()) {
            System.out.println("₱" + entry.getKey() + " -> Amt: " + entry.getValue());
        }
        System.out.println("\n\n");
    }

    /**
     * Displays error(s) coming for the maintenance.
     * @param errors Error message.
     */
    public void displayError(String ...errors) {
        for (String error : errors) {
            System.out.printf("Maintenance Error: {%s}\n", error);
        }
        System.out.println("\n\n");
    }
}