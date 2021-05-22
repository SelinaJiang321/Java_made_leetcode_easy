/*

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

 

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100

*/

class Solution {
    public int[] frequencySort(int[] nums) {
        	Map<Integer, Integer> map = new HashMap<>();
	// count frequency of each number
	Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
	// custom sort
	return Arrays.stream(nums).boxed()
			.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
			.mapToInt(n -> n)
			.toArray();
    }
}

/*
custom sort explanation:
.stream(nums)
iterates through the nums array

.boxed()
converts each int to Integer object, this is because .sorted() can only operate on objects

.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
if frequency of two numbers are not the same, sort by ascending frequency. If frequencies are the same, sort by decending numeric value

.mapToInt(n -> n)
converts Integer to int

.toArray()
returns array


*/
