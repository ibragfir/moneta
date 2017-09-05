package com.example.moneta.util;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StringUtils {

    /**
     * Reduces multiple (more than one) white spaces into a single one (including leading and trailing).
     * Reverses a string backwards with the following rule:
     * in positions of special characters (provided as a second parameter),
     * the reversed string would contain upper case characters, the rest would be lower cased.
     *
     * @param word a string to reverse
     * @param upperChars special characters
     * @return the reversed and lower cased string
     */
    public static String reverseAndLower(String word, Set<Character> upperChars) {
        Objects.requireNonNull(word);
        Objects.requireNonNull(upperChars);

        Set<Integer> toUpperIdx = new HashSet<>();
        StringBuilder result = new StringBuilder();
        boolean prevSpace = false;
        for (int i = word.length() - 1; i >= 0; --i) {
            char c = word.charAt(i);
            boolean isSpace = Character.isWhitespace(c);
            if (!prevSpace || !isSpace) {
                result.append(Character.toLowerCase(c));
            }
            if (upperChars.contains(c)) {
                toUpperIdx.add(result.length());
            }
            prevSpace = isSpace;
        }

        int len = result.length();
        toUpperIdx.forEach(idx -> result.setCharAt(len - idx, Character.toUpperCase(result.charAt(len - idx))));

        return result.toString();
    }
}
