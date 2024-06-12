import java.util.Arrays;

class Solution {
    public String solution(String number, int k) {
        int length = number.length()-k;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            char max = '0';
            
            for(int j = start; j <= i+k; j++) {
                if(max < number.charAt(j)) {
                    start = j+1;
                    max = number.charAt(j);
                }
            }
            
            sb.append(max);
        }
        
        return sb.toString();
    }
}
