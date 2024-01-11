import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> map = new HashMap<>();
        
         //Map<String, Integer> result = new TreeMap<>();
        Map<String, Integer> result = new HashMap<>();
        
 
        int times = 0;
        String carNum = "";
        String status = "";
        
    
        for(String str : records){
            
            String[] arr = str.split(" ");
            
            times = Integer.parseInt(arr[0].substring(0,2)) * 60 +
                Integer.parseInt(arr[0].substring(3,5));
        
            
            carNum = arr[1];
            status = arr[2];
            
            if(status.equals("IN")){
                
                map.put(carNum,times);
                
            }
            
            if(status.equals("OUT")){
                
                if(!result.containsKey(carNum)){
                    
                   result.put(carNum, times - map.get(carNum));
                
                }else{
                    
                    result.put(carNum, result.get(carNum) + times - map.get(carNum));
                    
                }
                
                map.remove(carNum);
                
            }
            
      
        }
        
        if(!map.isEmpty()){
            
            for(String carName : map.keySet()){
                
                 int inTime = map.get(carName);
                 int newTime = 23 * 60 + 59;
                
                if(result.containsKey(carName)){
                
                     result.put(carName, result.get(carName) + newTime - inTime);
                    
                }else{
                    
                     result.put(carName, newTime - inTime);
                }
                
            
            }
            
        }
        
    
        
                
        List<String> keyList = new ArrayList<>(result.keySet());
        
        Collections.sort(keyList);
        
        
        int[] answer = new int[keyList.size()];
        
        
        for(int i=0; i<answer.length; i++){
            
            answer[i] = cal(fees,result.get(keyList.get(i)));
            
            
            
        }
        
        return answer;
    }
    
    public int cal(int[] fees, int times){
        
        int calResult = 0;
        
        if(times <= fees[0]){
            return fees[1];
        }else{
            
            int len = (times - fees[0]) / fees[2];
            
            int sumReuslt = len * fees[3];
            
            if((times - fees[0]) % fees[2] != 0){
                sumReuslt += fees[3] + fees[1];
                return sumReuslt;
            }else{
                return sumReuslt + fees[1];
            }
            
            
        }
        

        
    }
}
