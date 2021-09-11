package seedu.address.model.particpant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;



/**
 * Represents a Participant in an event
 * Guarantees: name, phone, email, address, tags are present and not null, field values are validated, immutable.
 * Non-guarantees: birthDate - to be added with builder chaining method
 */
public class Participant extends Person {

    private BirthDate birthDate = BirthDate.notSpecified();
    private Set<Note> notes = new HashSet<>();
    private ArrayList<Person> nextOfKins = new ArrayList<>();


    /**
     * Every field must be present and not null.
     *
     * @param name    Name object of the person
     * @param phone   Phone object of the person
     * @param email   Email object of the person
     * @param address Address object of the person
     * @param tags    tags of the person
     */
    public Participant(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        super(name, phone, email, address, tags);
    }

    /**
     * Builder chaining method for retuning participant object with certain birthdate.
     * This is to allow the use of Person template along with Person but adding extension fields.
     * i.e. new Participant(name, phone, email, address, tags).withBirthDate(year, month, dayOfMonth)
     *
     * @param year       this year or before
     * @param month      month of the year specified
     * @param dayOfMonth day of the month specified
     * @return another Participant with same particulars object but with birth date
     */
    public Participant withBirthDate(int year, int month, int dayOfMonth) {
        Participant participantToReturn = new Participant(getName(), getPhone(), getEmail(), getAddress(), getTags());
        participantToReturn.nextOfKins = nextOfKins;
        participantToReturn.notes = notes;
        // set birth Date
        participantToReturn.birthDate = BirthDate.of(year, month, dayOfMonth);

        return participantToReturn;
    }

    /**
     * Builder chaining method for retuning participant object with certain birthdate.
     * i.e. new Participant(name, phone, email, address, tags).withBirthDate(year, month, dayOfMonth).withNotes(notes)
     * This chaining method is not required unless the participants were to be set with certain notes set
     *
     * @param notes set of Note object
     * @return this Participant but with new notes
     */
    public Participant withNotes(Set<Note> notes) {
        Participant participantToReturn = new Participant(getName(), getPhone(), getEmail(), getAddress(), getTags());
        participantToReturn.nextOfKins = nextOfKins;
        participantToReturn.birthDate = birthDate;

        // set notes
        participantToReturn.notes = notes;

        return participantToReturn;
    }


    /**
     * Builder chaining method for retuning participant object with certain birthdate.
     * i.e. new Participant(name, phone, email, address, tags).withBirthDate(year, month, dayOfMonth).withNotes(notes)
     * This chaining method is not required unless the participants were to be set with certain next of kins arrayList
     *
     * @param nextOfKins array list of next of kins
     * @return this Participant but with new nextOfKins
     */
    public Participant withNextOfKins(ArrayList<Person> nextOfKins) {
        Participant participantToReturn = new Participant(getName(), getPhone(), getEmail(), getAddress(), getTags());
        participantToReturn.notes = notes;
        participantToReturn.birthDate = birthDate;

        // set next of kins
        participantToReturn.nextOfKins = nextOfKins;

        return participantToReturn;
    }

    /**
     * @return this object's birthDate
     */
    public BirthDate getBirthDate() {
        return this.birthDate;
    }

    /**
     * @return this object's nextOfKins
     */
    public ArrayList<Person> getNextOfKins() {
        return this.nextOfKins;
    }


    /**
     * Add note to set of notes
     *
     * @param note note to be added
     */
    public void addNote(Note note) {
        this.notes.add(note);
    }

    /**
     * Remove note from set
     *
     * @param note note to be removed
     */
    public void removeNote(Note note) {
        this.notes.remove(note);
    }

    public Set<Note> getNotes() {
        return Collections.unmodifiableSet(notes);
    }

    /**
     * Returns true if both participants have the same name.
     * This defines a weaker notion of equality between two persons.
     * This allow Participant to both pass in Person and Participant objects.
     */
    public boolean isSamePerson(Participant otherParticipant) {
        if (otherParticipant == this) {
            return true;
        }

        return otherParticipant != null
                && otherParticipant.getName().equals(getName());
    }

    /**
     * Returns true if both participants have the same identity and data fields.
     * This defines a stronger notion of equality between two participants.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Participant)) {
            return false;
        }

        Participant otherParticipant = (Participant) other;
        return otherParticipant.getName().equals(getName())
                && otherParticipant.getPhone().equals(getPhone())
                && otherParticipant.getEmail().equals(getEmail())
                && otherParticipant.getAddress().equals(getAddress())
                && otherParticipant.getTags().equals(getTags())
                && otherParticipant.getBirthDate().equals(getBirthDate())
                && otherParticipant.getNotes().equals(getNotes())
                && otherParticipant.getNextOfKins().equals(getNextOfKins());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(this.getName(), this.getPhone(), this.getEmail(), this.getAddress(), this.getTags(),
                this.birthDate, this.notes, this.nextOfKins);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Address: ")
                .append(getAddress());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }

        if (!nextOfKins.isEmpty()) {
            builder.append("; NOK: ");
            nextOfKins.forEach(builder::append);
        }
        if (!notes.isEmpty()) {
            builder.append("; Notes: ");
            notes.forEach(builder::append);
        }

        return builder.toString();
    }
}
