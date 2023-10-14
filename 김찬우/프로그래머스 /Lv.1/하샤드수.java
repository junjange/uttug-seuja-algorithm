class Solution {
    public boolean solution(int x) {
        
        int answer =0;
        
        String str ="" + x;
        
        for(int i=0; i<str.length();i++){
            
            answer+=str.charAt(i)-'0';
            
        }
        
        if(x%answer==0){
            return true;
        }
        else{
            return false;
        }
        
    
    }
}
