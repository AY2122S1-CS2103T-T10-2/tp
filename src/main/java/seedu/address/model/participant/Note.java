package seedu.address.model.participant;

import static java.util.Objects.requireNonNull;

import java.util.Objects;


/**
 * Represents a note with different level of importance.
 * Unlike tags, the aim of the note is for the client/event organizer to be able to add and remove the note.
 */
public class Note {

    /** Importance of the note */
    public enum Importance {
        VERY_HIGH, HIGH, MEDIUM, LOW, VERY_LOW
    }

    private final String content;
    private final Importance importance;

    /**
     * Constructor for note.
     *
     * @param content    content of the note.
     * @param importance importance of the note.
     */
    public Note(String content, Importance importance) {
        requireNonNull(content);
        this.content = content;
        this.importance = importance;
    }

    /**
     * Getter for content.
     *
     * @return content of this note.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Getter for importance.
     *
     * @return importance of this note.
     */
    public Importance getImportance() {
        return this.importance;
    }

    /**
     * Returns true if both notes have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Note)) {
            return false;
        }

        Note otherNote = (Note) other;
        return otherNote.content.equals(content)
                && otherNote.importance.equals(importance);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(content, importance);
    }

    /**
     * Template: "[IMPORTANCE] 'content'".
     *
     * @return string representation according to the template
     */
    @Override
    public String toString() {
        return "Importance[" + this.importance + "] " + this.content;
    }
}
