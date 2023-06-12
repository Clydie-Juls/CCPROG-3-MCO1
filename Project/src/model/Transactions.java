package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Transactions {
    private final Map<String, Integer> PREVIOUS_TRANSACTIONS;
    private final Map<String, Integer> TRANSACTIONS;

    public Transactions() {
        this.PREVIOUS_TRANSACTIONS = new LinkedHashMap<>();
        this.TRANSACTIONS = new LinkedHashMap<>();
    }

    //TODO: DO THIS!!!!!
    public void addTransactions() {

    }

    //TODO: DO THIS!!!!!
    public void resetTransactions() {

    }

    public Map<String, Integer> getPreviousTransactions() {
        return PREVIOUS_TRANSACTIONS;
    }

    public Map<String, Integer> getTransactions() {
        return TRANSACTIONS;
    }
}
