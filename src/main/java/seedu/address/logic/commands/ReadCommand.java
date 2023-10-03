package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.internship.Internship;
import seedu.address.logic.Messages;

/**
 * Reads the details of a specific internship entry index.
 */
public class ReadCommand extends Command {

    public static final String COMMAND_WORD = "read";

    public static final String MESSAGE_USAGE = String.format("%s: Reads details of an internship entry in Flagship. "
    + "Parameters: NUMBER\n"
    + "Example: %s 1", COMMAND_WORD, COMMAND_WORD);

    public static final String MESSAGE_READ_ENTRY_SUCCESS = "Here is the information of entry %d:\n"
            + "Start Date: %s\n"
            + "Duration: %s\n"
            + "Company Name: %s\n"
            + "Role: %s\n"
            + "Requirements: %s\n"
            + "Application Status: %s";

    public static final String MESSAGE_NON_EXISTENT_INTERNSHIP = "There are no internship entries associated with %d";

    public static final String MESSAGE_INVALID_INPUT = "“read” expects 1 numeric parameter";

    // The index of the internship entry to be read.
    private final Index targetIndex;

    /**
     * Creates a ReadCommand to read the specified internship entry by its index.
     * 
     * @param index The index of the internship entry to be read.
     */
    public ReadCommand(Index index) {
        this.targetIndex = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Internship> lastShownList = model.getFilteredInternshipList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Internship internship = lastShownList.get(targetIndex.getZeroBased());

        String formattedMessage = String.format(
                MESSAGE_READ_ENTRY_SUCCESS,
                targetIndex.getOneBased(), // assuming targetIndex is of type Index
                internship.getStartDate(),
                internship.getDuration(),
                internship.getCompanyName(),
                internship.getRole(),
                internship.getRequirements(), // this might need additional processing if it's not a String
                internship.getApplicationStatus()
        );
        
        return new CommandResult(formattedMessage);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ReadCommand)) {
            return false;
        }

        ReadCommand otherReadCommand = (ReadCommand) other;
        return targetIndex == otherReadCommand.targetIndex;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
