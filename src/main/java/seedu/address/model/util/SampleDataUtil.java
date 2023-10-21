package seedu.address.model.util;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.Deck;
import seedu.address.model.card.Answer;
import seedu.address.model.card.Card;
import seedu.address.model.card.NextPracticeDate;
import seedu.address.model.card.Question;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Card[] getSampleCard() {
        return new Card[] {
            new Card(new Question("What is 1 + 1"),
                new Answer("2"), "new",
                        new NextPracticeDate(LocalDateTime.now())),
            new Card(new Question("What is 1 + 3"), new Answer("4"),
                "easy", new NextPracticeDate(LocalDateTime.now()))
        };
    }

    public static Deck getSampleDeck() {
        Deck sampleAb = new Deck();
        for (Card sampleCard : getSampleCard()) {
            sampleAb.addCard(sampleCard);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
