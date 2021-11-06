/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

 

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
 

Constraints:

2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each integer in nums will appear twice, only two integers will appear once.

*/
class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int num: nums){
            if (res.containsKey(num)){
                res.put(num,res.get(num) + 1);
             }
            else {
                res.put(num,1);
            }
        }
        int[] re = new int[2];
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: res.entrySet()){
            if (entry.getValue() == 1) {
                re[count] = entry.getKey();
                count++;
            }
        }
        
        return re;
        
    }
}


Example

Let us use this input: nums = [1,2,1,3,2,5]
Since we will need the binary representation of each of these numbers, I have converted them here for simplicity [0x001, 0x010, 0x001, 0x011, 0x010, 0x101]

Now perform XOR each of these numbers:
aXORb = 1 ^ 2 ^ 1 ^ 3 ^ 2 ^ 5 = 0x110

In this aXORb rightmost set bit can be found by aXORb & -aXORb which will give us:
rightSetBit = 0x010;

In the second pass, we try to XOR all numbers that have this bit set to 1. There are total three such numbers: [2, 2, 3]. XOR of these numbers should give us 3. This can be assigned to A. To get B we can perform XOR of A and aXORb. In this example, aXORb ^ A = 0x110 ^ 0x011 = 0x101 (which is 5 in decimal).

Thus the output result is [3,5].

Time Complexity: O(2 * N) = O(N) --> Each number in the input array is visited twice.

Space Complexity: O(1) --> Uses constant auxiliary space.

class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2 || nums.length % 2 != 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int aXORb = 0;
        for (int n : nums) {
            aXORb ^= n;
        }

        int rightSetBit = aXORb & -aXORb;
        int a = 0;
        for (int n : nums) {
            if ((n & rightSetBit) != 0) {
                a ^= n;
            }
        }

        return new int[] {a, aXORb ^ a};
    }
}
