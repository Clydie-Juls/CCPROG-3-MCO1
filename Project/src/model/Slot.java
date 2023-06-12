package model;

public class Slot {
    private final int CAPACITY;
    private Item item;
    private int amount;

    public Slot(int capacity) {
        this.CAPACITY = capacity;
    }

    //TODO: DO THIS!!!!!
    public boolean sellItem(int amount) {
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
}
