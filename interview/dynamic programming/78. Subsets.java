class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        //空集
        res.add(new ArrayList<Integer>());
        if (nums.length == 0)  return res;
        
        for (int i = 0; i < nums.length; i++) {
            helper(res,nums,i);
        }
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int index) {
        List<List<Integer>> lists = new ArrayList<>();
        
        for (int i = 0; i < res.size(); i++ ) {
            //deep copy
            List<Integer> curr = new ArrayList<Integer>(res.get(i));
            curr.add(nums[index]);
            lists.add(curr);
        }
        res.addAll(lists);
    }
}
