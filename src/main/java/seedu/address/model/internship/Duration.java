package seedu.address.model.internship;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Internship's duration in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDuration(String)}
 */
public class Duration implements Comparable<Duration> {

    public static final String MESSAGE_CONSTRAINTS =
            "Internship durations should only contain positive numbers representing months and should not be blank";
    public static final String VALIDATION_REGEX = "[1-9]\\d*";
    public final String duration;

    /**
     * Constructs a {@code Duration}.
     *
     * @param duration A valid duration in months.
     */
    public Duration(String duration) {
        requireNonNull(duration);
        checkArgument(isValidDuration(duration), MESSAGE_CONSTRAINTS);
        this.duration = duration;
    }

    /**
     * Returns true if a given string is a valid duration.
     */
    public static boolean isValidDuration(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.duration;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Duration)) {
            return false;
        }

        Duration otherDuration = (Duration) other;
        return this.duration.equals(otherDuration.duration);
    }

    @Override
    public int hashCode() {
        return this.duration.hashCode();
    }

    @Override
    public int compareTo(Duration other) {
        return Integer.compare(Integer.parseInt(this.duration), Integer.parseInt(other.duration));
    }
}
