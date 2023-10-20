package seedu.address.model.internship;

import seedu.address.commons.util.ToStringBuilder;

import java.util.List;
import java.util.function.Predicate;

public class DurationWithinPredicate implements Predicate<Internship> {
    private final List<Duration> durationRange;
    public DurationWithinPredicate(List<Duration> durationRange) {
        this.durationRange = durationRange;
    }

    @Override
    public boolean test(Internship internship) {
        Duration internshipDuration = internship.getDuration();
        Duration startDuration = durationRange.get(0);
        Duration endDuration = durationRange.get(1);

        return internshipDuration.compareTo(startDuration) >= 0
                && internshipDuration.compareTo(endDuration) <= 0;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DurationWithinPredicate)) {
            return false;
        }

        DurationWithinPredicate otherDurationWithinPredicate = (DurationWithinPredicate) other;
        return durationRange.equals(otherDurationWithinPredicate.durationRange);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("durationRange", durationRange).toString();
    }
}
