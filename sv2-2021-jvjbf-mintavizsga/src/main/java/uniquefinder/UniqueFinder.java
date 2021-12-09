package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {
    public List<Character> getUniqueChars(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Text is null.");
        }
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            char actual = line.charAt(i);
            if (!result.contains(actual)) {
                result.add(actual);
            }
        }
        return result;
    }

}
