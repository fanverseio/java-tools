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

}
