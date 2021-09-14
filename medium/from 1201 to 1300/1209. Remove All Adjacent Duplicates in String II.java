/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lower case English letters.

*/

class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Character> stack = new Stack();
        Stack<Integer> count = new Stack();
        
        for(char c:s.toCharArray()){
            
            if(!stack.isEmpty() && !count.isEmpty() && stack.peek() == c && count.peek() == k-1){
			
			//if the current character and the top char in stack are equal and the count of char is 
			// equal to k-1 then remove it from the stack and the count stack.
			
                while(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }
                count.pop();
            }else{
			
                int temp = 1;
				
				// for every character add it to the stack and see if the prev char is also same then update
				// count stack also . 
				
                if(!count.isEmpty() && stack.peek() == c){
                    temp += count.pop();
                }
                stack.push(c);
                count.push(temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
        
    }
}
