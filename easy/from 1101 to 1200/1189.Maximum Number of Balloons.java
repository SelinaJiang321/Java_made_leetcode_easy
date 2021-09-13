/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 104
text consists of lower case English letters only.

*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        String[] chars = text.split("");
        HashMap<String, Integer> words = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!words.containsKey(chars[i])){
                words.put(chars[i],1);
            } else{
                int count = words.get(chars[i]);
                words.put(chars[i],count+1);
            }
        }
        
        int b = -1;
        int a = -1;
        int l = -1;
        int o = -1;
        int n = -1;
        
        for (String key: words.keySet()) {
            if (key.equals("b")) {
                b = words.get(key);
            }
            if (key.equals("a")) {
                a = words.get(key);
            }
            if (key.equals("l")) {
                l = words.get(key);
            }
            if (key.equals("o")) {
                o = words.get(key);
            }
            if (key.equals("n")) {
                n = words.get(key);
            }
        }
        int count = Math.min(b, Math.min(a, Math.min(l, Math.min(o,n))));
        while (count >= 0){
            if (l < 2 * count || o < 2 * count){
                count--;
            } else {
                break;
            }
        }
        if (count == -1){
            return 0;
        } 
        return count;
    }
}
