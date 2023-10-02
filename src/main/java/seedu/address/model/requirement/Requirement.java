package seedu.address.model.requirement;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Requirement in Flagship.
 * Guarantees: immutable; name is valid as declared in {@link #isValidRequirementName(String)}
 */
public class Requirement {

    public static final String MESSAGE_CONSTRAINTS = "Requirements cannot be empty";
    public static final String VALIDATION_REGEX = "\\S+";

    public final String requirementName;

    /**
     * Constructs a {@code Requirement}.
     *
     * @param requirementName A valid requirement name.
     */
    public Requirement(String requirementName) {
        requireNonNull(requirementName);
        checkArgument(isValidRequirementName(requirementName), MESSAGE_CONSTRAINTS);
        this.requirementName = requirementName;
    }

    /**
     * Returns true if a given string is a valid requirement name.
     */
    public static boolean isValidRequirementName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Requirement)) {
            return false;
        }

        Requirement otherRequirement = (Requirement) other;
        return this.requirementName.equals(otherRequirement.requirementName);
    }

    @Override
    public int hashCode() {
        return this.requirementName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + this.requirementName + ']';
    }

}
