package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;

import java.util.ArrayList;
import java.util.stream.Stream;

import seedu.address.logic.commands.FilterEventCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.EventDateTimePredicate;

public class FilterEventCommandParser implements Parser<FilterEventCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FilterEventCommand
     * and returns a FilterCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public FilterEventCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argMultiMap =
                ArgumentTokenizer.tokenize(userInput, PREFIX_DATE, PREFIX_TIME);
        if (!arePrefixesPresent(argMultiMap, PREFIX_DATE) || !argMultiMap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterEventCommand.MESSAGE_USAGE));
        }
        String eventDate = ParserUtil.parseEventDate(argMultiMap.getValue(PREFIX_DATE));
        String eventTime = ParserUtil.parseEventTime(argMultiMap.getValue(PREFIX_TIME));
        ArrayList<String> eventDateTime = new ArrayList<>();
        if (eventDate != null) {
            eventDateTime.add(eventDate);
        }
        if (eventTime != null) {
            eventDateTime.add(eventTime);
        }
        EventDateTimePredicate predicate = new EventDateTimePredicate(eventDateTime);
        return new FilterEventCommand(predicate);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
