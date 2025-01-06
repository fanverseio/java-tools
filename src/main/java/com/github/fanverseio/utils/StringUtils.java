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
        if (input == null) return false;
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    };

    /**
     * Length of Substring without repeating characters.
     * @param input the string to check.
     * @return integer of the length of the substring
     */

    public static int lengthOfSubstring(String input){

        if (input == null){
            return 0;
        }
        int i =0;
        int j =0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet();

        while (j<input.length()){
            if (!hashSet.contains(input.charAt(j))){
                hashSet.add(input.charAt(j));
                j++;
                max = Math.max(hashSet.size(),max);
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

    public static String increasingDecreasing(String input){
        if (input == null ) {
            return null;
        }

        if (input.isEmpty()){
            return input;
        }

        StringBuilder sb = new StringBuilder(input.length());

        int[] charList = new int[26];

        for (char c: input.toCharArray()){
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

        while (sb.length() < input.length()){

            if (ascending){

                for (int i = 0; i < 26; i++){
                    if (charList[i] > 0){
                        sb.append((char)(i + 'a'));
                        charList[i]--;
                    }
                }
            }
            else{

                for (int i = 25; i >= 0; i--){
                    if (charList[i] > 0){
                        sb.append((char)(i + 'a'));
                        charList[i]--;
                    }
                }
            }


            ascending = !ascending;
        }

        return sb.toString();


    };

}
