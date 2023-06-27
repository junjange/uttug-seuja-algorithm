class Solution {
    public int solution(String t, String p) {
        
        int count =0;
        
        long pn = Long.parseLong(p);
        
        int idx = p.length(); 
        
        for(int i=0; i<=t.length()-idx;i++){
            
            String num =t.substring(i,i+idx);
            long tn = Long.parseLong(num);
            
            if(pn>=tn){
                count++;
            }
                
        }
        
       
        return count;
    }
}
