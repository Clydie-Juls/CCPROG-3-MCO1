package model;

public class Item {
    private final String NAME;
    private final int CALORIES;
    private int price;

    public Item(String name, int calories, int price) {
        this.NAME = name;
        this.CALORIES = calories;
        this.price = price;
    }

    public String getName() {
        return NAME;
    }

    public int getCalories() {
        return CALORIES;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price > 0) {
            this.price = price;
        }
    }
}
