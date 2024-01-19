package com.example;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class TmpTest {
  @Test
  public void test() {
    Assertions.assertThat(new App().reorganizeString("")).isEqualTo("");
    Assertions.assertThat(new App().reorganizeString("aab")).isEqualTo("aba");
    Assertions.assertThat(new App().reorganizeString("aaab")).isEqualTo("");
    Assertions.assertThat(new App().reorganizeString("aaabb")).isEqualTo("ababa");
    Assertions.assertThat(new App().reorganizeString("aaabbb")).isEqualTo("ababab");
    Assertions.assertThat(new App().reorganizeString("vvvlo")).isEqualTo("vovlv");
    Assertions.assertThat(new App().reorganizeString("vvvvvlllo")).isEqualTo("vlvlvlvov");
    return;
  }

  @Test
  public void testLengthOfLongestSubstring() {
    Assertions.assertThat(new App().lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    Assertions.assertThat(new App().lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    Assertions.assertThat(new App().lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    Assertions.assertThat(new App().lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    Assertions.assertThat(new App().lengthOfLongestSubstring(" ")).isEqualTo(1);
    Assertions.assertThat(new App().lengthOfLongestSubstring("  ")).isEqualTo(1);
    Assertions.assertThat(new App().lengthOfLongestSubstring("xabcxabcdef")).isEqualTo(7);
    Assertions.assertThat(new App().lengthOfLongestSubstring("abcdef")).isEqualTo(6);
    Assertions.assertThat(new App().lengthOfLongestSubstring("xxxabcdef")).isEqualTo(7);
  }

  @Test
  public void testMaxLengthBetweenEqualCharacters() {
    Assertions.assertThat(new App().maxLengthBetweenEqualCharacters("abcabcbb")).isEqualTo(5);
    Assertions.assertThat(new App().maxLengthBetweenEqualCharacters("abcabc")).isEqualTo(2);
    Assertions.assertThat(new App().maxLengthBetweenEqualCharacters("abc")).isEqualTo(-1);
    Assertions.assertThat(new App().maxLengthBetweenEqualCharacters("aabc")).isEqualTo(0);
  }

  @Test
  public void testMergeAlternately() {
    Assertions.assertThat(new App().mergeAlternately("123", "456")).isEqualTo("142536");
    Assertions.assertThat(new App().mergeAlternately("123", "4567")).isEqualTo("1425367");
    Assertions.assertThat(new App().mergeAlternately("1234", "456")).isEqualTo("1425364");
    Assertions.assertThat(new App().mergeAlternately("12345", "456")).isEqualTo("14253645");
    Assertions.assertThat(new App().mergeAlternately("1", "456")).isEqualTo("1456");
    Assertions.assertThat(new App().mergeAlternately("1234", "5")).isEqualTo("15234");
    Assertions.assertThat(new App().mergeAlternately("", "")).isEqualTo("");
    Assertions.assertThat(new App().mergeAlternately("", "a")).isEqualTo("a");
    Assertions.assertThat(new App().mergeAlternately("a", "")).isEqualTo("a");
  }

  @Test
  public void testGcdOfStrings() {
    Assertions.assertThat(new App().gcdOfStrings("abc", "abcabc")).isEqualTo("abc");
    Assertions.assertThat(new App().gcdOfStrings("abcabcabcabc", "abcabc")).isEqualTo("abcabc");
    Assertions.assertThat(new App().gcdOfStrings("aaa", "a")).isEqualTo("a");
    Assertions.assertThat(new App().gcdOfStrings("aaaa", "bbbb")).isEqualTo("");
  }

}

