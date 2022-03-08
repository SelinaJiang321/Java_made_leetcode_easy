/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

*/

class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = left +1;
        while (right < nums.length) {
            if (nums[left] == 0 && nums[right] == 0) right++;
            
            else if (nums[right] == 0 && nums[left]!= 0) left++;
            else if (nums[left] == 0 && nums[right] != 0) {
                nums[left] = nums[right];
                nums[right] = 0;
            }
            else {
                left++;
                right++;
            }
        }
        
    }
}
