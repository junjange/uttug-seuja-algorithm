class Solution {
    
    public int[] solution(int n, long k) {
        long num = 1;
        for(int i = 1; i < n; i++) {
            num *= i;
        }
        
        k--;
        
        boolean[] visited = new boolean[n];
        int[] answer = new int[n];
        long quotient = k;
        for(int i = 0; i < n; i++) {
            if(i == n-1) {
                quotient = 0;
            } else {
                quotient = k / num;
                k = k % num;
                num /= (n-i-1);
            }
            
            long count = -1;
            for(int j = 0; j < n; j++) {
                if(!visited[j]) {
                    count++;
                }
                
                if(count == quotient) {
                    answer[i] = j + 1;
                    visited[j] = true;
                    break;
                }
            }
        }
        
        return answer;
    }
}
