import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        TreeMap<Integer, Integer> deliMap = new TreeMap<Integer, Integer>(){{
            for(int i = 0; i < deliveries.length; i++) {
                if(deliveries[i] != 0) {
                    put(i+1, deliveries[i]);
                }
            }
        }};
        TreeMap<Integer, Integer> pickMap = new TreeMap<Integer, Integer>(){{
            for(int i = 0; i < pickups.length; i++) {
                if(pickups[i] != 0) {
                    put(i+1, pickups[i]);
                }
            }
        }};
        List<Integer> deliKeys = new ArrayList<>(deliMap.keySet());
        List<Integer> pickKeys = new ArrayList<>(pickMap.keySet());
        
        int deliNum = deliKeys.size() - 1;
        int pickNum = pickKeys.size() - 1;
        
        int deliSum = 0;
        int pickSum = 0;
        
        int deliIndex = deliKeys.get(deliNum);
        int pickIndex = pickKeys.get(pickNum);
        
        long result = 0;
        
        while(true) {
            deliSum += deliMap.get(deliIndex);
            pickIndex += pickMap.get(pickIndex);
            if(deliSum + deliMap.get(deliIndex) > cap && pickSum + pickMap.get(pickIndex) <= cap) {
                deliMap.put(deliIndex, deliSum + deliMap.get(deliIndex) - cap);
                deliSum = 0;
                pickSum -= cap;
                result += (long)Math.max(deliIndex, pickIndex) * 2;
            }else if(deliSum + deliMap.get(deliIndex) <= cap && pickSum + pickMap.get(pickIndex) > cap) {
                pickMap.put(pickIndex, pickSum + pickMap.get(pickIndex) - cap);
                pickSum = 0;
                deliSum -= cap;
                result += (long)Math.max(deliIndex, pickIndex) * 2;
            }else if(deliSum + deliMap.get(deliIndex) > cap && pickSum + pickMap.get(pickIndex) > cap) {
                deliMap.put(deliIndex, deliSum + deliMap.get(deliIndex) - cap);
                pickMap.put(pickIndex, pickSum + pickMap.get(pickIndex) - cap);
                deliSum = 0;
                pickSum = 0;
                result += (long)Math.max(deliIndex, pickIndex) * 2;
            }else {
                deliSum += deliMap.get(deliIndex);
                pickSum += pickMap.get(pickIndex);
                if(deliNum < 0 && pickNum >=0) {
                    pickNum -= 1;
                }else if(deliNum >= 0 && pickNum < 0) {
                    deliNum -= 1;
                }else if(deliNum >= 0 && pickNum >= 0) {
                    deliNum -= 1;
                    pickNum -= 1;
                }else {
                    break;
                }
                deliIndex = deliKeys.get(deliNum);
                pickIndex = pickKeys.get(pickNum);
            }
        }
        
        return result;
    }
}
