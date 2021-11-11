/*
Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.

 

Example 1:

Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
                step by step sum
                startValue = 4 | startValue = 5 | nums
                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
Example 2:

Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive. 
Example 3:

Input: nums = [1,-2,-3]
Output: 5
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100

*/

class Solution {
    public int minStartValue(int[] nums) {
        // Let n be the length of the array "nums", m be the absolute value 
        // of the lower boundary of the element. In this question we have m = 100.
        int n = nums.length;
        int m = 100;

        // Set left and right boundaries according to left = 1, right = m * n + 1.
        int left = 1;
        int right = m * n + 1;

        while (left < right) {
            // Get the middle index "middle" of the two boundaries, let the start value 
            // be "middle". The initial step-by-step total "total" equals to middle as well.
            // Use boolean parameter "isValid" to record whether the total 
            // is greater than or equal to 1.
            int middle = (left + right) / 2;
            int total = middle;
            boolean isValid = true;

            // Iterate over the array "nums".
            for (int num : nums) {

                // In each iteration, calculate "total" plus the element "num" in the array.
                total += num;

                // If "total" is less than 1, we shall try a larger start value,
                // we mark "isValid" as "false" and break the current iteration.
                if (total < 1) {
                    isValid = false;
                    break;
                }
            }

            // Check if middle is valid, and reduce the search space by half.
            if (isValid) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // When the left and right boundaries coincide, we have found
        // the target value, that is, the minimum valid startValue.
        return left;
    }
}
