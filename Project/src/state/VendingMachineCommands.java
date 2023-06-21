package state;

public enum VendingMachineCommands {
    BUY,
    STOCK,
    RESTOCK,
    CHANGE_ITEM_PRICE,
    COLLECT_MONEY,
    REPLENISH_MONEY,
    EXIT,
    VENDING_MACHINE_FEATURES,
    MAINTENANCE_FEATURES;

    //TODO: DO THIS!!!!!
    public static VendingMachineCommands inputCommand(String input) {
        for (int i = 0; i < VendingMachineCommands.values().length; i++) {
            Integer commandIndex;
            try {
                commandIndex = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                commandIndex = null;
            }
            if(VendingMachineCommands.values()[i].toString().equalsIgnoreCase(input) &&
            commandIndex != null && commandIndex == i) {
                return VendingMachineCommands.values()[i];
            }
        }
        return null;
    }
}
