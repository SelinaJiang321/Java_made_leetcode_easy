/*

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //still need to handle edge cases
        if (nums == null || nums.length <3) return -1;
        Arrays.sort(nums);
        int res = nums[0] + nums[1]+ nums[2];
        
        for (int i = 0; i < nums.length -2; i++) {
            int start = i +1;
            int end = nums.length -1;
            while (start < end) {
                int currSum = nums[i] + nums[start] + nums[end];
            
                if (Math.abs(target - currSum) < Math.abs(target - res)) {
                    res = currSum;
                }
                if (currSum < target) start++;
                else {
                    end--;
                }
            }
        }
        
        return res;
    }
}
