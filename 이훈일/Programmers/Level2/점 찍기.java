class Solution {
    public long solution(int k, int d) {
        long count = 0;
        for(int x = 0; x <= d; x += k) {
            int y = (int) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            count += y / k + 1;
        }
        
        return count;
    }
}
