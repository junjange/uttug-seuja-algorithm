import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int age) {
        
        String answer = "";
        
        List<Character> chars = new ArrayList<>();
        
        for(char i='a'; i<='z'; i++) {
			chars.add(i);
		}
        
        String pAge = Integer.toString(age); 
        
        for(int j = 0; j < pAge.length(); j++){
            
            int index = pAge.charAt(j)-'0';
            
            answer += chars.get(index);
        }
        
        return answer;
    }
}
