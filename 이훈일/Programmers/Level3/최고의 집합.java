class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int share = s/n;
        int remain = s%n;
        
        for(int i = 0; i < n; i++) {
            if(n-remain <= i){
                answer[i] = share+1;
            }else {
                answer[i] = share;
            }
        }
        
        return n > s ? new int[]{-1} : answer;
    }
}
