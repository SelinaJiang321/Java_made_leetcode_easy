/*


Given an integer n, return the number of trailing zeroes in n!.

Follow up: Could you write a solution that works in logarithmic time complexity?

 

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 104

*/

My method:

class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) {return 0;}
        //how many trailing zeroes depending on how many pairs of {2,5} there are
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(5,0);
        map.put(2,0);
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                int res = (int) (Math.log(i)/Math.log(5));
                int val = map.get(5);
                map.put(5,val+res);
                System.out.println("5 " + i + map.get(5));
            } else if (i % 2 == 0) {
                int res = (int) (Math.log(i)/Math.log(2));
                int val = map.get(2);
                map.put(2,val+res);
                System.out.println(" 2 haha" +map.get(2));
            }
        }
        
        int zeroes = Math.min(map.get(2),map.get(5));
                    
        return zeroes;
                       
    }
}
// problem with this is that like 30, it is only has got one 5, but log(n) will lead to 2
// a better solution here is : since we need to return the smaller number of the 5s and 2s, since there is always more 2 than 5, we only need to count how many 5
// s there are
// Thus, we can just accumulate the number of 5s

class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while(n>0){
            cnt += n/5;
            n/=5;
        }
        return cnt;
    }
}
