package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.internship.Internship;

/**
 * A utility class containing a list of {@code Internship} objects to be used in tests.
 */
public class TypicalInternships {

    public static final Internship JANESTREET = new InternshipBuilder().withCompanyName("Jane Street")
            .withRole("Software Engineer")
            .withDuration("3")
            .withRequirements(new String[]{"2 years of experience"})
            .withStartDate("07/05/2023").build();

    public static final Internship OPTIVER = new InternshipBuilder().withCompanyName("Optiver")
            .withRole("Software Engineer")
            .withDuration("3")
            .withRequirements(new String[]{"3 years of experience"})
            .withStartDate("07/05/2023").build();

    public static final Internship CITADEL = new InternshipBuilder().withCompanyName("Citadel")
            .withRole("Software Engineer")
            .withDuration("3")
            .withRequirements(new String[]{"4 years of experience"})
            .withStartDate("07/05/2023").build();

    private TypicalInternships() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical internships.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Internship internship : getTypicalInternships()) {
            ab.createInternship(internship);
        }
        return ab;
    }

    public static List<Internship> getTypicalInternships() {
        return new ArrayList<>(Arrays.asList(JANESTREET, OPTIVER, CITADEL));
    }
}
