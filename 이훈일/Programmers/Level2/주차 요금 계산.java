import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int per = fees[2];
        int perFee = fees[3];
        
        HashMap<Integer, Integer> inCar = new HashMap<>();
        HashMap<Integer, Integer> totalTime = new HashMap<>();
        for(String record : records) {
            String[] details = record.split(" ");
            int carNum = Integer.parseInt(details[1]);
            
            if(details[2].equals("IN")) {
                String[] inTime = details[0].split(":");
                int inTotalTime = 60 * Integer.parseInt(inTime[0]) + Integer.parseInt(inTime[1]);
                inCar.put(carNum, inTotalTime);
            } else if(details[2].equals("OUT")){
                String[] outTime = details[0].split(":");
                int outTotalTime = 60 * Integer.parseInt(outTime[0]) + Integer.parseInt(outTime[1]);
                int inTotalTime = inCar.get(carNum);
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + outTotalTime-inTotalTime);
                inCar.remove(carNum);
            }
        }
        
        List<Integer> inKeySet = new ArrayList<>(inCar.keySet());
        for(int carNum : inKeySet) {
            int outTotalTime = 1439;
            int inTotalTime = inCar.get(carNum);
            totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + outTotalTime-inTotalTime);
            inCar.remove(carNum);
        }
        
        int[] answer = new int[totalTime.size()];
        List<Integer> keySet = new ArrayList<>(totalTime.keySet());
        Collections.sort(keySet);
        int index = 0;
        for(int i = 0; i < keySet.size(); i++) {
            int carNum = keySet.get(i);
            
            if(totalTime.get(carNum) <= basicTime) {
                answer[i] = basicFee;
            } else {
                int perTime= (int) Math.ceil((totalTime.get(carNum) - basicTime) / (double)per);
                answer[i] = basicFee + perTime * perFee;
            }       
        }
        
        return answer;
    }
}
