package model;

/**
 * The Item class represents an item in the vending machine.
 */
public class Item {
    private final String NAME;
    private final int CALORIES;
    private int price;

    /**
     * Constructs an Item object with the specified name, calories, and price.
     *
     * @param name     the name of the item
     * @param calories the number of calories in the item
     * @param price    the price of the item
     */
    public Item(String name, int calories, int price) {
        this.NAME = name;
        this.CALORIES = calories;
        this.price = price;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return NAME;
    }

    /**
     * Retrieves the number of calories in the item.
     *
     * @return the number of calories in the item
     */
    public int getCalories() {
        return CALORIES;
    }

    /**
     * Retrieves the price of the item.
     *
     * @return the price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the price of the item to be set
     */
    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        }
    }
}
