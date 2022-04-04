class Solution {
    public int longestOnes(int[] nums, int k) {
        int counter = 0;
        int left = 0; 
        int longestlength = Integer.MIN_VALUE;
        for (int right = 0; right < nums.length; right++) {
            if ( nums[right] == 0) {
                counter++;
            }
            if (counter > k ) {
                if (nums[left] == 0) {
                    counter--;
                }
                left++;
            }
            longestlength = Math.max(longestlength, right-left+1);
        }
        return longestlength;
        
    }
}
