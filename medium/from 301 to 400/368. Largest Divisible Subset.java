/*

Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int dp[] =   new int[nums.length];
        int prev[] =  new int[nums.length];
        Arrays.sort(nums);
        int maxlen = 0,end = 0, n =  nums.length;
        for(int i=0;i<n;i++){
            int count  =  1;
            int previdx = -1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0 && dp[j]+1>count ){
                    count =  dp[j]+1;
                    previdx = j;                    
                }
            }
            dp[i] = count;
            prev[i] = previdx;
            
            if(dp[i]>maxlen){
                maxlen =  dp[i];
                end =  i;
            }                        
        }
        ArrayList<Integer> ans =  new ArrayList<Integer>();
        while(end!=-1){
            ans.add(nums[end]);
            end =  prev[end];
        }
        
        return ans;
        
    }
}
