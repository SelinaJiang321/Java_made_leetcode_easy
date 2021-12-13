/*
Given a positive integer n, you can apply one of the following operations:

If n is even, replace n with n / 2.
If n is odd, replace n with either n + 1 or n - 1.
Return the minimum number of operations needed for n to become 1.

 

Example 1:

Input: n = 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1
Example 2:

Input: n = 7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1
Example 3:

Input: n = 4
Output: 2
 

Constraints:

1 <= n <= 231 - 1

*/

class Solution {
    public int maxRotateFunction(int[] nums) {
        // consider example 1: nums=[4,3,2,6]
        //Let n be length of nums
        // writing f(0) and rearranging f(1) the subtracting f(0) from f(1) we observe 
        // f(0)=(0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 25
        // f(1)=(1 * 4) + (2 * 3) + (3 * 2) + (0 * 6) = 16
        // f(1) - f(0)=(4(1-0) + 3(2-1) + 2(3-2)) - 6*3
        //            =((4+3+2+6)-f(n-1)) -nums[n-1]*(n-1);
        // f(1) = f(0) + sum(nums[]) - nums[n - 1]*n
        // similarly f(i) = f(i-1) + sum(nums[]) - nums[n-i]*n (Try by finding f(2) - f(1))
        
        int n=nums.length;
        int f0=0;
        int sum=0;
        for(int i=0;i<n;i++){
            f0+=i*nums[i];
            sum+=nums[i];
        }
        int ans=f0;
        int fimin1=f0; //(f(i-1))
        for(int i=1;i<n;i++){
            int fi = fimin1 + sum - nums[n-i]*n;
            ans=Math.max(ans,fi);
            fimin1=fi;
        }
        return ans;
        
    }
}
