package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.PractiseCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new PractiseCommand object
 */
public class PractiseCommandParser implements Parser<PractiseCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the PractiseCommand
     * and returns a PractiseCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public PractiseCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new PractiseCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, PractiseCommand.MESSAGE_USAGE), pe);
        }
    }
}
