
/*
Iterative Top-Down Approach
Intuition

Let's get rid of the need to use all of that space and instead use the minimum amount of space required. We can achieve O(1)O(1) space complexity by only storing the value of the two previous numbers and updating them as we iterate to N.

Algorithm

Check if N <= 1, if it is then we should return N.
Check if N == 2, if it is then we should return 1 since N is 2 and fib(2-1) + fib(2-2) equals 1 + 0 = 1.
To use an iterative approach, we need at least 3 variables to store each state fib(N), fib(N-1) and fib(N-2).
Preset the initial values:
Initialize current with 0.
Initialize prev1 with 1, since this will represent fib(N-1) when computing the current value.
Initialize prev2 with 1, since this will represent fib(N-2) when computing the current value.
Iterate, incrementally by 1, all the way up to and including N. Starting at 3, since 0, 1 and 2 are pre-computed.
Set the current value to fib(N-1) + fib(N-2) because that is the value we are currently computing.
Set the prev2 value to fib(N-1).
Set the prev1 value to current_value.
When we reach N+1, we will exit the loop and return the previously set current value.

Complexity Analysis

Time complexity : O(N)O(N). Each value from 2 to N will be visited at least once. The time it takes to do this is directly proportionate to N where N is the Fibonacci Number we are looking to compute.

Space complexity : O(1)O(1). This requires 1 unit of Space for the integer N and 3 units of Space to store the computed values (curr, prev1 and prev2) for every loop iteration. The amount of Space doesn't change so this is constant Space complexity.
*/

class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        
        if (n == 2) {
            return 1;
        }
        
        int curr = 0;
        int prev1 = 1;
        int prev2 = 1;
        
        for (int i = 3; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return curr;
        
    }
}

// simple example by using memorization

class Solution {
    private Integer[] cache = new Integer[31];
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memorize(n);
    }
    
    public int memorize(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        
        cache[n] = memorize(n-1) + memorize(n-2);
        return memorize(n);
    }
}
