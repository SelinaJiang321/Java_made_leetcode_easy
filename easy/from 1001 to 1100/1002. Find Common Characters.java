/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.

*/

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        // Common characters dictionary
        int[] dict = new int[26];
        for (int j = 0; j < words[0].length(); j++) {
            dict[words[0].charAt(j) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            // Dictionary of the current word
            int[] curr = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                curr[words[i].charAt(j) - 'a']++;
            }
            // Update the common dictionary
            for (int j = 0; j < 26; j++) {
                if (curr[j] < dict[j]) dict[j] = curr[j];
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < dict[i]; j++) {
                ans.add(Character.toString((char) ('a' + i)));
            }
        }
        return ans;
        
    }
}
