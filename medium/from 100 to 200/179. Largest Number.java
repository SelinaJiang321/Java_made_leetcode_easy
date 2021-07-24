/*
Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
Example 3:

Input: nums = [1]
Output: "1"
Example 4:

Input: nums = [10]
Output: "10"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109

*/

class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) return "";
        
        Comparator<String>comp = new Comparator<String>() {
            @Override
            public int compare (String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        
        };
            
            //covert int array into string array since we want to return a result of string
            String[] s_num = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                s_num[i] = String.valueOf(nums[i]);
            }
            
        Arrays.sort(s_num,comp);
        if (s_num[0].charAt(0) == '0') return "0";
        
        //create a string builder since we always need to change the length of the string
        //String builder /string buffer and string
        StringBuilder sb = new StringBuilder();
        for (String s : s_num) {
            sb.append(s);
        }    
        return sb.toString();
    }
}
