// Sum of Arithmetic progression: n(a_1 + a_n)/2
// for this problem => x(1+x)/2 <= n, where x is the maximum possible value that satisfy this inequality
// => x^2 + x <= 2n
// => x^2 + x + 0.5^2 - 0.5^2 <= 2n
// => (x+0.5)^2 - 0.25 <= 2n
// => x + 0.5 <= sqrt(2n + 0.25)
// => x <= sqrt(2n + 0.25) - 0.5
class Solution{
    public int arrangeCoins(int n){
        // conver n to (long) to avoid overflow
        return (int) (Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }
}
// naive method
//class Solution {
    //public int arrangeCoins(int n) {
        //int i = 0;
        //while(n-(i+1)>=0){
            //n-=i+1;
            //i++;
        //}
        //return i;
    //}
//}
