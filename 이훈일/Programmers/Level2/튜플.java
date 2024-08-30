import java.util.*;

class Solution {
    public int[] solution(String s) {
        String sub = s.substring(2, s.length()-2);
        String rep = sub.replace("},{", " ");
        String[] spl = rep.split(" ");
        
        Arrays.sort(spl, (o1, o2) -> o1.length() - o2.length());
        
        List<Integer> tuple = new ArrayList<>();
        int[] result = new int[spl.length];
        for(int i = 0; i < spl.length; i++) {
            String[] numbers = spl[i].split(",");
            for(String number : numbers) {
                int iNumber = Integer.parseInt(number);
                if(!tuple.contains(iNumber)) {
                    tuple.add(iNumber);
                    result[i] = iNumber;
                }
            }
        }
        
        return result;
    }
}
