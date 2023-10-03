package seedu.address.model.internship;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Internship's company name in Flagship.
 * Guarantees: immutable; is valid as declared in {@link #isValidCompanyName(String)}
 */
public class CompanyName {

    public static final String MESSAGE_CONSTRAINTS =
            "Company names should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the company name must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String companyName;

    /**
     * Constructs a {@code CompanyName}.
     *
     * @param companyName A valid company name.
     */
    public CompanyName(String companyName) {
        requireNonNull(companyName);
        checkArgument(isValidCompanyName(companyName), MESSAGE_CONSTRAINTS);
        this.companyName = companyName;
    }

    /**
     * Returns true if a given string is a valid company name.
     */
    public static boolean isValidCompanyName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.companyName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CompanyName)) {
            return false;
        }

        CompanyName otherCompanyName = (CompanyName) other;
        return this.companyName.equals(otherCompanyName.companyName);
    }

    @Override
    public int hashCode() {
        return this.companyName.hashCode();
    }

}
