package com.example.fintechappcreation_wordcounterwithtests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextCounterTest {

    private TextCounter textCounter;

    @Before
    public void setUp() {
        textCounter = new TextCounter();
    }

    @Test
    public void countWords_nullText_returnsZero() {
        assertEquals(0, textCounter.countWords(null));
    }

    @Test
    public void countWords_emptyText_returnsZero() {
        assertEquals(0, textCounter.countWords(""));
    }

    @Test
    public void countWords_onlySpaces_returnsZero() {
        assertEquals(0, textCounter.countWords("     "));
    }

    @Test
    public void countWords_onlyTabs_returnsZero() {
        assertEquals(0, textCounter.countWords("\t\t\t"));
    }

    @Test
    public void countWords_onlyNewLines_returnsZero() {
        assertEquals(0, textCounter.countWords("\n\n"));
    }

    @Test
    public void countWords_normalText_returnsCorrectCount() {
        assertEquals(5, textCounter.countWords("Hello world how are you"));
    }

    @Test
    public void countWords_textWithMultipleSpacesAndTabs_returnsCorrectCount() {
        assertEquals(5, textCounter.countWords("Hello   world\tthis \t is fine"));
    }

    @Test
    public void countWords_textWithLeadingAndTrailingSpaces_returnsCorrectCount() {
        assertEquals(2, textCounter.countWords("   Hello world   "));
    }

    @Test
    public void countWords_punctuationAttachedToWords_stillCountsWords() {
        assertEquals(4, textCounter.countWords("Hello, how are you?"));
    }

    @Test
    public void countPunctuation_nullText_returnsZero() {
        assertEquals(0, textCounter.countPunctuation(null));
    }

    @Test
    public void countPunctuation_emptyText_returnsZero() {
        assertEquals(0, textCounter.countPunctuation(""));
    }

    @Test
    public void countPunctuation_onlySpaces_returnsZero() {
        assertEquals(0, textCounter.countPunctuation("     "));
    }

    @Test
    public void countPunctuation_onlyTabs_returnsZero() {
        assertEquals(0, textCounter.countPunctuation("\t\t"));
    }

    @Test
    public void countPunctuation_textWithoutPunctuation_returnsZero() {
        assertEquals(0, textCounter.countPunctuation("Hello world how are you"));
    }

    @Test
    public void countPunctuation_normalTextWithPunctuation_returnsCorrectCount() {
        assertEquals(3, textCounter.countPunctuation("Hello, world! How are you."));
    }

    @Test
    public void countPunctuation_onlyPunctuation_returnsCorrectCount() {
        assertEquals(6, textCounter.countPunctuation("!?.;,:"));
    }

    @Test
    public void countPunctuation_mixedTextWithBracketsQuotesAndDash_returnsCorrectCount() {
        assertEquals(6, textCounter.countPunctuation("\"Hello\" (test) - great!"));
    }

    @Test
    public void countPunctuation_underscoresAreCountedAsConnectorPunctuation() {
        assertEquals(2, textCounter.countPunctuation("hello_world_test"));
    }
}