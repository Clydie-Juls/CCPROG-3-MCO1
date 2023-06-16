package model;

public class Slot {
    private final int CAPACITY;
    private Item item;
    private int amount;

    public Slot(int capacity) {
        this.CAPACITY = capacity;
    }

    public boolean sellItem(int amount) {

        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        }
        return false;
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
