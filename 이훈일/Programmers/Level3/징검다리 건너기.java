class Solution {
    public int solution(int[] stones, int k) {
        int min = stones[0];
        int max = stones[0];
        for(int i = 1; i < stones.length; i++) {
            min = Math.min(min, stones[i]);
            max = Math.max(max, stones[i]);
        }
        
        while(min < max) {
            int mid = (min + max + 1)/2;
            if(isPossible(mid, stones, k)) {
                min = mid;
            }else {
                max = mid - 1;
            }
        }
        
        return max;
    }
    
    public Boolean isPossible(int mid, int[] stones, int k) {
        int count = 0;
        for(int stone : stones) {
            if(stone < mid) {
                count++;
            }else {
                count = 0;
            }
            if(count == k) {
                return false;
            }
        }
        return true;
    }
}
