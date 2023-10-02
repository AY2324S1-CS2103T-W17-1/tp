package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ReadCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ReadCommand object.
 */
public class ReadCommandParser implements Parser<ReadCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ReadCommand.
     * 
     * @param userInput full user input string
     * @return a ReadCommand object for execution
     * @throws ParseException if the user input does not conform to the expected format
     */
    @Override
    public ReadCommand parse(String userInput) throws ParseException {
        try {
            // Use ParserUtil to parse the index
            Index index = ParserUtil.parseIndex(userInput);
            return new ReadCommand(index);
        } catch (ParseException pe) {
            throw new ParseException("The index provided is not a valid number.", pe);
        }
    }
}
