package model;

import java.util.*;

public class Transactions {

    private final List<Map<Item, Integer>> ITEM_LOGS;

    public Transactions() {
        this.ITEM_LOGS = new ArrayList<>();
        ITEM_LOGS.add(new HashMap<>());
    }

    //TODO: DO THIS!!!!!
    public void addTransactions(Item item, int quantity) {
        Item newItem = new Item(item.getName(), item.getPrice(), item.getCalories());
        ITEM_LOGS.get(ITEM_LOGS.size()-1).put(newItem, quantity);
    }

    //TODO: DO THIS!!!!!
    public void resetTransactions() {
        ITEM_LOGS.add(new LinkedHashMap<>());
    }

    public List<Map<Item, Integer>> getItemLogs() {
        return ITEM_LOGS;
    }
}
