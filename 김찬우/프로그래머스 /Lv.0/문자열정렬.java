
import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        
        String change = my_string.toLowerCase();
        
        char[] charArr = change.toCharArray();
        
        Arrays.sort(charArr);
        
        String result = new String(charArr);
        
        return result;
    }
}
