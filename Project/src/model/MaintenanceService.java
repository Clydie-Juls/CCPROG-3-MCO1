package model;

/**
 * The MaintenanceService class represents a service for maintaining and managing a vending machine.
 */
public class MaintenanceService {
    private int totalMoney;
    private VendingMachine vendingMachine;

    /**
     * Constructs a MaintenanceService object with the specified vending machine.
     *
     * @param vendingMachine the vending machine to be maintained
     */
    public MaintenanceService(VendingMachine vendingMachine) {
        totalMoney = 0;
        this.vendingMachine = vendingMachine;
    }

    //TODO: DO THIS!!!!!
    /**
     * Stocks the specified item in the specified slot of the vending machine.
     *
     * @param item       the item to be stocked
     * @param amount     the quantity of the item to be stocked
     * @param slotNo     the slot number where the item is to be stocked
     * @param itemName   the name of the item
     * @param calories   the calorie count of the item
     * @param price      the price of the item
     */
    public void stock(Item item, int amount, int slotNo,
                      String itemName, int calories, int price) {
        if (slotNo - 1 >= 0 && slotNo - 1 < vendingMachine.getSlots().length) {
            Item newItem = new Item(itemName, calories, price);
            vendingMachine.getSlots()[slotNo - 1].setItem(newItem);
            vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
        }
    }

    //TODO: DO THIS!!!!!
    /**
     * Restocks the specified amount of items in the specified slot of the vending machine.
     *
     * @param amount  the quantity of items to be restocked
     * @param slotNo  the slot number where the items are to be restocked
     */
    public void restock(int amount, int slotNo) {
        if (slotNo - 1 >= 0 && slotNo - 1 < vendingMachine.getSlots().length) {
            vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
        }
    }

    //TODO: DO THIS!!!!!
    /**
     * Changes the price of the item in the specified slot of the vending machine.
     *
     * @param slotNo  the slot number of the item to change the price
     * @param price   the new price of the item
     */
    public void changeItemPrice(int slotNo, int price) {
        if (slotNo - 1 >= 0 && slotNo - 1 < vendingMachine.getSlots().length) {
            vendingMachine.getSlots()[slotNo - 1].getItem().setPrice(price);
        }
    }

    //TODO: DO THIS!!!!!
    /**
     * Collects the money from the vending machine and adds it to the total money collected.
     */
    public void collectMoney() {
        totalMoney += vendingMachine.getDenomination().passDenomination();
    }

    //TODO: DO THIS!!!!!
    /**
     * Replenishes the denomination in the vending machine by the specified amount.
     *
     * @param amount  the amount by which to replenish the denomination
     */
    public void replenishDenomination(int amount) {
        vendingMachine.getDenomination().getCurrency().replaceAll((k, v) -> v + amount);
    }

    /**
     * Retrieves the total money collected by the maintenance service.
     *
     * @return the total money collected
     */
    public int getTotalMoney() {
        return totalMoney;
    }

    /**
     * Sets the vending machine for maintenance by the service.
     *
     * @param vendingMachine the vending machine to be maintained
     */
    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
