package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.InternshipBuilder;

/**
 * Contains tests for {@code CompanyNameContainsKeywordsPredicate}.
 * This class is responsible for testing the behavior of {@link CompanyNameContainsKeywordsPredicate}
 * to ensure that it correctly identifies if an {@code Internship}'s {@code CompanyName} matches any
 * of the given keywords.
 *
 * @see CompanyNameContainsKeywordsPredicate
 */
public class CompanyNameContainsKeywordsPredicateTest {

    @Test
    public void test_companyNameContainsKeywords_returnsTrue() {
        CompanyNameContainsKeywordsPredicate predicate =
                new CompanyNameContainsKeywordsPredicate(Collections.singletonList("Google"));
        Internship internship = new InternshipBuilder().withCompanyName("Google").build();
        assertTrue(predicate.test(internship));
    }

    @Test
    public void test_companyNameDoesNotContainKeywords_returnsFalse() {
        CompanyNameContainsKeywordsPredicate predicate =
                new CompanyNameContainsKeywordsPredicate(Collections.singletonList("Facebook"));
        Internship internship = new InternshipBuilder().withCompanyName("Google").build();
        assertFalse(predicate.test(internship));
    }

    @Test
    public void testMultipleKeywords_oneMatch_returnsTrue() {
        CompanyNameContainsKeywordsPredicate predicate =
                new CompanyNameContainsKeywordsPredicate(Arrays.asList("Google", "Apple"));
        Internship internship = new InternshipBuilder().withCompanyName("Google").build();
        assertTrue(predicate.test(internship));
    }

    @Test
    public void testMultipleKeywords_noMatch_returnsFalse() {
        CompanyNameContainsKeywordsPredicate predicate =
                new CompanyNameContainsKeywordsPredicate(Arrays.asList("Facebook", "Apple"));
        Internship internship = new InternshipBuilder().withCompanyName("Google").build();
        assertFalse(predicate.test(internship));
    }

    @Test
    public void testEqualsSelf_returnsTrue() {
        CompanyNameContainsKeywordsPredicate predicate =
                new CompanyNameContainsKeywordsPredicate(Arrays.asList("Facebook", "Apple"));
        assertTrue(predicate.equals(predicate));
    }

    @Test
    public void testEqualsNull_returnsFalse() {
        CompanyNameContainsKeywordsPredicate predicate =
                new CompanyNameContainsKeywordsPredicate(Arrays.asList("Facebook", "Apple"));
        assertFalse(predicate.equals(null));
    }

    @Test
    public void testToString_returnsTrue() {
        CompanyNameContainsKeywordsPredicate predicate =
                new CompanyNameContainsKeywordsPredicate(Arrays.asList("Facebook", "Apple"));
        assertTrue(predicate.toString().equals(
                "seedu.address.model.internship.CompanyNameContainsKeywordsPredicate{keywords=[Facebook, Apple]}")
        );
    }

}