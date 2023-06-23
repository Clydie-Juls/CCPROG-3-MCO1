package model;

/**
 * The Slot class represents a slot in the vending machine that holds an item.
 */
public class Slot {
    private final int CAPACITY;
    private Item item;
    private int amount;

    /**
     * Constructs a Slot object with the specified capacity.
     *
     * @param capacity the maximum capacity of the slot for holding items
     */
    public Slot(int capacity) {
        this.CAPACITY = capacity;
    }

    /**
     * Sells the specified amount of items from the slot.
     *
     * @param amount the quantity of items to be sold
     * @return true if the items were successfully sold, false otherwise
     */
    public boolean sellItem(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        }
        return false;
    }

    /**
     * Retrieves the capacity of the slot for holding items.
     *
     * @return the capacity of the slot
     */
    public int getCapacity() {
        return CAPACITY;
    }

    /**
     * Retrieves the item held in the slot.
     *
     * @return the item held in the slot
     */
    public Item getItem() {
        return item;
    }

    /**
     * Retrieves the current amount of items in the slot.
     *
     * @return the amount of items in the slot
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the item to be held in the slot.
     *
     * @param item the item to be set in the slot
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Sets the amount of items in the slot.
     *
     * @param amount the amount of items to be set in the slot
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
