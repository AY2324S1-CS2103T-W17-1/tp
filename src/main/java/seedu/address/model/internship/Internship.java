package seedu.address.model.internship;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.requirement.Requirement;

/**
 * Represents an Internship in Flagship.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Internship {

    /**
     * Identity fields
     *
     * To keep validation simple and Flagship easier to use, we will assume that two internships with identical roles
     * and names (case-sensitive) are the same even if they may have different data fields such as different
     * requirements.
     */
    private final CompanyName companyName;
    private final Role role;

    // Data fields
    private final ApplicationStatus applicationStatus;

    private final Deadline deadline;
    private final StartDate startDate;
    private final Duration duration;
    private final Set<Requirement> requirements = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Internship(CompanyName companyName, Role role, ApplicationStatus applicationStatus, Deadline deadline,
                      StartDate startDate, Duration duration, Set<Requirement> requirements) {
        requireAllNonNull(companyName, role, requirements, applicationStatus, startDate, duration);
        this.companyName = companyName;
        this.role = role;
        this.applicationStatus = applicationStatus;
        this.deadline = deadline;
        this.startDate = startDate;
        this.duration = duration;
        this.requirements.addAll(requirements);
    }

    public CompanyName getCompanyName() {
        return this.companyName;
    }

    public Role getRole() {
        return this.role;
    }


    /**
     * Returns an immutable requirement set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Requirement> getRequirements() {
        return Collections.unmodifiableSet(this.requirements);
    }

    public ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    public Deadline getDeadline() {
        return this.deadline;
    }

    public StartDate getStartDate() {
        return this.startDate;
    }

    public Duration getDuration() {
        return this.duration;
    }

    /**
     * Returns true if both internships have the same company name and role.
     * This defines a weaker notion of equality between two persons and will be primarily used throughout the program.
     */
    public boolean isSameInternship(Internship otherInternship) {
        if (otherInternship == this) {
            return true;
        }

        return otherInternship != null
                && otherInternship.getCompanyName().equals(this.getCompanyName())
                && otherInternship.getRole().equals(this.getRole());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("Company Name", this.companyName)
                .add("Role", this.role)
                .add("Application Status", this.applicationStatus)
                .add("Deadline", this.deadline)
                .add("Start Date", this.startDate)
                .add("Duration", this.duration)
                .add("Requirements", this.requirements)
                .toString();
    }

    /**
     * Returns string representation of the internship's role
     */
    public String getRoleString() {
        return this.role.toString();
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Internship)) {
            return false;
        }

        Internship otherInternship = (Internship) other;
        return this.companyName.equals(otherInternship.companyName)
                && this.role.equals(otherInternship.role)
                && this.applicationStatus.equals(otherInternship.applicationStatus)
                && this.deadline.equals(otherInternship.deadline)
                && this.startDate.equals(otherInternship.startDate)
                && this.duration.equals(otherInternship.duration)
                && this.requirements.equals(otherInternship.requirements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.companyName, this.role, this.applicationStatus, this.deadline,
                this.startDate, this.duration, this.requirements);
    }
}
