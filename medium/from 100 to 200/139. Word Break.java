/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] subString  = new boolean[s.length()+1];
        subString[0] = true;
        
        // we loop through from the first letter to the last letter in the string
        // base case is s.charAt(0)
        // we need to go to the last letter
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (subString[j] && wordDict.contains(s.substring(j,i))){
                    subString[i] = true;
                    break;
                }
            }
        }
        return subString[s.length()];
    }
    
}
