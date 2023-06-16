package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

public class Transactions {

    private List<Map<Item, Integer>> itemLogs;

    public Transactions() {
        this.itemLogs = new ArrayList<>();

    }

    //TODO: DO THIS!!!!!
    public void addTransactions(Item item, int quantity) {
        Item newItem = new Item(item.getName(), item.getPrice(), item.getCalories());
        itemLogs.get(itemLogs.size()-1).put(newItem, quantity);
    }

    //TODO: DO THIS!!!!!
    public void resetTransactions() {
        itemLogs.add(new LinkedHashMap<>());
    }

    public List<Map<Item, Integer>> getItemLogs() {
        return itemLogs;
    }
}
