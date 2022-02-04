/*

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 

Follow up: Could you solve the problem in linear time and in O(1) space?


*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length == 0) return res;
        int firstSum = 0; 
        int secondSum = 0;
        int firstMajor = Integer.MAX_VALUE;
        int secondMajor = Integer.MIN_VALUE;
        for (int i =0; i < nums.length; i++) {
            if (firstMajor == nums[i]) {
                firstSum++;
            }
            else if (secondMajor == nums[i]) {
                secondSum++;
            }
            else if (firstSum == 0) {
                firstMajor = nums[i];
                firstSum = 1;
            }
            else if (secondSum == 0) {
                secondMajor = nums[i];
                secondSum = 1;
            } else {
                firstSum--;
                secondSum --;
            }
            
        }
        

        firstSum = 0;
        secondSum = 0;
        //loop through again to check if the times
        for (int num: nums) {
            if (num == firstMajor) {
                firstSum++;
            }
            else if (num == secondMajor) {
                secondSum++;
            }
        }

        if (firstSum > nums.length/3) {
            res.add(firstMajor);
        }
        if (secondSum > nums.length/3) {
            res.add(secondMajor);
        }

        return res;
        
        
        
    }
}
