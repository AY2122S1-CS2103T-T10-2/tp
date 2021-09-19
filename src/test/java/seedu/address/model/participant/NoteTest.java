package seedu.address.model.participant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class NoteTest {

    @Test
    public void noteStringRepresentationTest() {
        Note note = new Note("test1", Note.Importance.VERY_HIGH);
        assertEquals("Importance[VERY_HIGH] test1", note.toString());
    }

    @Test
    public void equalityTest() {
        assertEquals(new Note("test2", Note.Importance.VERY_HIGH), new Note("test2", Note.Importance.VERY_HIGH));
        assertNotEquals(new Note("test3", Note.Importance.VERY_HIGH), new Note("Test3", Note.Importance.VERY_HIGH));
        assertNotEquals(new Note("test4", Note.Importance.VERY_HIGH), new Note("test4", Note.Importance.HIGH));
    }
}
