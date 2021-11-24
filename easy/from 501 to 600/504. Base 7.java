/*
Given an integer num, return a string of its base 7 representation.

 

Example 1:

Input: num = 100
Output: "202"
Example 2:

Input: num = -7
Output: "-10"
 

Constraints:

-107 <= num <= 107

*/

class Solution {
    public String convertToBase7(int num) {
        char sign = '+';
        if (num < 0) {
            sign = '-';
            num *= -1;
        }
        
        if (num == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        
        while (num != 0) {
            res.append(num % 7);
            num /= 7;
        }
        
        if (sign == '-') res.append('-');
        
        return res.reverse().toString();
        
    }
}
