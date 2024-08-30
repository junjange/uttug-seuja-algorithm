class Solution {
    public long solution(int r1, int r2) {
        long count = 0;
        for(int x = 1; x <= r2; x++) {
            long r2Y = (long) Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            long r1Y = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));
            count += r2Y - r1Y + 1;
        }
        
        return count * 4;
    }
}
