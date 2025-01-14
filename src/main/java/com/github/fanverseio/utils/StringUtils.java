package com.github.fanverseio.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class StringUtils {

    /**
     * Check if a string a palindrome.
     * @param input the string to check.
     * @return true if the string is palindrome, false otherwise
     */

    public static boolean isPalindrome(String input) {
        if (input == null)
            return false;
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    };

    /**
     * Length of Substring without repeating characters.
     * @param input the string to check.
     * @return integer of the length of the substring
     */

    public static int lengthOfSubstring(String input) {

        if (input == null) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet();

        while (j < input.length()) {
            if (!hashSet.contains(input.charAt(j))) {
                hashSet.add(input.charAt(j));
                j++;
                max = Math.max(hashSet.size(), max);
            } else {
                hashSet.remove(input.charAt(i));
                i++;
            }
        }

        return max;

    }

    /**
     * Increasing decreasing String.
     * @param input the string to check.
     * @return string of the incresing - decreasing order
     */

    public static String increasingDecreasing(String input) {
        if (input == null) {
            return null;
        }

        if (input.isEmpty()) {
            return input;
        }

        StringBuilder sb = new StringBuilder(input.length());

        int[] charList = new int[26];

        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') { // Ensure the character is lowercase a-z
                charList[c - 'a']++;
            } else {
                char lower = Character.toLowerCase(c);
                if (lower >= 'a' && lower <= 'z') {
                    charList[lower - 'a']++;
                }
            }
        }

        boolean ascending = true;

        while (sb.length() < input.length()) {

            if (ascending) {

                for (int i = 0; i < 26; i++) {
                    if (charList[i] > 0) {
                        sb.append((char) (i + 'a'));
                        charList[i]--;
                    }
                }
            } else {

                for (int i = 25; i >= 0; i--) {
                    if (charList[i] > 0) {
                        sb.append((char) (i + 'a'));
                        charList[i]--;
                    }
                }
            }

            ascending = !ascending;
        }

        return sb.toString();

    };

    /**
     * camelCase to snake_case conversion.
     * @param input the camelCase string.
     * @return string of the same string in snake_case
     */

    public static String camelCaseToSnakeCase(String input) {
        if (input == null) {
            return null;
        }

        if (input.isEmpty()) {
            return input;
        }

        StringBuilder sb = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isUpperCase(ch)) {
                // Avoid leading underscore for the first character
                if (i != 0) {
                    sb.append('_');
                }
                sb.append(Character.toLowerCase(ch)); // Convert to lowercase
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();

    }

    /**
     * snake_case to camelCase conversion.
     * @param input is the snake_case string.
     * @return string in camelCase.
     */

    public static String snakeCaseToCamelCase(String input) {
        if (input == null) {
            return null;
        }

        if (input.isEmpty()) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        boolean toUpperCase = false;

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);
            if (ch == '_') {
                toUpperCase = true;
            } else {
                if (toUpperCase && i != 0) {
                    sb.append(Character.toUpperCase(ch));
                    toUpperCase = false;
                } else {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    /**
     * Reverse a string by words
     * @param input string
     * @return a string with words. Add full stop to the end.
     */

    public static String reverseSentenceWithPunctuation(String input) {
        if (input == null) {
            return null;
        }

        // Remove all punctuation and trim
        input = input.replaceAll("[^a-zA-Z\\s]", "").trim();
        if (input.isEmpty()) {
            return input;
        }

        // Split by one or more whitespace characters
        String[] words = input.split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }

    /**
     * Count occurances of a pattern in an input text
     * @param input string - the user input
     * @param pattern string - what the user want to count
     * @return int how many times is has occured.
     */

    public static int countOccurences(String input, String pattern){
        int counts = 0;

        if (input == null || pattern == null || input.isEmpty() || pattern.isEmpty()) {
            return 0;
        }

        int index = 0;
        while ((index = input.indexOf(pattern, index)) != -1) {
            counts++;
            index += pattern.length();
        }


        return counts;
    }

    /**
     * Password checkers - ensure there's at least one lowercase, one uppercase, one symbol and length
     * @param input String - user input password
     * @param lowerCase boolean -  at least one lowercase character
     * @param upperCase boolean - at least one uppercase character
     * @param symbol boolean - at least one special symbol
     * @param length int - minimum length or longer
     * @return boolean whether the input string meets all the criteria
     */

    public static boolean passwordChecker (String input, boolean lowerCase, boolean upperCase, boolean symbol, int length){
        if (input == null || input.length() < length) {
            return false;
        }

        boolean hasLowerCase = !lowerCase;
        boolean hasUpperCase = !upperCase;
        boolean hasSymbol = !symbol;

        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSymbol = true;
            }

            if (hasLowerCase && hasUpperCase && hasSymbol) {
                return true;
            }
        }

        return hasLowerCase && hasUpperCase && hasSymbol;

    }



}
