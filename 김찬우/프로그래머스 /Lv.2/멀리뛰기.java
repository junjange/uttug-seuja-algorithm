class Solution {
    public long solution(int n) {
        
        int[] result = new int[2001];
        result[1] = 1;
        result[2] = 2;
        
        for(int i=3; i<=n;i++){
            
            result[i] = (result[i-1]+result[i-2])%1234567;
            
        }
        
        
        return result[n];
    }
}
