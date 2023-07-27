class Solution {
    public int solution(int n) {
        int[] prime = new int[n+1];

        prime[0] = prime[1] = 0;

        for(int i = 2; i < n+1; i++) {
            prime[i] = i;
        }

        for(int i = 2; i*i <= n; i++) {
            if(prime[i] == 0){
                continue;
            }
            for(int j = i*i; j < n+1; j += i) {
                prime[j] = 0;
            }
        }

        int count = 0;
        for(int i = 2; i < n+1; i++) {
            if(prime[i] != 0) {
                count++;
            }
        }

        return count;
    }
}
