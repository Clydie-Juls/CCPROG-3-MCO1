package model;

/**
 * The MaintenanceService class represents a service for maintaining a vending machine.
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

    /**
     * Stocks the specified slot in the vending machine with a new item.
     *
     * @param amount    the quantity of items to stock in the slot
     * @param slotNo    the slot number to stock
     * @param itemName  the name of the item to be stocked
     * @param calories  the calories of the item to be stocked
     * @param price     the price of the item to be stocked
     * @return true if the stocking process is successful, false otherwise
     */
    public boolean stock(int amount, int slotNo, String itemName, int calories, int price) {
        if (slotNo - 1 >= 0 && slotNo - 1 < vendingMachine.getSlots().length || amount > 0 || !itemName.isEmpty() ||
                calories > 0 || price > 0) {
            Item newItem = new Item(itemName, calories, price);
            vendingMachine.getSlots()[slotNo - 1].setItem(newItem);
            vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
            return true;
        }
        return false;
    }

    /**
     * Restocks the specified slot in the vending machine with additional items.
     *
     * @param amount    the quantity of items to restock in the slot
     * @param slotNo    the slot number to restock
     * @return true if the restocking process is successful, false otherwise
     */
    public boolean restock(int amount, int slotNo) {
        if (slotNo - 1 >= 0 && slotNo - 1 < vendingMachine.getSlots().length || amount > 0) {
            vendingMachine.getSlots()[slotNo - 1].setAmount(amount);
            return true;
        }
        return false;
    }

    /**
     * Changes the price of the item in the specified slot of the vending machine.
     *
     * @param slotNo    the slot number to change the item price
     * @param price     the new price for the item
     * @return true if the price change is successful, false otherwise
     */
    public boolean changeItemPrice(int slotNo, int price) {
        if (slotNo - 1 >= 0 && slotNo - 1 < vendingMachine.getSlots().length || price > 0) {
            vendingMachine.getSlots()[slotNo - 1].getItem().setPrice(price);
            return true;
        }
        return false;
    }

    /**
     * Collects the money from the vending machine and adds it to the total money collected by the service.
     */
    public void collectMoney() {
        totalMoney += vendingMachine.getDenomination().passDenomination();
    }

    /**
     * Replenishes the denomination of the vending machine with the specified amount.
     *
     * @param amount    the amount to replenish the denomination
     * @return true if the replenishment process is successful, false otherwise
     */
    public boolean replenishDenomination(int amount) {
        if (amount > 0) {
            vendingMachine.getDenomination().getCurrency().replaceAll((k, v) -> v + amount);
            return true;
        }
        return false;
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
     * Sets the vending machine to be maintained by the service.
     *
     * @param vendingMachine the vending machine to be maintained
     */
    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
