class Solution {
    public String solution(String s) {
        
        String answer = "";
     
        String[] strList =  s.split(" ");
        
        for(int i =0; i<strList.length; i++){
            
            if(strList[i].length() == 0) {
    			answer += " ";
    		} 
            
            else{
                answer += strList[i].substring(0,1).toUpperCase()+ 
                          strList[i].substring(1).toLowerCase();
                answer+=" ";
            }
            
            
            
            
        }
        
        if(s.substring(s.length() -1, s.length()).equals(" ")) 
                return answer;
        
        return answer.substring(0, answer.length() - 1);

     
    }
}
