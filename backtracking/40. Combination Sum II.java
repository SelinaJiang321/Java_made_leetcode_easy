/*

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/

/*
next_curr > curr: we will pick the number at the current curr position into the combination, regardless the other conditions. 
This is important, since the iteration should allow us to select multiple instances of a unique number into the combination.

*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        
        Arrays.sort(candidates);
        
        backtrack(candidates,comb,target,0,results);
        return results;
        
    }
    
    private void backtrack(int[] candidates, LinkedList<Integer> comb, Integer remain, Integer curr, List<List<Integer>> results) {
        if (remain == 0) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int nextCurr = curr; nextCurr < candidates.length; nextCurr++) {
            if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1]) {
                continue;
            }
            Integer pick = candidates[nextCurr];
            if (remain - pick < 0 ){
                break;
            }
            
            comb.addLast(pick);
            backtrack(candidates,comb,remain-pick,nextCurr+1,results);
            //remove the last element of the linkedlist
            comb.removeLast();
        }
    }
}
