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
public void testIncreasingDecreasing(){
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

}
