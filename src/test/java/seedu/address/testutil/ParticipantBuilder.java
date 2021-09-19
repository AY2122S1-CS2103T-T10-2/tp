package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.participant.BirthDate;
import seedu.address.model.participant.Note;
import seedu.address.model.participant.Participant;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;


public class ParticipantBuilder {


    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final BirthDate DEFAULT_BIRTHDATE = BirthDate.of(2000, 8, 4);

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;
    private BirthDate birthDate;
    private Set<Note> notes;
    private ArrayList<Person> nextOfKins;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public ParticipantBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
        birthDate = DEFAULT_BIRTHDATE;
        notes = new HashSet<>();
        nextOfKins = new ArrayList<>();
    }

    /**
     * Initializes the ParticipantBuilder with the data of {@code personToCopy}.
     */
    public ParticipantBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        tags = new HashSet<>(personToCopy.getTags());
        birthDate = BirthDate.notSpecified();
        notes = new HashSet<>();
        nextOfKins = new ArrayList<>();
    }

    /**
     * Initializes the ParticipantBuilder with the data of {@code participantToCopy}.
     */
    public ParticipantBuilder(Participant participantToCopy) {
        name = participantToCopy.getName();
        phone = participantToCopy.getPhone();
        email = participantToCopy.getEmail();
        address = participantToCopy.getAddress();
        tags = new HashSet<>(participantToCopy.getTags());
        birthDate = participantToCopy.getBirthDate();
        notes = new HashSet<>(participantToCopy.getNotes());
        nextOfKins = new ArrayList<>(participantToCopy.getNextOfKins());
    }

    /**
     * Sets the {@code Name} of the {@code Participant} that we are building.
     */
    public ParticipantBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Participant} that we are building.
     */
    public ParticipantBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Participant} that we are building.
     */
    public ParticipantBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Participant} that we are building.
     */
    public ParticipantBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code birthDate} of the {@code Participant} that we are building.
     */
    public ParticipantBuilder withBirthDate(BirthDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the {@code birthDate} of the {@code Participant} that we are building.
     */
    public ParticipantBuilder withBirthDate(int year, int month, int dayOfMonth) {
        this.birthDate = BirthDate.of(year, month, dayOfMonth);
        return this;
    }

    /**
     * Sets the {@code notes} of the {@code Participant} that we are building.
     */
    public ParticipantBuilder withNotes(Set<Note> notes) {
        this.notes = notes;
        return this;
    }

    /**
     * Sets the {@code notes} of the {@code Participant} that we are building.
     */
    public ParticipantBuilder withNotes(Note... notes) {
        this.notes = SampleDataUtil.getNoteSet(notes);
        return this;
    }


    /**
     * Sets the {@code nextOfKins} of the {@code Participant} that we are building.
     */
    public ParticipantBuilder withNextOfKins(Person... nextOfKins) {
        this.nextOfKins = new ArrayList<>(Arrays.stream(nextOfKins).collect(Collectors.toList()));
        return this;
    }


    public Participant build() {
        return new Participant(name, phone, email, address, tags, birthDate, notes, nextOfKins);
    }

}
