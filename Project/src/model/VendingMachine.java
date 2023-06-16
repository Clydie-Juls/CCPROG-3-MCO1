package model;

import java.util.Map;

public class VendingMachine {
    private final Slot[] slots;
    private final Denomination denomination;
    private final Transactions transactions;

    public VendingMachine() {
        this(8, 10);
    }

    public VendingMachine(int no, boolean isNoOfCapacity) {
        denomination = new Denomination();
        transactions = new Transactions();
        if(isNoOfCapacity) {
            no = Math.max(8, no);
            slots = new Slot[no];
            for (int i = 0; i < slots.length; i++) {
                slots[i] = new Slot(10);
            }
        } else {
            no = Math.max(10, no);
            slots = new Slot[8];
            for (int i = 0; i < slots.length; i++) {
                slots[i] = new Slot(no);
            }
        }
    }

    public VendingMachine(int noOfSlots, int itemCapacity) {
        denomination = new Denomination();
        transactions = new Transactions();
        slots = new Slot[noOfSlots];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot(itemCapacity);
        }
    }

    public Slot[] getSlots() {
        return slots;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public Transactions getTransactions() {
        return transactions;
    }

}
