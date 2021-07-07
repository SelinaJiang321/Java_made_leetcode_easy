/*

Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

Return the power of the string.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1
 

Constraints:

1 <= s.length <= 500
s contains only lowercase English letters.


*/

class Solution {
    public int maxPower(String s) {
        //two pointers approach
        if (s.length() == 1) return 1;
        int currentCount = 0;
        int maxCount = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end)) {
                currentCount ++;
            } else {
                //move the second pointer as the end
                start = end;
                //set to default
                currentCount = 1;
            }
            maxCount = Math.max(maxCount,currentCount);
            
        }
        return maxCount;
        
    }
}
