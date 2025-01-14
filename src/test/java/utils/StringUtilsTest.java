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

    @Test
    public void testCountOccurences() {
        // Test case 1: Basic input with multiple occurrences
        assertEquals(3, StringUtils.countOccurences("ababab", "ab"));

        // Test case 2: Input with overlapping patterns
        assertEquals(2, StringUtils.countOccurences("aaaa", "aa"));

        // Test case 3: Input with no occurrences
        assertEquals(0, StringUtils.countOccurences("abcdef", "gh"));

        // Test case 4: Input with pattern at the start and end
        assertEquals(2, StringUtils.countOccurences("abcabc", "abc"));

        // Test case 5: Empty input string
        assertEquals(0, StringUtils.countOccurences("", "pattern"));

        // Test case 6: Empty pattern string
        assertEquals(0, StringUtils.countOccurences("input", ""));

        // Test case 7: Null input string
        assertEquals(0, StringUtils.countOccurences(null, "pattern"));

        // Test case 8: Null pattern string
        assertEquals(0, StringUtils.countOccurences("input", null));

        // Test case 9: Both input and pattern are null
        assertEquals(0, StringUtils.countOccurences(null, null));

        // Test case 10: Pattern longer than input
        assertEquals(0, StringUtils.countOccurences("short", "longerpattern"));
    }

    @Test
    public void testPasswordChecker() {
        // Test case 1: Password meets all criteria
        assertTrue(StringUtils.passwordChecker("Password1!", true, true, true, 8));

        // Test case 2: Password meets length but missing lowercase
        assertFalse(StringUtils.passwordChecker("PASSWORD1!", true, true, true, 8));

        // Test case 3: Password meets length but missing uppercase
        assertFalse(StringUtils.passwordChecker("password1!", true, true, true, 8));

        // Test case 4: Password meets length but missing symbol
        assertFalse(StringUtils.passwordChecker("Password1", true, true, true, 8));

        // Test case 5: Password meets length but missing all criteria
        assertFalse(StringUtils.passwordChecker("password", true, true, true, 8));

        // Test case 6: Password meets all criteria with minimum length
        assertTrue(StringUtils.passwordChecker("P1!", false, true, true, 3));

        // Test case 7: Password shorter than minimum length
        assertFalse(StringUtils.passwordChecker("P1!", true, true, true, 4));

        // Test case 8: Password meets criteria but no symbol required
        assertTrue(StringUtils.passwordChecker("Password1", true, true, false, 8));

        // Test case 9: Password meets criteria but no uppercase required
        assertTrue(StringUtils.passwordChecker("password1!", true, false, true, 8));

        // Test case 10: Password meets criteria but no lowercase required
        assertTrue(StringUtils.passwordChecker("PASSWORD1!", false, true, true, 8));

        // Test case 11: Null input
        assertFalse(StringUtils.passwordChecker(null, true, true, true, 8));

        // Test case 12: Empty input
        assertFalse(StringUtils.passwordChecker("", true, true, true, 8));
    }
}
