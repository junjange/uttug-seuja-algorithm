class Solution {
    public long solution(int w, int h) {
        double douW = (double) w;
        double douH = (double) h;
        long total = (long)w * (long)h;
        long count = 0;
        for(int i = 1; i <= w; i++) {    
            int preY = (int) Math.ceil(douH * (i-1) / douW * -1 + douH);
            int curY = (int) (douH * i / douW * -1 + douH);
            count += preY - curY;
        }
        
        return total - count;
    }
}
