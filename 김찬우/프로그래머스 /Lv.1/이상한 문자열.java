class Solution {
    public String solution(String s) {
     
        String[] arr = s.split(" ",-1);
        String[] result = new String[arr.length];
        String answer ="";
        
        for(int i=0; i<arr.length; i++){
            
            result[i] = "";
            
            for(int j = 0; j < arr[i].length(); j++){
                
                
                if(j%2 == 0){
                    result[i]+=Character.toUpperCase(arr[i].charAt(j));
                    
                }else{
                    result[i]+=Character.toLowerCase(arr[i].charAt(j));
                }
                
            }
            
        
            
        }
        
        for(int i=0; i<result.length; i++){
            
            if(result.length-1==i){
                answer+=result[i];
            }else{
                answer+=result[i]+" ";
            }
            
        }
        
        
        
        return answer;
    }
}
