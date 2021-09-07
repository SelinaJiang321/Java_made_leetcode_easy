/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.

*/


class Solution {
    public String reverseVowels(String s) {
        ArrayList<String> vowels = new ArrayList<>();
        String[] chars = s.split("");
        int count = 0;
        for(int i = 0; i < s.length();i++){
            if (chars[i].equals("a") || chars[i].equals("e")|| chars[i].equals("i") || chars[i].equals("o") || chars[i].equals("u") || chars[i].equals("A") || chars[i].equals("E")|| chars[i].equals("I") || chars[i].equals("O") || chars[i].equals("U") ) {
                vowels.add(chars[i]);
                System.out.println(chars[i]);
            }
        }
        
        Collections.reverse(vowels);
        for (int i = 0; i < s.length(); i++) {
            if (chars[i].equals("a") || chars[i].equals("e")|| chars[i].equals("i") || chars[i].equals("o") || chars[i].equals("u")|| chars[i].equals("A") || chars[i].equals("E")|| chars[i].equals("I") || chars[i].equals("O") || chars[i].equals("U")) {
                chars[i] = vowels.get(count);
                count++;
            }
            
        }
        
        return String.join("",chars);
    }
}

//standard two-pointer problem->start and end
public class Solution {
static final String vowels = "aeiouAEIOU";
public String reverseVowels(String s) {
    int first = 0, last = s.length() - 1;
    char[] array = s.toCharArray();
    while(first < last){
        while(first < last && vowels.indexOf(array[first]) == -1){
            first++;
        }
        while(first < last && vowels.indexOf(array[last]) == -1){
            last--;
        }
        char temp = array[first];
        array[first] = array[last];
        array[last] = temp;
        first++;
        last--;
    }
    return new String(array);
}
}
