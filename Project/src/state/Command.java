package state;

/**
 * The Command enum represents the available commands in the vending machine system.
 */
public enum Command {
    /**
     * The Buy Command for the user
     */
    BUY,
    /**
     * The Stock Command for maintenance
     */
    STOCK,
    /**
     * The Restocking Command to refill item amounts
     */
    RESTOCK,
    /**
     * The Change item price command for the maintenance
     */
    CHANGE_ITEM_PRICE,
    /**
     * The collect money command for the maintenance
     */
    COLLECT_MONEY,

    /**
     * The collect refill denomination for the maintenance to refill denomination by a given amount
     */
    REPLENISH_DENOMINATION,
    /**
     * The exit command to exit a navigation
     */
    EXIT,
    /**
     * The vending machine features command to go to all vending machine feature
     */
    VENDING_MACHINE_FEATURES,
    /**
     * The vending machine features command to go to all vending machine feature
     */
    DISPLAY_TRANSACTIONS,
    /**
     * The show total money collected command for the maintenance to see the total money collected
     */
    SHOW_TOTAL_MONEY_COLLECTED,
    /**
     * The maintenance features command to go to all maintenance feature
     */
    MAINTENANCE_FEATURES;

    /**
     * Parses the input string and returns the corresponding Command enum value.
     *
     * @param input The input string representing a command.
     * @return The Command enum value corresponding to the input string, or null if no match is found.
     */
    public static Command inputCommand(String input) {
        for (Command command : Command.values()) {
            /* removes the leading and trailing white spaces, replaces white spaces between words to "_" and
            *  compare to the current command name in an unrestricted manner  */
            if (command.toString().equalsIgnoreCase(input.trim().replaceAll("\\s+", "_"))) {
                return command;
            }
        }
        return null;
    }
}
