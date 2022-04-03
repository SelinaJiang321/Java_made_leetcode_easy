/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105


*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //try to handle edge cases first
        List<List<Integer>> res  = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2; i++) {
            //try to handle duplicates first
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            twoSums(i+1,nums.length-1,-nums[i],res,nums);
            
        }
        return res;
        
    }
    
    //write a two sum function to try
    public void twoSums(int left, int right, int target, List<List<Integer>> res,int[] nums) {
        //using two pointers here
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> curr = new ArrayList<>();
                curr.add(-target);
                curr.add(nums[left]);
                curr.add(nums[right]);
                res.add(curr);
                left++;
                right--;
                //try to skip duplicates
                while (left < right && nums[left] == nums[left-1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right+1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
           
        }
        
    }
    
    
}
