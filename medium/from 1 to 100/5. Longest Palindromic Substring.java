/*

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
Accepted
1,722,871
Submissions
5,434,774


*/

class Solution {
    public String longestPalindrome(String s) {
        char[] sChar = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expandCenter(i,i,sChar),expandCenter(i,i+1,sChar));
            if (len > end - start +1) {
                start = i - (len-1) /2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
        
    }
    public int expandCenter(int i, int j, char[] sChar) {
        while (i >= 0 && j < sChar.length && sChar[i] == sChar[j]) {
            i--;
            j++;
        }
        return j - i -1;
    }
}
