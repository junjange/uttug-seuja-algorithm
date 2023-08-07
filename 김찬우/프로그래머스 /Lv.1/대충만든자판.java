import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] result = new int[targets.length];
        
        int count =0;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i = 0;i<keymap.length;i++){
            
            for(int j=0;j<keymap[i].length();j++){
                
                char a = keymap[i].charAt(j);
                
                if(!hm.containsKey(a) || j < hm.get(a)){
                    hm.put(a,j+1);
                }
            
            }
            
        }
        
        
         for(int k=0;k<targets.length;k++){
             
            count = 0;
            
            for(int z=0;z<targets[k].length();z++){
                
                char b = targets[k].charAt(z);
                
                
                if(!hm.containsKey(b)){
                    count=-1;
                    break;
                }else{
                    count+=hm.get(b);
                }
                
            
            }
             
            result[k]=count;
            
        }
        

        return result;
    }
}
