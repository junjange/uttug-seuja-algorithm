import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.lang.Math;


class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long result = 0;    
        
        List<List<Integer>> delivery= new ArrayList<>();
        List<List<Integer>> pickup = new ArrayList<>();
        
        for(int i = deliveries.length-1; i > -1 ;i--){
            
            if(deliveries[i]==0){
                continue;
                
            }else{
            
            List<Integer> list = new ArrayList<Integer>();
            list.add(i+1);
            list.add(deliveries[i]);
            delivery.add(list);
            }
         
        }
        
        for(int j = pickups.length-1; j > -1 ;j-- ){
            
            if(pickups[j]==0){
                continue;
            }
            
            List<Integer> list = new ArrayList<Integer>();
            list.add(j+1);
            list.add(pickups[j]);
            pickup.add(list);
            
        }
        
        while(!(delivery.size()==0 && pickup.size()==0)){
            
            long num = Math.max(delivery.get(delivery.size()-1),delivery.get(pickup.size()-1));
                                             
            bCap = cap;
            pCap = cap;
            
            
        }
        
      
        
        
        return result;
    }
}
