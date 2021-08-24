/*
A complex number can be represented as a string on the form "real+imaginaryi" where:

real is the real part and is an integer in the range [-100, 100].
imaginary is the imaginary part and is an integer in the range [-100, 100].
i2 == -1.
Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

 

Example 1:

Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:

Input: num1 = "1+-1i", num2 = "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 

Constraints:

num1 and num2 are valid complex numbers.


*/

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        //to escape the character +
        String[] x = num1.split("\\+");
        String[] y = num2.split("\\+");
        int aInt = Integer.parseInt(x[0]);
        int bInt = Integer.parseInt(y[0]);
        int aIma = Integer.parseInt(x[1].replace("i",""));
        int bIma = Integer.parseInt(y[1].replace("i",""));
        int a = aInt * bInt;
        int b = aIma * bIma;
        int comp = aInt * bIma  + bInt * aIma;
        
        String real = a-b + "";
        String ima = comp +"i";
        return real + "+" + ima;
        
    }
}
