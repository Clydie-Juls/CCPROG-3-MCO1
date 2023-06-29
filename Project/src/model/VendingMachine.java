package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The VendingMachine class represents a vending machine that contains slots with items.
 */
public class VendingMachine {
    private final Slot[] slots;
    private final Denomination DENOMINATION;
    private final Transactions TRANSACTIONS;

    /**
     * Constructs a VendingMachine object with default settings.
     */
    public VendingMachine() {
        this(8, 10);
    }

    /**
     * Constructs a VendingMachine object with the specified number of slots and item capacity.
     *
     * @param noOfSlots    the number of slots in the vending machine
     * @param itemCapacity the maximum capacity of each slot for holding items
     */
    public VendingMachine(int noOfSlots, int itemCapacity) {
        DENOMINATION = new Denomination();
        TRANSACTIONS = new Transactions();
        slots = new Slot[noOfSlots];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot(itemCapacity);
        }
    }

    /**
     * Constructs a VendingMachine object with the specified number of slots or capacity.
     *
     * @param no               the number of slots or capacity based on the value of isNoOfCapacity
     * @param isNoOfCapacity   determines whether the value of no represents the number of slots or the item capacity
     */
    public VendingMachine(int no, boolean isNoOfCapacity) {
        DENOMINATION = new Denomination();
        TRANSACTIONS = new Transactions();
        if (isNoOfCapacity) {
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

    public Item[] dispenseItem(LinkedHashMap<Integer, Integer> payment, int slotNo, int amount) {
        Slot selectedSlot = slots[slotNo];

        if (DENOMINATION.processPayment(payment, selectedSlot.getItem().getPrice() * amount)) {
            if (selectedSlot.getAmount() >= amount) {
                selectedSlot.setAmount(selectedSlot.getAmount() - amount);
                Item item = selectedSlot.getItem();

                Item[] dispensedItems = new Item[amount];

                for (int i = 0; i < amount; i++) {
                    dispensedItems[i] = new Item(item.getName(), item.getCalories(), item.getPrice());
                }

                return dispensedItems;
            }
        }

        return null;
    }





    /**
     * Retrieves the array of slots in the vending machine.
     *
     * @return the array of slots
     */
    public Slot[] getSlots() {
        return slots;
    }

    /**
     * Retrieves the denomination object representing the currency used in the vending machine.
     *
     * @return the denomination object
     */
    public Denomination getDenomination() {
        return DENOMINATION;
    }

    /**
     * Retrieves the transactions object representing the logs of item transactions.
     *
     * @return the transactions object
     */
    public Transactions getTransactions() {
        return TRANSACTIONS;
    }


}
