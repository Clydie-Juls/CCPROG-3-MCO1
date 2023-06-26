package model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Denomination class represents the currency denominations used in the vending machine.
 */
public class Denomination {
    private final Map<Integer, Integer> CURRENCY;

    /**
     * Constructs a Denomination object with empty currency for each bill.
     */
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

    /**
     * Processes the payment by checking if there is enough change and if the vending machine has enough bills to
     * provide the change. If there is enough change, the payment is transferred and the denominations are updated.
     *
     * @param payment     the user's payment
     * @param totalPrice  the total price of the products
     * @return true if the payment process is successful, false otherwise
     */
    public boolean processPayment(Map<Integer, Integer> payment, int totalPrice) {
        int change = getTotalPayment(payment) - totalPrice;
        Map<Integer, Integer> paymentHolder = new LinkedHashMap<>(payment);
        Map<Integer, Integer> currencyHolder = new LinkedHashMap<>(CURRENCY);
        int[] changeDenomination;

        if (change > 0) {
            transferPayment(payment);
            changeDenomination = new int[CURRENCY.size()];
            int changeToPass = change;
            System.out.println(changeToPass);
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : CURRENCY.entrySet()) {
                for (int j = 0; j < entry.getValue() && changeToPass - entry.getKey() >= 0
                        && entry.getValue() > changeDenomination[i]; j++) {
                    changeDenomination[i]++;
                    changeToPass -= entry.getKey();
                    System.out.println(Arrays.toString(changeDenomination) + "|" + changeToPass);
                }
                i++;

                if (changeToPass == 0) {
                    i = 0;
                    for (Map.Entry<Integer, Integer> entry2 : CURRENCY.entrySet()) {
                        int newNo = entry2.getValue() - changeDenomination[i];
                        CURRENCY.put(entry2.getKey(), newNo);
                        payment.put(entry2.getKey(), changeDenomination[i]);
                        i++;
                    }
                    return true;
                }
            }
        }

        payment.putAll(paymentHolder);
        CURRENCY.putAll(currencyHolder);
        return false;
    }

    /**
     * Transfers the user's payment to the vending machine.
     *
     * @param payment the user's payment
     */
    private void transferPayment(Map<Integer, Integer> payment) {
        for (Map.Entry<Integer, Integer> entry : payment.entrySet()) {
            int entryAmount = CURRENCY.get(entry.getKey());
            CURRENCY.put(entry.getKey(), entryAmount + entry.getValue());
            payment.put(entry.getKey(), 0);
        }
    }

    /**
     * Returns the total amount of money in the vending machine and clears each denomination to 0.
     *
     * @return the total amount of money in the vending machine
     */
    public int passDenomination() {
        int total = getTotalPayment(CURRENCY);
        CURRENCY.replaceAll((k, v) -> 0);
        return total;
    }

    /**
     * Gets the total amount of money in the payment.
     *
     * @param payment the user's payment
     * @return the total amount of money in the payment
     */
    private int getTotalPayment(Map<Integer, Integer> payment) {
        return payment.entrySet().stream().mapToInt(v -> v.getKey() * v.getValue()).sum();
    }

    /**
     * Retrieves the currency denominations in the vending machine.
     *
     * @return the currency denominations
     */
    public Map<Integer, Integer> getCurrency() {
        return CURRENCY;
    }
}
