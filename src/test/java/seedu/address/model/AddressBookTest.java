package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalEvents.SAMPLE_EVENT;
import static seedu.address.testutil.TypicalParticipants.ALEX;
import static seedu.address.testutil.TypicalParticipants.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.event.Event;
import seedu.address.model.event.exceptions.DuplicateEventException;
import seedu.address.model.participant.Participant;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.testutil.ParticipantBuilder;

public class AddressBookTest {

    private final AddressBook addressBook = new AddressBook();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), addressBook.getParticipantList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        AddressBook newData = getTypicalAddressBook();
        addressBook.resetData(newData);
        assertEquals(newData, addressBook);
    }

    @Test
    public void resetData_withDuplicatePersons_throwsDuplicatePersonException() {
        // Two persons with the same identity fields
        Participant editedAlex = new ParticipantBuilder(ALEX).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Participant> newParticipants = Arrays.asList(ALEX, editedAlex);
        AddressBookStub newData = new AddressBookStub(newParticipants);

        assertThrows(DuplicatePersonException.class, () -> addressBook.resetData(newData));
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.hasParticipant(null));
    }

    @Test
    public void hasPerson_personNotInAddressBook_returnsFalse() {
        assertFalse(addressBook.hasParticipant(ALEX));
    }

    @Test
    public void hasPerson_personInAddressBook_returnsTrue() {
        addressBook.addParticipant(ALEX);
        assertTrue(addressBook.hasParticipant(ALEX));
    }

    @Test
    public void hasPerson_personWithSameIdentityFieldsInAddressBook_returnsTrue() {
        addressBook.addParticipant(ALEX);
        Participant editedAlex = new ParticipantBuilder(ALEX).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(addressBook.hasParticipant(editedAlex));
    }

    @Test
    public void getPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> addressBook.getParticipantList().remove(0));
    }

    @Test
    public void hasEvent_nullEvent_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.hasEvent(null));
    }

    @Test
    public void hasEvent_eventNotInAddressBook_returnFalse() {
        assertFalse(addressBook.hasEvent(SAMPLE_EVENT));
    }

    @Test
    public void hasEvent_eventInAddressBook_returnsTrue() {
        addressBook.addEvent(SAMPLE_EVENT);
        assertTrue(addressBook.hasEvent(SAMPLE_EVENT));
    }

    @Test
    public void getEventList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> addressBook.getEventList().remove(0));
    }

    @Test
    public void removeEvent_eventInAddressBook_returnFalse() {
        addressBook.addEvent(SAMPLE_EVENT);
        assertTrue(addressBook.getEventList().contains(SAMPLE_EVENT));
        addressBook.removeEvent(SAMPLE_EVENT);
        assertFalse(addressBook.hasEvent(SAMPLE_EVENT));
    }

    @Test
    public void addEvent_eventNotInAddressBook_returnTrue() {
        addressBook.addEvent(SAMPLE_EVENT);
        assertTrue(addressBook.hasEvent(SAMPLE_EVENT));
    }

    @Test
    public void addEvent_eventInAddressBook_throwsDuplicateEventException() {
        addressBook.addEvent(SAMPLE_EVENT);
        assertThrows(DuplicateEventException.class, () -> addressBook.addEvent(SAMPLE_EVENT));
    }

    /**
     * A stub ReadOnlyAddressBook whose persons list can violate interface constraints.
     */
    private static class AddressBookStub implements ReadOnlyAddressBook {
        private final ObservableList<Participant> persons = FXCollections.observableArrayList();
        private final ObservableList<Event> events = FXCollections.observableArrayList();

        AddressBookStub(Collection<Participant> participants) {
            this.persons.setAll(participants);
        }

        @Override
        public ObservableList<Participant> getParticipantList() {
            return persons;
        }

        @Override
        public ObservableList<Event> getEventList() {
            return events;
        }
    }

}
