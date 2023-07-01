package view;

import model.Item;
import model.Slot;

import java.util.List;
import java.util.Map;

/**
 * The VendingMachineView class provides methods for displaying information related to a vending machine.
 */
public class VendingMachineView {

    /**
     * Displays the stock of the given vending machine. If the slot is not empty, it will display
     * the name, quantity, and the amount of calories. If all slots are empty, it will prompt that it
     * doesn't have any stocks.
     *
     * @param slots Slots of the vending machine.
     */
    public void displayStock(Slot[] slots) {
        boolean hasItem = false;
        System.out.println("Vending Machine Stocks:");
        // prompts vending machine item per slots
        for (int i = 0; i < slots.length; ++i) {
            // if the item in that slot exist and has an amount
            if (slots[i].getAmount() > 0) {
                Item currItem = slots[i].getItem();
                // Prompts slot and item info
                System.out.println("[" + (i + 1) + "] - " + currItem.getName() + " -> Qty: " +
                        slots[i].getAmount() +
                        " -> Calories: " + currItem.getCalories() + " -> Price: ₱" + currItem.getPrice());
                hasItem = true;
            }
        }

        // If there are no stocks in the vending machine
        if (!hasItem) {
            System.out.println("The Vending Machine currently doesn't have stocks");
        }
        System.out.println("\n\n");
    }

    /**
     * Displays all transactions that have occurred from the first to the last stock. It displays the name, quantity, and
     * total price of each item if the item log is not empty.
     *
     * @param itemLogs Transaction history of the vending machine.
     */
    public void displayTransactions(List<Map<Item, Integer>> itemLogs) {
        boolean hasTransaction = false;
        int i = 1;
        long allTotalPrice = 0;
        // loops through each transaction history
        for (Map<Item, Integer> itemLog : itemLogs) {
            // If the entry set of item log is not empty
            if (!itemLog.isEmpty()) {
                System.out.println("<----- Transactions on stock " + i + " ----->");
                hasTransaction = true;
                int totalPrice = 0;

                // prompts item transactions for the current stock history
                for (Map.Entry<Item, Integer> entry : itemLog.entrySet()) {
                    System.out.println(entry.getKey() + " -> Qty: " + entry.getValue() + " -> Price: " +
                            (entry.getValue() * entry.getKey().getPrice()));
                    totalPrice += entry.getValue() * entry.getKey().getPrice();
                }

                System.out.println("Total Price: " + totalPrice);
                allTotalPrice += totalPrice;
            } else {
                System.out.println("<----- There are no transactions happened during stock " + i + " ----->");
            }
            i++;
        }

        if (!hasTransaction) {
            System.out.println("There are currently no transactions");
        } else {
            System.out.println("Sum of total prices : " + allTotalPrice);
        }
        System.out.println("\n\n");
    }

    /**
     * Displays error(s) coming for the maintenance.
     * @param errors Error message.
     */
    public void displayError(String ...errors) {
        for (String error : errors) {
            System.out.printf("Vending Machine Error: {%s}\n", error);
        }
        System.out.println("\n\n");
    }
}
