package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.InternshipBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyInternshipBook;
import seedu.address.model.internship.Internship;
import seedu.address.model.person.Person;

/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "internshipbook")
class JsonSerializableInternshipBook {

    public static final String MESSAGE_DUPLICATE_INTERNSHIP = "Internships list contains duplicate internship(s).";

    private final List<JsonAdaptedInternship> internships = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given persons.
     */
    @JsonCreator
    public JsonSerializableInternshipBook(@JsonProperty("internships") List<JsonAdaptedInternship> internships) {
        this.internships.addAll(internships);
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableInternshipBook(ReadOnlyInternshipBook source) {
        internships.addAll(source.getInternshipList().stream().map(JsonAdaptedInternship::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public InternshipBook toModelType() throws IllegalValueException {
        InternshipBook internshipBook = new InternshipBook();
        for (JsonAdaptedInternship jsonAdaptedInternship : internships) {
            Internship internship = jsonAdaptedInternship.toModelType();
            if (internshipBook.hasInternship(internship)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_INTERNSHIP);
            }
            internshipBook.addInternship(internship);
        }
        return internshipBook;
    }

}