class Solution {
    public int[] solution(String s) {
        
        int[] answer = {0,0};
        
        int i =1;
        
        
        while(!s.equals("1")){
            
            int count = s.length() - s.replace("0","").length();
            
            if(count==0){
                
            }
            
            System.out.println(count);
            
            answer[1]+=count;
            
            s = s.replace("0","");
            
            s = Integer.toBinaryString(s.length()); 
            
            answer[0]++;
            
            i++;
            
            
        }
        
        
        
        return answer;
    }
    
    
}
