import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> duplication = new ArrayList<String>(){{
            add(words[0]);
        }};
        int[] result = new int[]{0,0};
        char end = words[0].charAt(words[0].length()-1);
        for(int i = 1; i < words.length; i++) {
            if(duplication.contains(words[i])) {
                result[0] = (i+1)%n == 0 ? n : (i+1)%n;
                result[1] = ((i+1)-result[0])/n+1;
                return result;
            }
            if(end != words[i].charAt(0)) {
                result[0] = (i+1)%n == 0 ? n : (i+1)%n;
                result[1] = ((i+1)-result[0])/n+1;
                return result;
            }
            end = words[i].charAt(words[i].length()-1);
            duplication.add(words[i]);
        }
        return result;
    }
}
