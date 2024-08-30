class Solution {
    public int solution(int n, int k) {
        String demical = Integer.toString(n, k);
        String[] nums = demical.split("0");
        int count = 0;
        
        for(String num : nums) {
            if(num.equals("")) {
                continue;
            }
            
            long nNum = Long.parseLong(num);
            boolean isPrime = true;

            for(int i = 2; i <= Math.sqrt(nNum); i++) {
                if(nNum % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime && nNum > 1) {
                count++;
            }
        }
        
        return count;
    }
}
