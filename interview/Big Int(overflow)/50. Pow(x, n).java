class Solution {
    public double myPow(double x, int n) {
        boolean isNegative = false;
        double res = 1;
        if ( n < 0) {
            isNegative = true;
            n = -(n+1);
            x = 1/x;
        }
        double temp = x;
        while (n!= 0 ) {
            if (n % 2 ==1) {
                res *= temp;
                
            }
            temp *= temp;
            n /= 2;
        }
        if (isNegative) {
            res *= x;
        }
        return res;
    }
}
