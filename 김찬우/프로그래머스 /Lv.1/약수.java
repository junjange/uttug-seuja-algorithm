class Solution {
    public int solution(int n) {
        
        // 아이디어
        // 나누어 떨어질때 conunt
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            
            if(n%i == 0){
                answer+=i;
            }
        }
        
        return answer;
    }
}
