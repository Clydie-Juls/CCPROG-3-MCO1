package model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Denomination {
    private final Map<Integer, Integer> CURRENCY;

    /**
     * This constructor creates a new Denomination object. it defines an empty currency for each bill.
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
     * This method process payment by checking if there is a change and the machine's has enough amount of each bills to
     * pay back the user. If there is enough change, check if the machine's has enough amount of each bills to pay
     * back the user. If at least one failed, give the payment back to the user.
     * @param payment   Users payment.
     * @param totalPrice    Total price of the products.
     * @return  If the process is successful or not.
     */
    public boolean processPayment(Map<Integer, Integer> payment, int totalPrice) {
        int change = getTotalPayment(payment) - totalPrice;
        Map<Integer, Integer> paymentHolder = new LinkedHashMap<>(payment);
        Map<Integer, Integer>  currencyHolder = new LinkedHashMap<>(CURRENCY);
        int[] changeDenomination;

        if(change > 0) {
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

                if(changeToPass == 0) {
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
     *  This method transfers the users payment to the machine.
     * @param payment   Users payment.
     */
    private void transferPayment(Map<Integer, Integer> payment) {
        for (Map.Entry<Integer, Integer> entry : payment.entrySet()) {
            int entryAmount = CURRENCY.get(entry.getKey());
            CURRENCY.put(entry.getKey(), entryAmount + entry.getValue());
            payment.put(entry.getKey(), 0);
        }
    }

    /**
     * This method returns the total money and clears each denomination to 0.
     * @return Total money saved by the machine.
     */
    public int passDenomination() {
        int total = getTotalPayment(CURRENCY);
        CURRENCY.replaceAll((k, v) -> 0);
        return total;
    }

    /**
     * This method gets the total amount the user pays.
     * @param payment   Users payment.
     * @return  total amount the user pays.
     */
    private int getTotalPayment(Map<Integer, Integer> payment) {
        return payment.entrySet().stream().mapToInt(v -> v.getKey() * v.getValue()).sum();
    }

    /**
     * A getter for the machine's currency.
     * @return  The machine's currency.
     */
    public Map<Integer, Integer> getCurrency() {
        return CURRENCY;
    }
}
