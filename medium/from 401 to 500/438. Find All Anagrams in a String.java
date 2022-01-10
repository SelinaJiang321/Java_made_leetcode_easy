/*

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) 
            return list;
        int[]  res  = new int[256];
        
        for (char c: p.toCharArray()) {
            res[c]++;
        }
        
        //initialize the two pointers
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()){
            if (res[s.charAt(right)] >=1 ) {
                count--;
            }
            res[s.charAt(right)] --;
            right++;
            if (count == 0) {
                // we found the head
                list.add (left);
            }    
            // condition when we need to move the left pointer
            if (right - left == p.length()) {
                if (res[s.charAt(left)] >= 0) {
                    count++;
                }
                res[s.charAt(left)]++;
                left++;
                
            }
        }
        
        return list;
    }
}
