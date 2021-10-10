package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.commons.core.Messages.MESSAGE_EVENT_NOT_FOUND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalParticipants.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventNamePredicate;
import seedu.address.model.event.UniqueEventList;
import seedu.address.testutil.DefaultModelStub;
import seedu.address.testutil.TypicalEvents;

/**
 * Contains integration tests (interaction with the Model) for {@code ShowEventDetailsCommand}.
 */
public class ShowEventDetailsCommandTest {

    private final Event sampleEvent = TypicalEvents.SAMPLE_EVENT_3;
    private final EventNamePredicate samplePredicate = preparePredicate(sampleEvent.getNameString());
    private final Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private final Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    public ShowEventDetailsCommandTest() {
        model.addEvent(sampleEvent);
        expectedModel.addEvent(sampleEvent);
    }

    @Test
    public void constructor_nullEvent_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ShowEventDetailsCommand(null));
    }

    @Test
    public void execute_eventNotInList_throwsCommandException() {
        EventNamePredicate predicate = preparePredicate(" ");
        ShowEventDetailsCommand command = new ShowEventDetailsCommand(predicate);
        assertThrows(CommandException.class, MESSAGE_EVENT_NOT_FOUND, () -> command.execute(model));
    }

    /**
     * Checks that the UI is unaffected by the use of a ShowEventDetailsCommand.
     *
     * @throws CommandException if model provided to ShowEventDetailsCommand execute method is invalid.
     */
    @Test
    public void execute_eventInList_noUiChangeSuccessful() throws CommandException {
        CommandResult commandResult = new ShowEventDetailsCommand(samplePredicate).execute(model);
        assertEquals(model.getFilteredEventList(), expectedModel.getFilteredEventList());
    }

    /**
     * Tests CommandResult output of ShowEventDetailsCommand.
     *
     * @throws CommandException if model provided to ShowEventDetailsCommand execute method is invalid.
     */
    @Test
    public void execute_eventInList_showDetailsSuccessful() throws CommandException {
        CommandResult commandResult = new ShowEventDetailsCommand(samplePredicate).execute(model);
        String expectedOutput = String.format("Event Name: %s\nEvent Date: %s\nEvent Time: %s\nCompletion Status: %s",
                sampleEvent.getNameString(),
                sampleEvent.getDateString(),
                sampleEvent.getTimeString(),
                sampleEvent.getIsDone() ? "Completed" : "Uncompleted"
                );
        assertEquals(commandResult.getFeedbackToUser(), expectedOutput);
    }

    /**
     * Tests CommandResult output of ShowEventDetailsCommand using a ModelStub.
     *
     * @throws CommandException if model provided to ShowEventDetailsCommand execute method is invalid.
     */
    @Test
    public void execute_eventInListUsingModelStub_showDetailsSuccessful() throws CommandException {
        ModelStubWithEvent modelStub = new ModelStubWithEvent(sampleEvent);
        CommandResult commandResult = new ShowEventDetailsCommand(samplePredicate).execute(modelStub);
        String expectedOutput = String.format("Event Name: %s\nEvent Date: %s\nEvent Time: %s\nCompletion Status: %s",
                sampleEvent.getNameString(),
                sampleEvent.getDateString(),
                sampleEvent.getTimeString(),
                sampleEvent.getIsDone() ? "Completed" : "Uncompleted"
        );
        assertEquals(commandResult.getFeedbackToUser(), expectedOutput);
    }

    /**
     * A Model stub that contains a single Event.
     */
    private static class ModelStubWithEvent extends DefaultModelStub {
        private final Event event;

        ModelStubWithEvent(Event event) {
            requireNonNull(event);
            this.event = event;
        }

        @Override
        public ObservableList<Event> getFilteredEventList() {
            UniqueEventList eventList = new UniqueEventList();
            eventList.add(event);
            return new FilteredList<>(eventList.asUnmodifiableObservableList());
        }
    }

    /**
     * Parses {@code userInput} into a {@code EventNamePredicate}.
     */
    private EventNamePredicate preparePredicate(String userInput) {
        return new EventNamePredicate(userInput.trim().replaceAll("\\s+", " "));
    }
}
