package utils;

import com.github.fanverseio.utils.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("Madam"));
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertFalse(StringUtils.isPalindrome("Hello"));
        assertTrue(StringUtils.isPalindrome("lliill"));
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    public void testLengthOfSubstring() {
        // Test case 1: Basic input with no repeating characters
        assertEquals(3, StringUtils.lengthOfSubstring("abc"));

        // Test case 2: Input with repeating characters
        assertEquals(3, StringUtils.lengthOfSubstring("abcabcbb"));

        // Test case 3: Input with all repeating characters
        assertEquals(1, StringUtils.lengthOfSubstring("bbbbb"));

        // Test case 4: Input with a mix of repeating and non-repeating characters
        assertEquals(3, StringUtils.lengthOfSubstring("pwwkew"));

        // Test case 5: Empty string
        assertEquals(0, StringUtils.lengthOfSubstring(""));

        // Test case 6: Null input
        assertEquals(0, StringUtils.lengthOfSubstring(null));
    }

    @Test
    public void testIncreasingDecreasing() {
        // Test case 1: Input with repeated characters
        assertEquals("abccbaabccba", StringUtils.increasingDecreasing("aaaabbbbcccc"));

        // Test case 2: Input with unique characters
        assertEquals("art", StringUtils.increasingDecreasing("rat"));

        // Test case 3: Input with all the same characters
        assertEquals("aaaa", StringUtils.increasingDecreasing("aaaa"));

        // Test case 4: Input with a single character
        assertEquals("a", StringUtils.increasingDecreasing("a"));

        // Test case 5: Empty input
        assertEquals("", StringUtils.increasingDecreasing(""));

        // Test case 6: Null input
        assertEquals(null, StringUtils.increasingDecreasing(null));
    }

    @Test
    public void testCamelCaseToSnakeCase() {
        // Test case 1: Basic camelCase input
        assertEquals("camel_case", StringUtils.camelCaseToSnakeCase("camelCase"));

        // Test case 2: Input with multiple uppercase letters
        assertEquals("this_is_a_test", StringUtils.camelCaseToSnakeCase("thisIsATest"));

        // Test case 3: Input with leading uppercase letter
        assertEquals("leading_uppercase", StringUtils.camelCaseToSnakeCase("LeadingUppercase"));

        // Test case 4: Input with no uppercase letters
        assertEquals("nouppercase", StringUtils.camelCaseToSnakeCase("nouppercase"));

        // Test case 5: Empty input
        assertEquals("", StringUtils.camelCaseToSnakeCase(""));

        // Test case 6: Null input
        assertEquals(null, StringUtils.camelCaseToSnakeCase(null));
    }

    @Test
    public void testSnakeCaseToCamelCase() {
        // Test case 1: Basic snake_case input
        assertEquals("snakeCase", StringUtils.snakeCaseToCamelCase("snake_case"));

        // Test case 2: Input with multiple underscores
        assertEquals("thisIsATest", StringUtils.snakeCaseToCamelCase("this_is_a_test"));

        // Test case 3: Input with leading underscore
        assertEquals("leadingUnderscore", StringUtils.snakeCaseToCamelCase("leading_underscore"));

        // Test case 4: Input with no underscores
        assertEquals("nounderscore", StringUtils.snakeCaseToCamelCase("nounderscore"));

        // Test case 5: Empty input
        assertEquals("", StringUtils.snakeCaseToCamelCase(""));

        // Test case 6: Null input
        assertEquals(null, StringUtils.snakeCaseToCamelCase(null));
    }

    @Test
    public void testReverseSentenceWithPunctuation() {
        // Test case 1: Sentence with punctuation marks that should be removed
        assertEquals("ok you are Hello",
                StringUtils.reverseSentenceWithPunctuation("Hello, are you ok?"));

        // Test case 2: Sentence with multiple punctuation marks
        assertEquals("test a is This",
                StringUtils.reverseSentenceWithPunctuation("This is a test!"));

        // Test case 3: Single word with punctuation
        assertEquals("Single",
                StringUtils.reverseSentenceWithPunctuation("Single."));

        // Test case 4: Multiple spaces between words
        assertEquals("here spaces Multiple",
                StringUtils.reverseSentenceWithPunctuation("  Multiple   spaces   here  "));

        // Test case 5: Word with no punctuation
        assertEquals("NoPunctuation",
                StringUtils.reverseSentenceWithPunctuation("NoPunctuation"));

        // Test case 6: Complex sentence with mixed punctuation
        assertEquals("world hello",
                StringUtils.reverseSentenceWithPunctuation("hello!!! world???"));

        // Test case 7: Null input
        assertEquals(null,
                StringUtils.reverseSentenceWithPunctuation(null));

        // Test case 8: Empty string
        assertEquals("",
                StringUtils.reverseSentenceWithPunctuation(""));
    }
}
