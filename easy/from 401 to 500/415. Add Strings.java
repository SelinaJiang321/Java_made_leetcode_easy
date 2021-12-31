/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
 

Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.
*/

class Solution {
    public String addStrings(String num1, String num2) {
        //two counter
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        //allocate a new String
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while (i>=0 || j >=0 || carry > 0) {
            int n1 = 0;
            int n2 = 0;
            if (i >= 0) {
                //get the integer
                n1 = num1.charAt(i) - '0';
                i --;
            }
            if (j >= 0) {
                n2 = num2.charAt(j) - '0';
                j --;
            }
            
            //get the remainder
            int tot = (n1+ n2 + carry) % 10;
            if (n1+ n2 + carry >= 10) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            //string builder can simply append an integer
            res.append(tot);
        }
        return res.reverse().toString();
    }
}
