/*
You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:

If nums[i] is positive, move nums[i] steps forward, and
If nums[i] is negative, move nums[i] steps backward.
Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.

A cycle in the array consists of a sequence of indices seq of length k where:

Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
Every nums[seq[j]] is either all positive or all negative.
k > 1
Return true if there is a cycle in nums, or false otherwise.

 

Example 1:

Input: nums = [2,-1,1,2,2]
Output: true
Explanation:
There is a cycle from index 0 -> 2 -> 3 -> 0 -> ...
The cycle's length is 3.
Example 2:

Input: nums = [-1,2]
Output: false
Explanation:
The sequence from index 1 -> 1 -> 1 -> ... is not a cycle because the sequence's length is 1.
By definition the sequence's length must be strictly greater than 1 to be a cycle.
Example 3:

Input: nums = [-2,1,-1,-2,-2]
Output: false
Explanation:
The sequence from index 1 -> 2 -> 1 -> ... is not a cycle because nums[1] is positive, but nums[2] is negative.
Every nums[seq[j]] must be either all positive or all negative.
 

Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
nums[i] != 0
 

Follow up: Could you solve it in O(n) time complexity and O(1) extra space complexity?

*/

class Solution {
    int len;
    private int advance(int[]nums, int i) {
        i += nums[i];
        while (i < 0) {
            i = i + nums.length;
        }
       
        if (i > nums.length - 1) i = i % nums.length;
        return i;
    }
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        len = nums.length;
         /**
         * Check every possible start location.
         * We may start at a short-loop, for instance, but the Array
         * may still contain a valid loop.
         */
        for (int i = 0; i < len; i++) {
            /**
             * We set elements to 0 which are on known non-loop paths.
             * So, if we encounter a 0, we know we're not on a loop path.
             * So, move to the next start location in the list.
             */
            if (nums[i] == 0) continue;
            
            // Stagger our starts, so we don't conclude we've found a loop,
            // as we might otherwise when slow == fast.
            int slow = i, fast = advance(nums, slow);
            
            while (nums[i] * nums[fast] > 0 && nums[fast] * nums[advance(nums,fast)] > 0) {
                if (slow == fast) {
                    if (slow == advance(nums, slow)) break; // one element
                
                return true;
                }
                slow = advance(nums, slow);
                fast = advance(nums, advance(nums,fast));
            }
             /**
             * If we're here, we didn't find a loop, so we know this path
             * doesn't have a loop, so we re-traverse it until we reverse
             * direction or encounter a '0' element.
             * During the re-traverse, we set each element we see to 0.
             */
            slow = i;
            int sgn = nums[i];
            while (sgn * nums[slow] > 0) {
                int tmp = advance(nums, slow);
                nums[slow] = 0;
                slow = tmp;
            }
        
        }
        return false;
    }
}
