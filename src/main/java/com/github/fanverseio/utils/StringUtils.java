package com.github.fanverseio.utils;

public class StringUtils {

    /**
     * Check if a string a palindrome.
     * @param input the string to check.
     * @return true if the string is palindrome, false otherwise
     */

    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }


}
