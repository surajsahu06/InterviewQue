/**
 * Write a method that modifies a string using the following rules:
 * <p>
 * 1. Each word in the input string is replaced with the following: the first letter of the word, the count of distinct
 * letters between the first and last letter, and the last letter of the word. For example, "Automotive" would be
 * replaced by "A6e".
 * <p>
 * 2. A "word" is defined as a sequence of alphabetic characters, delimited by any non-alphabetic characters.
 * <p>
 * 3. Any non-alphabetic character in the input string should appear in the output string in its original relative
 * location.
 */

package src;

import java.util.HashSet;
import java.util.Set;

public class InterviewTask {

  public static void main(String[] args) {
  }

  public String modifySentence(String sentenceToModify) {
    if (sentenceToModify == null) {
      System.out.println("No input sentence or words provided!");
      return null;
    }
    /* Save to a variable so that we have copy or original input */
    String modifiedSentence = sentenceToModify;
    /* split the sentence into words based on non alphabetic chars */
    String[] words = modifiedSentence.split("[^a-zA-Z']+");
    for (String word : words) {
      String updatedWord = modifySingleWord(word);
      modifiedSentence = modifiedSentence.replace(word, updatedWord);
    }
    System.out.println("Input :" + sentenceToModify + ", Output :" + modifiedSentence);
    return modifiedSentence;
  }

  private String modifySingleWord(String singleWord) {
    if (singleWord == null) {
      return "";
    }
    Integer length = singleWord.length();
    /* if the length is 2 we do not want to modify */
    if (length <= 2) {
      return singleWord;
    }
     /* keep track of first and last char of word */
    Character firstChar = singleWord.charAt(0);
    Character lastChar = singleWord.charAt(length - 1);

    String middleString = singleWord.substring(1, length - 1);

    Set<Character> characterSet = new HashSet<Character>();
    /* Add all the chars of word in characterSet except first and last char to count the unique chars */
    for (Character c : middleString.toCharArray()) {
      characterSet.add(c);
    }
    StringBuilder stringBuilder = new StringBuilder().append(firstChar).append(characterSet.size()).append(lastChar);
    return String.valueOf(stringBuilder);
  }
}
