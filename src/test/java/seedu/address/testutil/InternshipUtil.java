package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_APPLICATION_STATUS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REQUIREMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;

import java.util.Set;

import seedu.address.logic.commands.CreateCommand;
import seedu.address.logic.commands.ModifyCommand.EditInternshipDescriptor;
import seedu.address.model.internship.Internship;
import seedu.address.model.requirement.Requirement;

/**
 * A utility class for Internship.
 */
public class InternshipUtil {

    /**
     * Returns a create command string for adding the {@code internship}.
     */
    public static String getCreateCommand(Internship internship) {
        return CreateCommand.COMMAND_WORD + " " + getInternshipDetails(internship);
    }

    /**
     * Returns the part of command string for the given {@code internship}'s details.
     */
    public static String getInternshipDetails(Internship internship) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_COMPANY_NAME + internship.getCompanyName().companyName + " ");
        sb.append(PREFIX_ROLE + internship.getRole().toString() + " ");
        sb.append(PREFIX_APPLICATION_STATUS + internship.getApplicationStatus().applicationStatus + " ");
        sb.append(PREFIX_DEADLINE + internship.getDeadline().toString() + " ");
        sb.append(PREFIX_START_DATE + internship.getStartDate().toString() + " ");
        sb.append(PREFIX_DURATION + internship.getDuration().duration + " ");
        internship.getRequirements().stream().forEach(
            s -> sb.append(PREFIX_REQUIREMENT + s.requirementName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditInternshipDescriptor}'s details.
     */
    public static String getEditInternshipDescriptorDetails(EditInternshipDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getCompanyName()
                .ifPresent(companyName -> sb.append(PREFIX_COMPANY_NAME).append(companyName.companyName).append(" "));
        descriptor.getRole().ifPresent(role -> sb.append(PREFIX_ROLE).append(role.toString()).append(" "));
        descriptor.getApplicationStatus()
                .ifPresent(applicationStatus -> sb
                        .append(PREFIX_APPLICATION_STATUS)
                        .append(applicationStatus.applicationStatus).append(" "));
        descriptor.getDeadline()
                .ifPresent(deadline -> sb.append(PREFIX_DEADLINE).append(deadline.toString()).append(" "));
        descriptor.getStartDate()
                .ifPresent(startDate -> sb.append(PREFIX_START_DATE).append(startDate.toString()).append(" "));
        descriptor.getDuration()
                .ifPresent(duration -> sb.append(PREFIX_DURATION).append(duration.duration).append(" "));
        if (descriptor.getRequirements().isPresent()) {
            Set<Requirement> requirements = descriptor.getRequirements().get();
            if (requirements.isEmpty()) {
                sb.append(PREFIX_REQUIREMENT);
            } else {
                requirements.forEach(s -> sb.append(PREFIX_REQUIREMENT).append(s.requirementName).append(" "));
            }
        }
        return sb.toString();
    }
}
