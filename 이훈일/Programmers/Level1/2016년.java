import java.util.HashMap;

class Solution {
    public String solution(int a, int b) {
        String[] week = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        HashMap<Integer, Integer> map = new HashMap<>(){{
            put(1,31);
            put(2,29);
            put(3,31);
            put(4,30);
            put(5,31);
            put(6,30);
            put(7,31);
            put(8,31);
            put(9,30);
            put(10,31);
            put(11,30);
            
        }};
        int sum = 0;
        for(int i = 1; i < a; i++) {
            sum += map.get(i);
        }
        return week[(sum + b -1) % 7];
    }
}
