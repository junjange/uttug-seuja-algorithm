class Solution {
    public int solution(String s) {
        
        int x = 0;
        int y = 0;
        int result = 0;
        char first = s.charAt(0);
        
        for(int i = 0; i<s.length();i++){
            
            if(x==y){
                
                System.out.println("if x==y"+x);
                System.out.println("if x==y"+y);
                result++;
                first = s.charAt(i);
                System.out.println("result"+result);
            }
        
            if(first == s.charAt(i)){
                
                System.out.println("i"+i);
                x++;
                System.out.println("x"+x);
            }
            else{
                System.out.println("i"+i);
                y++;
                System.out.println("y"+y);

            }
            
            
        }
        return result;
    }
}
