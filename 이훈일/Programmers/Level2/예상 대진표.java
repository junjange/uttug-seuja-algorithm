class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int start = 0;
        
        while(true) {
            int compare = n/2 + start;
            if(a <= compare && b <= compare) {
                n = n / 2;
            } else if(a > compare && b > compare) {
                start = compare;
                n = n / 2;
            } else {
                break;
            }
        }
        
        for(int i = 1; i <= 20; i++) {
            if(n == Math.pow(2, i)) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
