import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<Integer>();
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            double count = 0;
            double clear = 0;
            for(int num : stages) {
                if(num == i) {
                    count++;
                }
                if(num >= i){
                    clear++;
                }
            }
            if(clear == 0){
                map.put(i, 0.0);
                continue;
            }
            map.put(i, count / clear);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<>() {

             @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        return keySet.stream().mapToInt(Integer::intValue).toArray();
    }
}
