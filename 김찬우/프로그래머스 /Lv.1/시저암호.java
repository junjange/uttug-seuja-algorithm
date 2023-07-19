class Solution {
    public String solution(String s, int n) {
        
        char[] charArr = s.toCharArray();  
        
        
        for(int i =0; i<charArr.length;i++){
            
            if(charArr[i]==' '){
                continue;
            }
            
            int result = (int)charArr[i]+n;  
            if(result>90 && charArr[i]<91){
                result = result-90+64;
                
            }else if(result>122 && charArr[i]>96){
                result = result-122+96;
            }
            
            charArr[i] = (char)result;
            
        
            
            
            
            
            
        }
        return String.valueOf(charArr);
    }
}
