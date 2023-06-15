package state;

public enum VendingMachineCommands {
    BUY,
    STOCK,
    RESTOCK,
    CHANGE_ITEM_PRICE,
    COLLECT_MONEY,
    REPLENISH_MONEY;

    //TODO: DO THIS!!!!!
    public static VendingMachineCommands inputCommand(String input) {
        for (VendingMachineCommands value : VendingMachineCommands.values()) {
            if(value.toString().equalsIgnoreCase(input)) {
                return value;
            }
        }

        return null;
    }
}
