/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 

Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int count = s.length();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int flag = -1;
        for (int i = 0; i < sChar.length; i++) {
            for (int j = flag + 1; j < tChar.length;j++) {
                if (sChar[i] == tChar[j]) {
                    flag = j;
                    count--;
                    break;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }
  
  // straight forward->two pointers
  
  if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }
}
