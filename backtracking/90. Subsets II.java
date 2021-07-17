/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10

*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currSubsets = new ArrayList<>();
        
        subsetWithDup(subsets,currSubsets,nums,0);
        return subsets;
        
    }
    
    private void subsetWithDup(List<List<Integer>> subsets, List<Integer>curr, int[] nums, int index) {
        //add current subset
        subsets.add(new ArrayList<>(curr));
        
        for (int i = index; i < nums.length;i++) {
            //check duplicates
            if (i != index && nums[i] == nums[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            subsetWithDup(subsets,curr,nums,i+1);
            //remove the tracking elements
            curr.remove(curr.size() - 1);
        }
    }
}
