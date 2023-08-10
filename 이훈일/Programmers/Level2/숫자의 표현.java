class Solution {
    public int solution(int n) {
        int result = 1;
        
        for(int i = 1; i <= n/2; i++) {
            int sum = 0;
            int num = i;
            
            while(sum < n) {
                sum += num++;
            }
    
            if(sum == n) {
                result++;
            }
        }
        
        return result;
    }
}
