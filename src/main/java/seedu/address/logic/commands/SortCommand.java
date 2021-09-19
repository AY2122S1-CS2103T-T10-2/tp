package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Sorts all persons in the address book by their names in alphabetical order.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all persons in the address book by "
            + "their names in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Persons sorted alphabetically!";

    @Override
    public CommandResult execute(Model model) {
        model.sortPersons();
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || other instanceof FindCommand; // instanceof handles nulls
    }
}
