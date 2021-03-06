/*

Given an array of string words. Return all strings in words which is substring of another word in any order. 

String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].

 

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
It's guaranteed that words[i] will be unique.

*/

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0) {
            return res;
        }
        
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        
        for(int i=0; i<words.length-1; i++) {
            for(int j=i+1; j<words.length; j++) {
                int idx = words[j].indexOf(words[i]);
                if(idx != -1) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
        
    }
}
