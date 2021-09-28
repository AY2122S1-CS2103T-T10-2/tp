package seedu.address.logic.parser;

import seedu.address.logic.commands.ShowDetailsCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.EventNamePredicate;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class ShowDetailsCommandParser implements Parser<ShowDetailsCommand> {
    @Override
    public ShowDetailsCommand parse(String userInput) throws ParseException {
        String trimmedArg = userInput.trim().replaceAll("\\s+", " ");
        if (trimmedArg.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ShowDetailsCommand.MESSAGE_USAGE));
        }

        return new ShowDetailsCommand(new EventNamePredicate(trimmedArg));
    }
}
