class Solution {
    public int solution(int n) {
        int a = 1;
        int b = 2;
        int num = 0;

        for(int i = 3; i <= n; i++) {
            num = (a+b) % 1000000007; 
            a = b; 
            b = num; 
        }

        return b;
    }
}
