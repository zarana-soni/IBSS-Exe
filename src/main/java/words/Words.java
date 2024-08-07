package words;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Words {
    public static List<String> getUniqueWordsFromSentence(String sentence) {
        //throw new UnsupportedOperationException();
        // Normalize the sentence by converting to lower case and removing punctuation
        String normalizedSentence = sentence.toLowerCase().replaceAll("[^a-z\\s]", "");

// Split the sentence into words and collect unique words
        Set<String> uniqueWordsSet = Arrays.stream(normalizedSentence.split("\\s+"))
                .collect(Collectors.toSet());

// Convert the set to a list and return
        return List.copyOf(uniqueWordsSet);
    }
}
