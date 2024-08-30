class Solution {
    public int solution(int n, int[] stations, int w) {
        int length = 2 * w + 1;
        int count = 0;
        int start = 1;
        for(int i = 0; i < stations.length; i++) {
            int station = stations[i];
            
            if(start < station - w) {
                count += (station - w - start - 1) / length;
                count++;
            }
            
            start = station + w + 1;
        }
        
        if(start <= n) {
            count += (n - start - 1) / length;
            count++;
        }
        
        return count;
    }
}
