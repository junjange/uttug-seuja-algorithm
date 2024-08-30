import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        // 아이디어 
        //  딕션어리로 최종 닉네임을 저장 
        
        HashMap<String,String> map = new HashMap<>();
        int count = 0;
        
        for(String reco : record){
            
            String[] arr = reco.split(" ");
            
            if(arr[0].equals("Change")){
                count++;
            }
            
            if(arr.length == 2){
                continue;
            }
            
            map.put(arr[1],arr[2]);
            
        }
        
        String[] result = new String[record.length-count];
        
        int index = 0;
        
        
        for(int i=0; i<record.length; i++){
            
            String[] arr = record[i].split(" ");
            
            if(arr[0].equals("Enter")){
                result[index] = map.get(arr[1])+"님이 들어왔습니다.";
                index++;
                
            }else if(arr[0].equals("Leave")){
                
                 result[index] = map.get(arr[1])+"님이 나갔습니다.";
                 index++;
                
            }
            
          
        }
        return result;
    }
}
