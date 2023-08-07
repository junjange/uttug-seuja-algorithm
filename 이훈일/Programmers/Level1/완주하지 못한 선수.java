import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Boolean> map = new HashMap<>();
        String answer = "";
        for(String s : participant){
            if(map.containsKey(s)) {
                map.put(s, !map.get(s));
            }else {
                map.put(s, false);
            }
        }
        for(String s : completion) {
            map.put(s, !map.get(s));
        }
        for(String s : map.keySet()) {
            if(!map.get(s)) {
                answer = s;
            }
        }

        return answer;
    }
}
