/*
Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.

An integer m is a divisor of n if there exists an integer k such that n = k * m.

 

Example 1:

Input: n = 2
Output: false
Explantion: 2 has only two divisors: 1 and 2.
Example 2:

Input: n = 4
Output: true
Explantion: 4 has three divisors: 1, 2, and 4.
 

Constraints:

1 <= n <= 104
*/

class Solution {
    public boolean isThree(int n) {
        int count = 0;
        double root = (Math.sqrt(n));
        for (int i = 1; i <= root; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count +=1;
                } else {
                    count += 2;
                }
            }
        }
        
        if (count == 3) {
            return true;
        }
        return false;
        
    }
}

Intersting discussion:
f you observe this closely, the numbers having exact 3 divisors are those which are a perfect square of a prime number.
So the task is to find :
i. If n is a perfect square
ii. If the square root of n is a prime number
Also I am iterating to n.pow(1/4) times.
For ex.
to find 16 or less, it will loop 2 times
to find 81 or less, it will loop 3 times

and so on and so forth..
Thats it.

	public boolean isThree(int n) {
		if(n < 4) return false;
		int root = (int)Math.sqrt(n);
		if(root * root < n) return false;
		for(int i = 2 ; i <= Math.sqrt(root) ; i++) {
			if(root % i == 0) return false;
		}
		return true;
	}
