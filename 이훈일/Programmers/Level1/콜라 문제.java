class Solution {
    public int solution(int a, int b, int n) {
        if(n < a){
            return 0;
        }
        return b * (n/a) + solution(a,b, b * (n/a) + (n % a));
    }
}
