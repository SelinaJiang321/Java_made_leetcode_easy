/*

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.

*/

//my slow method
class Solution {
    public void sortColors(int[] nums) {
        // List res = new ArrayList();
        // res.add(0);
        // res.add(1);
        // res.add(2);
        int[] res = {0,1,2};
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != res[m]) {
                System.out.println("i" + i);
                int j = i + 1;
                int flag = -1;
                while (j < nums.length) {
                    if (nums[j] == res[m]) {
                        //swap the two elements
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    } else if (m < 3 && nums[j] == res[m+1]) {
                        flag = j;
                    }
                    //System.out.println("j" + j);
                    j++;
                }
                if (j == nums.length) {
                    //System.out.println("m " + m);
                    if (flag != -1) {
                        int temp = nums[i];
                        nums[i] = nums[flag];
                        nums[flag] = temp;
                    }
                    m++;  
                }  
            }
        }
        
    }
}

// one-pass : too much thinking
class Solution {
    public void sortColors(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                //if current is 0, swap with p1 pointer, increment p1
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                //if current is 2, swap with p2 pointer, decrement p2
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                //may have swapped an extra 0 from the end of array that requires extra processing, so decrement index to account for it
                index--;
            }
            //move to next index to make progress
            index++;
        }
    }
}

//two-pass: dumb but fast

public void sortColors(int[] nums) {
    // 2-pass
    int count0 = 0, count1 = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {count0++;}
        if (nums[i] == 1) {count1++;}
        if (nums[i] == 2) {count2++;}
    }
    for(int i = 0; i < nums.length; i++) {
        if (i < count0) {nums[i] = 0;}
        else if (i < count0 + count1) {nums[i] = 1;}
        else {nums[i] = 2;}
    }
}
