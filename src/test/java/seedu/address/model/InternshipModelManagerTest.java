package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.InternshipModel.PREDICATE_SHOW_ALL_INTERNSHIPS;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalInternships.CITADEL;
import static seedu.address.testutil.TypicalInternships.JANESTREET;
import static seedu.address.testutil.TypicalInternships.OPTIVER;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.internship.Internship;
import seedu.address.model.internship.InternshipComparators;
import seedu.address.model.internship.NameContainsKeywordsPredicate;
import seedu.address.testutil.InternshipBookBuilder;

public class InternshipModelManagerTest {

    private InternshipModelManager internshipModelManager = new InternshipModelManager();

    @Test
    public void constructor() {
        assertEquals(new InternshipUserPrefs(), internshipModelManager.getUserPrefs());
        assertEquals(new GuiSettings(), internshipModelManager.getGuiSettings());
        assertEquals(new InternshipBook(), new InternshipBook(internshipModelManager.getInternshipBook()));
    }

    @Test
    public void setUserPrefs_nullUserPrefs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> internshipModelManager.setUserPrefs(null));
    }

    @Test
    public void setUserPrefs_validUserPrefs_copiesUserPrefs() {
        InternshipUserPrefs userPrefs = new InternshipUserPrefs();
        userPrefs.setInternshipFilePath(Paths.get("internship/book/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        internshipModelManager.setUserPrefs(userPrefs);
        assertEquals(userPrefs, internshipModelManager.getUserPrefs());

        // Modifying userPrefs should not modify internshipModelManager's userPrefs
        InternshipUserPrefs oldUserPrefs = new InternshipUserPrefs(userPrefs);
        userPrefs.setInternshipFilePath(Paths.get("new/internship/book/file/path"));
        assertEquals(oldUserPrefs, internshipModelManager.getUserPrefs());
    }

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> internshipModelManager.setGuiSettings(null));
    }

    @Test
    public void setGuiSettings_validGuiSettings_setsGuiSettings() {
        GuiSettings guiSettings = new GuiSettings(1, 2, 3, 4);
        internshipModelManager.setGuiSettings(guiSettings);
        assertEquals(guiSettings, internshipModelManager.getGuiSettings());
    }

    @Test
    public void setInternshipBookFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> internshipModelManager.setInternshipBookFilePath(null));
    }

    @Test
    public void setInternshipBookFilePath_validPath_setsInternshipBookFilePath() {
        Path path = Paths.get("internship/book/file/path");
        internshipModelManager.setInternshipBookFilePath(path);
        assertEquals(path, internshipModelManager.getInternshipBookFilePath());
    }

    @Test
    public void hasInternship_nullInternship_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> internshipModelManager.hasInternship(null));
    }

    @Test
    public void hasInternship_internshipNotInInternshipBook_returnsFalse() {
        assertFalse(internshipModelManager.hasInternship(JANESTREET));
    }

    @Test
    public void hasInternship_internshipInInternshipBook_returnsTrue() {
        internshipModelManager.createInternship(JANESTREET);
        assertTrue(internshipModelManager.hasInternship(JANESTREET));
    }

    @Test
    public void getFilteredInternshipList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> internshipModelManager
                .getFilteredInternshipList().remove(0));
    }

    @Test
    public void equals() {
        InternshipBook internshipBook = new InternshipBookBuilder().withInternship(JANESTREET)
                .withInternship(CITADEL).build();
        InternshipBook differentInternshipBook = new InternshipBook();
        InternshipUserPrefs userPrefs = new InternshipUserPrefs();

        // same values -> returns true
        internshipModelManager = new InternshipModelManager(internshipBook, userPrefs);
        InternshipModelManager internshipModelManagerCopy = new InternshipModelManager(internshipBook, userPrefs);
        assertTrue(internshipModelManager.equals(internshipModelManagerCopy));

        // same object -> returns true
        assertTrue(internshipModelManager.equals(internshipModelManager));

        // null -> returns false
        assertFalse(internshipModelManager.equals(null));

        // different types -> returns false
        assertFalse(internshipModelManager.equals(5));

        // different internshipBook -> returns false
        assertFalse(internshipModelManager.equals(new InternshipModelManager(differentInternshipBook, userPrefs)));

        // different filteredList -> returns false

        String[] keywords = JANESTREET.getCompanyName().companyName.split("\\s+");
        internshipModelManager.updateFilteredInternshipList(new NameContainsKeywordsPredicate(Arrays.asList(keywords)));
        assertFalse(internshipModelManager.equals(new InternshipModelManager(internshipBook, userPrefs)));

        // resets internshipModelManager to initial state for upcoming tests
        internshipModelManager.updateFilteredInternshipList(PREDICATE_SHOW_ALL_INTERNSHIPS);

        // different userPrefs -> returns false
        InternshipUserPrefs differentUserPrefs = new InternshipUserPrefs();
        differentUserPrefs.setInternshipFilePath(Paths.get("differentFilePath"));
        assertFalse(internshipModelManager.equals(new InternshipModelManager(internshipBook, differentUserPrefs)));
    }

    @Test
    public void createInternship_internshipsAreSortedByComparator() {
        internshipModelManager.createInternship(JANESTREET);
        internshipModelManager.createInternship(CITADEL);
        ObservableList<Internship> internships = internshipModelManager.getFilteredInternshipList();
        // Assuming the default comparator is by company name
        assertEquals(internships.get(0), CITADEL);
        assertEquals(internships.get(1), JANESTREET);
    }

    @Test
    public void updateSortComparator_internshipsAreSortedByNewComparator() {
        internshipModelManager.updateSortComparator(InternshipComparators.BY_DURATION.reversed());
        internshipModelManager.createInternship(JANESTREET);
        internshipModelManager.createInternship(OPTIVER);
        ObservableList<Internship> internships = internshipModelManager.getFilteredInternshipList();
        assertEquals(internships.get(0), OPTIVER);
        assertEquals(internships.get(1), JANESTREET);
    }
}
