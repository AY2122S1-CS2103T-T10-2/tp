package seedu.address.model.participant;

import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.Period;


/**
 * Represents a Participant's date of birth in the event.
 * Guarantees: immutable; is valid as declared in {@link #isValidBirthDate(LocalDate)}}
 */
public class BirthDate {

    public static final String MESSAGE_DATE_CONSTRAINTS = "Date of birth cannot be in the future or invalid";

    private final LocalDate date;


    private BirthDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Factory method for birthdate starting from dayOfMonth, then month, then year.
     *
     * @param dayOfMonth day of the month.
     * @param month      month from 1-12.
     * @param year       year to be this year or before, year in the future is invalid in this case.
     * @return Birthdate object with specified date.
     */
    public static BirthDate of(int year, int month, int dayOfMonth) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        checkArgument(isPresentOrPast(date), MESSAGE_DATE_CONSTRAINTS);
        return new BirthDate(date);
    }

    /**
     * Factory method for birthdate which might not have been initialised yet.
     *
     * @return Birthdate with "N/A" String representation.
     */
    public static BirthDate notSpecified() {
        return new BirthDate(null);
    }

    /**
     * Getter for date of this BirthDate.
     *
     * @return date of the BirthDate.
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Returns the age from the BirthDate.
     *
     * @return age
     */
    public int getAge() {
        return Period.between(this.date, LocalDate.now()).getYears();
    }

    /**
     * Returns true if a given LocalDate instance is in the past or present.
     * This is used to ensure no one's BirthDate is in the future.
     *
     * @param date     A LocalDate instance.
     * @return         A boolean representing if a date is in the past or present.
     */
    public static boolean isPresentOrPast(LocalDate date) {
        return (LocalDate.now().isEqual(date) || LocalDate.now().isAfter(date));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof BirthDate)) {
            return false;
        }

        BirthDate otherBirthDate = (BirthDate) other;
        if (this.getDate() == null || otherBirthDate.getDate() == null) {
            return this.getDate() == otherBirthDate.getDate();
        } else {
            return otherBirthDate.getDate().equals(getDate());
        }

    }

    @Override
    public String toString() {
        if (this.date == null) {
            return "N/A";
        }
        return date.toString();
    }
}
