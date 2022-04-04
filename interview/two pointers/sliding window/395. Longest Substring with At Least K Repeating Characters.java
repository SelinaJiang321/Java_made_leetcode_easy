/*


Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

 

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105


*/

class Solution {
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map = getCharCounter(s);
        
        int left = 0;
        int longest = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.get(s.charAt(right)) < k) {
                int substring = longestSubstring(s.substring(left,right),k);
                longest = Math.max(substring, longest);
                left = right + 1;

            }
        }
        
        
        
        if (left == 0) return s.length();
        int sub_longest = longestSubstring(s.substring(left, s.length()), k);
        longest = Math.max(longest, sub_longest);
        return longest;
        
    }
    
    private  HashMap<Character, Integer> getCharCounter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            int val = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i), val+1);
        }
        
        return map;
    }
}
