package model;

import java.util.*;

/**
 * The Transactions class represents a log of item transactions in the vending machine.
 */
public class Transactions {
    private final List<Map<Item, Integer>> ITEM_LOGS;

    /**
     * Constructs a Transactions object with an initial item log.
     */
    public Transactions() {
        this.ITEM_LOGS = new ArrayList<>();
        ITEM_LOGS.add(new HashMap<>());
    }

    //TODO: DO THIS!!!!!
    /**
     * Adds a transaction for the specified item and quantity to the current item log.
     *
     * @param item      the item involved in the transaction
     * @param quantity  the quantity of the item involved in the transaction
     */
    public void addTransactions(Item item, int quantity) {
        Item newItem = new Item(item.getName(), item.getPrice(), item.getCalories());
        ITEM_LOGS.get(ITEM_LOGS.size() - 1).put(newItem, quantity);
    }

    //TODO: DO THIS!!!!!
    /**
     * Creates a new item log for recording future transactions.
     */
    public void resetTransactions() {
        ITEM_LOGS.add(new LinkedHashMap<>());
    }

    /**
     * Retrieves the list of item logs representing the transaction history.
     *
     * @return the list of item logs
     */
    public List<Map<Item, Integer>> getItemLogs() {
        return ITEM_LOGS;
    }
}
