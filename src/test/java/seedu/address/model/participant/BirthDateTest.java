package seedu.address.model.participant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.Test;

public class BirthDateTest {

    @Test
    public void getAgeTest() {
        LocalDate date = LocalDate.of(2000, 8, 4);
        BirthDate birthDate = BirthDate.of(2000, 8, 4);
        assertEquals(Period.between(date, LocalDate.now()).getYears(), birthDate.getAge());
    }

    @Test
    public void notSpecifiedBirthDateTest() {
        BirthDate birthDate = BirthDate.notSpecified();
        assertEquals("N/A", birthDate.toString());
    }

    @Test
    public void ofFactoryMethodStringRepresentationTest() {
        BirthDate birthDate = BirthDate.of(2020, 8, 4);
        assertEquals("2020-08-04", birthDate.toString());
    }

    @Test
    public void isPresentOrPastTest() {
        assertFalse(BirthDate.isPresentOrPast(LocalDate.MAX));

        assertFalse(BirthDate.isPresentOrPast(LocalDate.now().plusYears(20)));

        assertTrue(BirthDate.isPresentOrPast(LocalDate.now()));

        // for other use cases not strictly to participants
        // BirthDate is strictly what can be born now and in the past and not in the future only
        assertTrue(BirthDate.isPresentOrPast(LocalDate.now().minusYears(200)));

        assertTrue(BirthDate.isPresentOrPast(LocalDate.now().minusYears(50)));
    }
}
