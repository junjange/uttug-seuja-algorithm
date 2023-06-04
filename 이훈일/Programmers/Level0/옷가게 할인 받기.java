import java.lang.Math;
class Solution {
    public int solution(int price) {
        double d_price = (double) price;
        if (500000 <= d_price) {
            d_price = d_price - d_price/5;
        } else if (300000 <= d_price) {
            d_price = d_price - d_price/10;
        } else if (100000 <= d_price) {
            d_price = d_price - d_price/20;
        }
        return (int)Math.floor(d_price);
    }
}
