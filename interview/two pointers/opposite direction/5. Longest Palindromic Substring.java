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

*/

class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        //check dege cases
        if (s.length() == 0 || s == null) return res;
        //the smallest possibility
        res += s.charAt(0);
        // check from the center
        for (int i = 1; i < s.length(); i++) {
            String a = checkSubString(s,i, i);
            String b = checkSubString(s,i-1,i);
            if (a.length() > res.length()) {
                res = a;
            } 
            if (b.length() > res.length()) {
                res = b;
            }
        }
        return res;
    }
    
    public String checkSubString(String s, int left, int right){
        while (left >=0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(++left,right);
    }
}
