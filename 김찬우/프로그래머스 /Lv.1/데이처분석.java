import java.util.*;
class Solution {
    
    public static int e =0 ;
    public static  int index =0 ;
    
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;
        List<int[]> list = new ArrayList<>();
        
        
        
        String[] str = {"code","date","maximum","remain"};
        
        for(int i=0; i<4; i++){
            
            if(ext.equals(str[i])){
                e = i;
            }
            
            if(sort_by.equals(str[i])){
                index = i;
            }
            
        }
        
        
        for(int i=0; i<data.length; i++){
        
            
            if(data[i][e] < val_ext){
                list.add(data[i]);
            }
            
        }
        
        answer = new int[list.size()][4];
        
        Collections.sort(list, new Comparator<>(){
            
            @Override
            public int compare(int[] o1, int[] o2){
                
                return o1[index] - o2[index];
                
            }
        });
        
        for(int i=0; i<list.size(); i++){
            
            answer[i] = list.get(i);
            
        }
        
        
        
        return answer;
    }
}
