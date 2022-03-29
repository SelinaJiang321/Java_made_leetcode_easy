//version 1

class Solution {
    public int trap(int[] heights) {
        if (heights.length == 0) return 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        
        left[0] = 0;
        int curr = heights[0];
        for (int i = 1; i < left.length; i++) {
            left[i] = curr;
            curr = Math.max(curr, heights[i]);
        }
        
        right[heights.length-1] = 0;
        curr = heights[heights.length-1];
        
        for (int i = right.length -1; i >= 0; i--) {
            right[i] = curr;
            curr = Math.max(heights[i],curr);
        }
        int result = 0;
        for (int j = 0; j < heights.length; j++) {
            result += Math.max(Math.min(left[j],right[j]) - heights[j],0);
        }
        return result;
    }
}

//version 2
public int trap(int[] height) {
        int n=height.length;
        if(n<3) {
            return 0;
        }
        int lmax=height[0];
        int rmax=height[n-1];
        int l=0;
        int r=height.length-1;
        int water=0;
        while(l<r) {
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);
            if(lmax<rmax) {
                water+=lmax-height[l];
                l++;
            } else {
                water+=rmax-height[r];
                r--;
            }
        }
        return water;
    }
