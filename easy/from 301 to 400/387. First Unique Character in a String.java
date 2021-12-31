/*

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.

*/

class Solution {
    public int firstUniqChar(String s) {
        HashMap<String,Integer> freq = new HashMap<>();
        String[] list = s.split("");
        for (String ele: list){
            if (!freq.containsKey(ele)){
                freq.put(ele,1);
            } else {
                int count = freq.get(ele);
                freq.put(ele, count+1);
            }
        }
        
        for (int i = 0; i < list.length; i++){
            if (freq.get(list[i]) == 1){
                return i;
            }
        }

        return -1;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        //Hashmap
        HashMap<Character, Integer> times = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int time = times.getOrDefault(s.charAt(i), 0);
            times.put(s.charAt(i), ++time);
        }
        
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            if (times.get(s.charAt(i)) == 1){
                res = i;
                break;
            }
            
        }
        return res;
            
            
        
    }
}
