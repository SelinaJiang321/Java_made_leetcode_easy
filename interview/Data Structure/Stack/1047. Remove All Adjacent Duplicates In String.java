class Solution {
    // because we need to remove characters after remove the last character, better to just use stack instead of two pointers
    public String removeDuplicates(String s) {
        Stack<Character> currStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!currStack.isEmpty() && currStack.peek() == s.charAt(i)) {currStack.pop();}
            else {
                currStack.push(s.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!currStack.isEmpty()) {
            sb.append(currStack.pop());
        }
        
        return sb.reverse().toString();
    } 
}
