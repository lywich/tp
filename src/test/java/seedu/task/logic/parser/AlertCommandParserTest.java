package seedu.task.logic.parser;

import static seedu.task.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.task.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.task.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.task.logic.commands.AlertCommand;
import seedu.task.logic.commands.DeleteCommand;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the AlertCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the AlertCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class AlertCommandParserTest {
    private AlertCommandParser parser = new AlertCommandParser();

    @Test
    public void parser_validArgs_returnsAlertCommand() {
        assertParseSuccess(parser, "1", new AlertCommand(1));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, AlertCommand.MESSAGE_USAGE));
    }
}
