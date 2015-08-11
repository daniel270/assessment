package com.automation.generalProgramming;

import java.util.ArrayList;
import java.util.List;

public class AnagramTest {

  public static void main(String[] args) {
    String text1 = "Punishment";
    String text2 = "Nine Thumps";
    String text3 = "The Morse code";
    String text4 = "Here come dots";
    String text5 = "Snooze alarms";
    String text6 = "Alas! No more Zs";
    String text7 = "Halley's Comet";
    String text8 = "Shall yet come";
    String text9 = "One good turn deserves another.";
    String text10 = "Do rogues endorse that? No, never!";
    System.out.println(check_Strings_are_anagrams(text1, text2));
    System.out.println(check_Strings_are_anagrams(text3, text4));
    System.out.println(check_Strings_are_anagrams(text5, text6));
    System.out.println(check_Strings_are_anagrams(text7, text8));
    System.out.println(check_Strings_are_anagrams(text9, text10));
  }

  private static String check_Strings_are_anagrams(String value1, String value2) {

    char[] dataArray1 = value1.replaceAll("[\\s]", "").toLowerCase().toCharArray();
    char[] dataArray2 = value2.replaceAll("[\\s]", "").toLowerCase().toCharArray();
    List<Character> list = new ArrayList<>();

    for (int i = 0; i < dataArray1.length; i++) {
      list.add(dataArray1[i]);
    }
    for (int i = 0; i < dataArray2.length; i++) {
      if (list.contains(dataArray2[i])) {
        list.remove((Object) dataArray2[i]);
      }
      if (i == dataArray1.length - 1 && list.isEmpty()) {
        return "\"" + value1 + " -> " + value2 + "\" are anagrams of each other";
      }
    }
    return "\"" + value1 + " -> " + value2 + "\" are not anagrams of each other";
  }
}
