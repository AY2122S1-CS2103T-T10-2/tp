package seedu.address.model.participant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.AMY;
import static seedu.address.testutil.TypicalPersons.BOB;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.ParticipantBuilder;

public class ParticipantTest {

    @Test
    public void isSamePersonTest() {
        Participant aliceP = new ParticipantBuilder(ALICE).build();
        Participant bobP = new ParticipantBuilder(BOB).build();
        assertTrue(aliceP.isSamePerson(ALICE));
        assertFalse(aliceP.isSamePerson(bobP));
        assertFalse(aliceP.isSamePerson(BOB));
    }

    @Test
    public void withBirthDateTest() {
        Participant aliceP = new ParticipantBuilder(ALICE).withBirthDate(2000, 8, 4).build();
        Participant bobP = new ParticipantBuilder(BOB).build();
        assertEquals("2000-08-04", aliceP.getBirthDate().toString());
        assertEquals("N/A", bobP.getBirthDate().toString());
    }

    @Test
    public void addNoteTest() {
        Participant aliceP = new ParticipantBuilder(ALICE).withBirthDate(2000, 8, 4).build();
        assertTrue(aliceP.getNotes().isEmpty());
        aliceP.addNote(new Note("Alice has allergy to pollen", Note.Importance.HIGH));
        aliceP.addNote(new Note("Alice is vegetarian", Note.Importance.VERY_HIGH));
        assertFalse(aliceP.getNotes().isEmpty());
        ArrayList<String> expectedNotes = new ArrayList<>(List.of("Importance[HIGH] Alice has allergy to pollen",
                "Importance[VERY_HIGH] Alice is vegetarian"));
        assertTrue(aliceP.getNotes().stream().map(Object::toString).allMatch(expectedNotes::contains));
    }

    @Test
    public void removeNoteTest() {
        Participant aliceP = new ParticipantBuilder(ALICE).withBirthDate(2000, 8, 4).build();
        assertTrue(aliceP.getNotes().isEmpty());
        aliceP.addNote(new Note("Alice has allergy to pollen", Note.Importance.HIGH));
        aliceP.addNote(new Note("Alice is vegetarian", Note.Importance.VERY_HIGH));
        aliceP.removeNote(new Note("Alice has allergy to pollen", Note.Importance.HIGH));
        assertEquals("[Importance[VERY_HIGH] Alice is vegetarian]",
                aliceP.getNotes().toString());
    }

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Participant aliceP = new ParticipantBuilder(ALICE).withBirthDate(2000, 8, 4).build();
        assertThrows(UnsupportedOperationException.class, () -> aliceP.getTags().remove(0));
        assertThrows(UnsupportedOperationException.class, () -> aliceP.getNotes().remove(0));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Participant aliceP = new ParticipantBuilder(ALICE).withBirthDate(2000, 8, 4).build();

        Participant alicePCopy = new ParticipantBuilder(ALICE).withBirthDate(2000, 8, 4).build();

        Participant bobP = new ParticipantBuilder(BOB).build();

        assertTrue(aliceP.equals(alicePCopy));

        // same object -> returns true
        assertTrue(aliceP.equals(aliceP));

        // null -> returns false
        assertFalse(aliceP.equals(null));

        // different type -> returns false
        assertFalse(aliceP.equals(5));

        // different person -> returns false
        assertFalse(aliceP.equals(bobP));

        // different note -> returns false
        Person editedAlice = new ParticipantBuilder(aliceP).withNotes(Set.of(new Note("She is vegan",
                Note.Importance.VERY_HIGH))).build();
        assertFalse(aliceP.equals(editedAlice));

        // different nextOfKins -> returns false
        editedAlice = new ParticipantBuilder(aliceP).withNextOfKins(BOB, AMY).build();
        assertFalse(aliceP.equals(editedAlice));

    }
}
