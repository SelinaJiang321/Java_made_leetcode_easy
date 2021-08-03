/*

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.


*/

class Solution {
    public int countCharacters(String[] words, String chars) {
        //store the character just use int array
        int count = 0;
        int[] seen = new int[26];
        //change the string into a list of characters
        for (char c: chars.toCharArray()){
            seen[c - 'a']++;
        }
        
        //compare each word in words 
        for (String word: words) {
            //make a copy of seen so we can reuse it
            int[] cSeen = Arrays.copyOf(seen,seen.length);
            int cCount = 0;
            for(char c: word.toCharArray()){
                if (cSeen[c - 'a'] > 0) {
                    cSeen[c - 'a']--;
                    cCount++;
                }
                if (cCount == word.length() ) {
                    count = count + cCount;
                }
            }
            
        }
        return count;
    }    
}
