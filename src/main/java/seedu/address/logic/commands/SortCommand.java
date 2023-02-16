package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Sorts all Person in the address book by name.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": sorts the list by name.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "List sorted.";

    @Override
    public CommandResult execute(Model model) {
        model.sortPerson();
        return new CommandResult(SHOWING_HELP_MESSAGE, false, false);
    }
}
