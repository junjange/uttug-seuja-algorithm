class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(Math.max(n,m), Math.min(n,m)); 
        answer[1] = (n / answer[0]) * (m / answer[0]) * answer[0];
        return answer;
    }
    
    public static int gcd(int n, int m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
    
}
