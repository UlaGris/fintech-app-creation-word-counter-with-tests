package com.example.fintechappcreation_wordcounterwithtests;

import java.util.regex.Pattern;

public class TextCounter {
    private static final Pattern WHITESPACE = Pattern.compile("\\s+");

    public int countWords(String text) {
        if (text == null) return 0;

        String trimmedText = text.trim();
        if (trimmedText.isEmpty()) return 0;

        String[] textParts = WHITESPACE.split(trimmedText);
        int wordCount = 0;

        for (String textPart : textParts) {
            if (textPart != null && !textPart.isBlank()) {
                wordCount++;
            }
        }

        return wordCount;
    }

    public int countPunctuation(String text) {
        if (text == null) return 0;

        String trimmedText = text.trim();
        if (trimmedText.isEmpty()) return 0;

        int punctuationCount = 0;

        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);

            int characterType = Character.getType(character);

            if (characterType == Character.CONNECTOR_PUNCTUATION
                    || characterType == Character.DASH_PUNCTUATION
                    || characterType == Character.START_PUNCTUATION
                    || characterType == Character.END_PUNCTUATION
                    || characterType == Character.INITIAL_QUOTE_PUNCTUATION
                    || characterType == Character.FINAL_QUOTE_PUNCTUATION
                    || characterType == Character.OTHER_PUNCTUATION) {
                punctuationCount++;
            }
        }

        return punctuationCount;
    }
}