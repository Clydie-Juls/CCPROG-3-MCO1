package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Denomination {
    private final Map<Integer, Integer> CURRENCY;

    public Denomination() {
        CURRENCY = new LinkedHashMap<>();
        CURRENCY.put(1000, 0);
        CURRENCY.put(500, 0);
        CURRENCY.put(200, 0);
        CURRENCY.put(100, 0);
        CURRENCY.put(50, 0);
        CURRENCY.put(20, 0);
        CURRENCY.put(10, 0);
        CURRENCY.put(5, 0);
        CURRENCY.put(1, 0);
    }

    //TODO: DO THIS!!!!!
    public boolean processPayment(int amount) {
        return false;
    }
}
