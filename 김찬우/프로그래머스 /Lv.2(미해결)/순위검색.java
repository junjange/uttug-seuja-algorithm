import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        
        // info 기반으로 hashmap 만들기 
        
        for(String str :info){
            
            String[] infoData = str.split(" "); 
            String[] languages = {infoData[0],"-"};
            String[] parts = {infoData[1],"-"};
            String[] careers = {infoData[2],"-"};
            String[] foods = {infoData[3],"-"};
            Integer score = Integer.valueOf(infoData[4]);
            
            for(String lang : languages){
                
                for(String part :parts){
                    
                    for(String career :careers){
                        
                        for(String food :foods){
                    
                            String[] infoKeyList = {lang,part,career,food};
                            String  infoKey = String.join(" ", infoKeyList);
                            
                            ArrayList<Integer> valueList = map.getOrDefault(infoKey, new ArrayList<Integer>());
                            valueList.add(score);
                            map.put(infoKey,valueList);
                            
                        }
                    
                    }
                    
                }
                
            }
            
        
            
        }
        
        // hashmap value값을 오름차순 
        
        
         for (String key : map.keySet())
            Collections.sort(map.get(key));
        
        
        // 쿼리 조건에 맞는 사람들 가져오기
        
        int[] result = new int[query.length];
        int cnt = 0;
        
        for(int i = 0; i<query.length ;i++){
            
            query[i] = query[i].replaceAll(" and ", "");
            String[] data = query[i].split(" ");
            
            System.out.println(query[i].charAt(4));
            
            String qKey = String.join(" ", data);
            
            
             // 이진탐색을 통해서 가져오기 
            
            if(map.containsKey(qKey)){
                
                ArrayList<Integer> list = map.get(qKey);
                
                int left =0;
                int right = list.size();
                
                while(left < right){
                    
                    int mid = (left+right)/2;
                    
                    if(list.get(mid) >= (int)query[i].charAt(4)){
                        
                        right = mid;
                        
                    }else{
                        left =mid-1;
                    }
                    result[i] = list.size()- left;
                }
                
                
            }
            
            
            
            
        }
        
        
        
       
        return result;
    }
}
