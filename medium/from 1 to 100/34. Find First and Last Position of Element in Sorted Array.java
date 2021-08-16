/*

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109


*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums,target);
        res[1] = findLast(nums, target);
        return res;
        
    }   
        
        
    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (target <= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            //update the smallest available spot
            if (nums[mid] == target) idx = mid;
        }
        return idx;
        
        
    }   
        
    private int findLast(int[] nums, int target) {
        
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (target >= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            //update the largest available spot
            if (nums[mid] == target) idx = mid;
        }
        return idx;
        
    }
}
