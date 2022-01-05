/*

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
*/

class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('i');
        set.add('o');
        set.add('e');
        set.add('u');
        
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                curr++;
            }
            
            if (i >= k  && set.contains(s.charAt(i-k))) {
                //move right a character
                curr--;
            }
            ans = Math.max(ans, curr);
        
        }
        return ans;
        
    }
}
