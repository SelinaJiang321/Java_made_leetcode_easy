/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 

Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation.
'-' could be used as a unary operation but it has to be inside parentheses.
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.

Principle:

(Sign before '+'/'-') = (This context sign);
(Sign after '+'/'-') = (This context sign) * (1 or -1);
Algorithm:

Start from +1 sign and scan s from left to right;
if c == digit: This number = Last digit * 10 + This digit;
if c == '+': Add num to result before this sign; This sign = Last context sign * 1; clear num;
if c == '-': Add num to result before this sign; This sign = Last context sign * -1; clear num;
if c == '(': Push this context sign to stack;
if c == ')': Pop this context and we come back to last context;
Add the last num. This is because we only add number after '+' / '-'.


*/

class Solution {
    public int calculate(String s) {
            if(s == null) return 0;
        
            int result = 0;
            int sign = 1;
            int num = 0;

            Stack<Integer> stack = new Stack<Integer>();
            stack.push(sign);

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(c >= '0' && c <= '9') {
                    num = num * 10 + (c - '0');

                } else if(c == '+' || c == '-') {
                    result += sign * num;
                    sign = stack.peek() * (c == '+' ? 1: -1); 
                    num = 0;

                } else if(c == '(') {
                    stack.push(sign);

                } else if(c == ')') {
                    stack.pop();
                }
            }

            result += sign * num;
            return result;
        
    }
}
