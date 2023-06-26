package view;

import model.Item;
import model.Slot;
import model.VendingMachine;

import java.util.Map;

public class VendingMachinePrinter {

    /**
     * Displays the stock of the given vending machine. If the slot is not empty, it will display
     * the name, quantity, and the amount of calories. If all slots are empty, it will prompt that it
     * doesn't have any stocks.
     * @param vendingMachine    Machine whose stocks will be prompted.
     */
    public static void displayStock(VendingMachine vendingMachine) {
        boolean hasItem = false;
        System.out.println("Vending Machine Stocks:");
        for (Slot slot : vendingMachine.getSlots()) {
            if (slot.getAmount() > 0) {
                Item currItem = slot.getItem();
                System.out.println(currItem.getName() + " -> Qty: " + slot.getAmount() +
                        "-> Calories: " + currItem.getName());
                hasItem = true;
            }
        }

        if(!hasItem) {
            System.out.println("The Vending Machine currently doesn't have stocks");
        }
    }

    /**
     * Displays all transactions happened from first to last stocks. Displays the name, quantity, and
     * total price of each item if item log is not empty.
     * @param vendingMachine    Machine whose transactions will be prompted.
     */
    public static void displayTransactions(VendingMachine vendingMachine) {
        boolean hasTransaction = false;
        int i = 1;
        for (Map<Item, Integer> itemLog : vendingMachine.getTransactions().getItemLogs()) {
            if(!itemLog.isEmpty()) {
                System.out.println("<-----Transactions on stock " + i + " ----->");
                hasTransaction = true;
                int totalPrice = 0;

                for (Map.Entry<Item, Integer> entry : itemLog.entrySet()) {
                    System.out.println(entry.getKey() + "-> Qty: " + entry.getValue() + "-> Price: " +
                            (entry.getValue() * entry.getKey().getPrice()));
                    totalPrice += entry.getValue();
                }

                System.out.println("Total Price: " + totalPrice);
            } else {
                System.out.println("<-----There are no transactions happened during stock " + i + "----->");
            }
            i++;
        }

        if(!hasTransaction) {
            System.out.println("There are currently no Transactions");
        }
    }
}
