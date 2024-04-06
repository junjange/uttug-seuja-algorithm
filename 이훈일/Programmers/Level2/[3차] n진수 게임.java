class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int total = 0;
        int count = 0;
        int num = 0;
        
        while(count < t) {
            String nNum = Integer.toString(num, n);
            
            for(String word : nNum.split("")) {
                if(total % m == p-1 && count < t) {
                    sb.append(word.toUpperCase());
                    count++;
                }
            
                total++;
            }
            
            num++;
        }
        
        return sb.toString();
    }
}
