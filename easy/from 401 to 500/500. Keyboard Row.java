/*
Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".
*/

class Solution {
    public String[] findWords(String[] words) {
        String[] strs = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        List<String> results = new ArrayList();
        
        for (String word: words){
            int count1 = 0, count2 = 0, count3 = 0;
            for (char c : word.toCharArray()) {
                if (strs[0].indexOf(c) != -1) {
                    count1++;
                }
                if (strs[1].indexOf(c) != -1) {
                    count2++;
                }
                if (strs[2].indexOf(c) != -1) {
                    count3++;
                }
            }
            if ((count1 == 0 && count2 == 0) || (count2 == 0 && count3 == 0) || (count1 == 0 && count3 == 0)) {
                results.add(word);
            }
        }
        
        return results.toArray(new String[results.size()]);
        
    }
}
