package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DIFFICULTY;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.SetDifficultyCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new SetDifficultyCommand object
 */
public class SetDifficultyCommandParser implements Parser<SetDifficultyCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SetDifficultyCommand
     * and returns a SetDifficultyCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SetDifficultyCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_DIFFICULTY);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    SetDifficultyCommand.MESSAGE_USAGE), pe);
        }

        // Compulsory field: Difficulty
        if (!arePrefixesPresent(argMultimap, PREFIX_DIFFICULTY)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetDifficultyCommand.MESSAGE_USAGE));
        }

        String difficulty = argMultimap.getValue(PREFIX_DIFFICULTY).get();

        return new SetDifficultyCommand(index, difficulty);

    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
