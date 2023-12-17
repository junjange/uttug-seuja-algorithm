import java.util.*;
class Solution {
    public int solution(int[] citations) {
        
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(citations);
        
        int max = Arrays.stream(citations).max().getAsInt();
    
        
        for(int i =1; i<=max; i++){
            
            int ringtLen = 0;
            int leftLen = 0;
            
            for(int j=0; j<citations.length; j++){
                
                if(citations[j]>=i){
                    ringtLen = citations.length-j;
                    leftLen = j+1;
                    
                    if(ringtLen>=i && leftLen<=i){
                        list.add(i);
                    }
                    
                }
                
                
            }
            
            
            
        }
        
        return (list.size() == 0) ? 0 : Collections.max(list);  
            
    }
}
