package view;

import model.Item;
import model.Slot;
import model.VendingMachine;

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
     * @param vendingMachine the vending machine whose stocks will be displayed
     */
    public void displayStock(VendingMachine vendingMachine) {
        boolean hasItem = false;
        System.out.println("Vending Machine Stocks:");
        for (int i = 0; i < vendingMachine.getSlots().length; ++i) {
            if (vendingMachine.getSlots()[i].getAmount() > 0) {
                Item currItem = vendingMachine.getSlots()[i].getItem();
                System.out.println("[" + (i + 1) + "] -" + currItem.getName() + " -> Qty: " +
                        vendingMachine.getSlots()[i].getAmount() +
                        " -> Calories: " + currItem.getCalories());
                hasItem = true;
            }
        }

        if (!hasItem) {
            System.out.println("The Vending Machine currently doesn't have stocks");
        }
    }

    /**
     * Displays all transactions that have occurred from the first to the last stock. It displays the name, quantity, and
     * total price of each item if the item log is not empty.
     *
     * @param vendingMachine the vending machine whose transactions will be displayed
     */
    public void displayTransactions(VendingMachine vendingMachine) {
        boolean hasTransaction = false;
        int i = 1;
        for (Map<Item, Integer> itemLog : vendingMachine.getTransactions().getItemLogs()) {
            if (!itemLog.isEmpty()) {
                System.out.println("<----- Transactions on stock " + i + " ----->");
                hasTransaction = true;
                int totalPrice = 0;

                for (Map.Entry<Item, Integer> entry : itemLog.entrySet()) {
                    System.out.println(entry.getKey() + " -> Qty: " + entry.getValue() + " -> Price: " +
                            (entry.getValue() * entry.getKey().getPrice()));
                    totalPrice += entry.getValue() * entry.getKey().getPrice();
                }

                System.out.println("Total Price: " + totalPrice);
            } else {
                System.out.println("<----- There are no transactions happened during stock " + i + " ----->");
            }
            i++;
        }

        if (!hasTransaction) {
            System.out.println("There are currently no transactions");
        }
    }

    public void displayError(String ...errors) {
        for (String error : errors) {
            System.out.printf("Vending Machine Error: {%s}\n", error);
        }
    }
}
