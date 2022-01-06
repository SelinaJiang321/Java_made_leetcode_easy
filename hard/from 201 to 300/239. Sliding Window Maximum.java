/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length

*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = k-1;
        List<Integer> res = new ArrayList<Integer>();
        int curr = 0;
        int i = 0;
        if (k == 1) {
            for (int m= 0;m < nums.length; m++) {
                res.add(nums[m]);
                
            }
            return toIntArray(res);
        }
        while (i <= right) {
            curr = Math.max(curr, nums[i]);
            i++;
        }
        res.add(curr);
        
            
        left++;
        right++;
        while (right < nums.length) {
            curr = 0;
            for (int m = left; m <= right; m++) {
                 curr = Math.max(curr, nums[m]);
            }
            
            left++;
            right++;
            res.add(curr);
        }
//         Integer[] arr = new Integer[res.size()];
        
//         return res.toArray(arr);
        
        int[] ret = new int[res.size()];
        int j= 0;
        for (Integer e: res)
        ret[j++]= e;
    return ret;
        // return Ints.toArray(res);
        
        
    }
    
    int[] toIntArray(List<Integer> list)  {
    int[] ret = new int[list.size()];
    int i = 0;
    for (Integer e : list)  
        ret[i++] = e;
    return ret;
}
}
