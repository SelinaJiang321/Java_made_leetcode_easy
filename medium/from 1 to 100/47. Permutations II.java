/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10

*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // a list to store all the results
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {return res;}
        // a boolean array to check which element has been used
        boolean[] used = new boolean[nums.length];
        List<Integer> lis = new ArrayList<Integer> ();
        //so we can get a sequential array list of integers
        Arrays.sort(nums);
        dfs(nums,res,used,lis);
        return (res);
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> lis) {
        if (lis.size() == nums.length) {
            res.add(new ArrayList<Integer> (lis));
            return;
        }
        for (int i = 0 ; i < nums.length; i++) {
            //already use this element
            if (used[i]) continue;
            // the previous element has not been used continue
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue; 
            used[i]= true;
            lis.add(nums[i]);
            dfs(nums,res,used,lis);
            //set to not used again for backtracking
            used[i] = false;
            // remove the last element for backtraking
            lis.remove(lis.size() - 1);
        }
    }
}
