package com.algorithm.palindrome;

/**
 * Five Dwarves ( Gimli Fili Ilif Ilmig and Mark) met at the Prancing Pony and
 * played a word game to determine which combinations of their names resulted in
 * a palindrome. Write a program in that prints out all of those combinations.
 */

/**
 * Created by shivendrasrivastava on 3/3/17.
 */
public class Palindrome {

    /**
     *
     * @param word
     */
    public static void findPalindrome(String word)
    {
        String prefix = "";
        word = word.toLowerCase();
        System.out.println(" Finding palindromes for "+word);
        permuteWord(prefix, word);
    }

    /**
     * Permutations of the word
     * @param prefix
     * @param word
     */
    private static void permuteWord(String prefix, String word)
    {
        if (isPalindrome(word))
        {
            System.out.println(" Palindrome :- "+word);
        }
        int length = word.length();
        for (int i=0; i<length; i++)
        {
            permuteWord(prefix + word.charAt(i), word.substring(0, i) + word.substring(i+1, length));
        }
    }

    /**
     * Checks if the string is palindrome or not
     * @param word
     * @return
     */
    private static Boolean isPalindrome(String word)
    {
        word = word.toLowerCase();
        char[] chars= word.toCharArray();

        if (chars.length <= 2)
        {
            return Boolean.FALSE;
        }
        int forward = 0;
        int backward = chars.length - 1;

        while (backward > forward)
        {
            if (chars[forward] != chars[backward])
            {
                return Boolean.FALSE;
            }
            ++forward;
            --backward;
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args)
    {
        findPalindrome("Shivendra");
        findPalindrome("Madam");
        findPalindrome("Gimli");
        findPalindrome("Fili");
        findPalindrome("Ilif");
        findPalindrome("Ilmig");
        findPalindrome("Mark");
    }
}
