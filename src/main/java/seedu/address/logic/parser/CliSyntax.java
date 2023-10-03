package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */

    // DELETE ALL OF THIS WHEN WE FULLY TRANSITION OUT
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_REMARK = new Prefix("r/");


    // New set of prefixes for Flagship
    public static final Prefix PREFIX_COMPANY_NAME = new Prefix("c/");
    public static final Prefix PREFIX_ROLE = new Prefix("ro/");
    public static final Prefix PREFIX_REQUIREMENT = new Prefix("re/");
    public static final Prefix PREFIX_APPLICATION_STATUS = new Prefix("a/");
    public static final Prefix PREFIX_START_DATE = new Prefix("s/");
    public static final Prefix PREFIX_DURATION = new Prefix("d/");

}
