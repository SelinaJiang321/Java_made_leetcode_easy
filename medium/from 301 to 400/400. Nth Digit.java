/*
Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].

 

Example 1:

Input: n = 3
Output: 3
Example 2:

Input: n = 11
Output: 0
Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 

Constraints:

1 <= n <= 231 - 1


*/

/*
1 ~ 9 include 9 one digit number;
10 ~ 99 include 90 two digits number;
100 ~ 999 include 900 three digits number;
1000 ~ 9999 include 9000 four digits number;
...

len is how many digits:1 or 2 or 3 ..., range is 9 or 90 or 900 ...

*/

class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        int i = 1;
        // use long since we have a range of the value
        long range = 9;
        while (n > range * len) {
            n -= range*len;
            len++;
            range *= 10;
            i *= 10;
            
        }
        
        i += (n-1) / len;
        String s = Integer.toString(i);
        return Character.getNumericValue(s.charAt((n - 1) % len));
        
        
    }
}
