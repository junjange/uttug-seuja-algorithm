import java.util.Arrays;
import java.lang.Math;

class Solution {
    public int solution(int[] arr) {
        
         int result = arr[0];
    
        
        for(int i = 1;i<arr.length; i++){
            
            
             System.out.println("result "+result);
            System.out.println("i "+i);
            System.out.println("arr[i] "+arr[i]);
            
             int max = gcd(result,arr[i]);
            
            
             System.out.println(max);
             result = (result*arr[i])/max;
            
            System.out.println("result "+result);
            
        }
        

        return result;
    }
    
    
    public static int gcd(int num1 ,int num2){
        
        int max = Math.max(num1,num2);
        int min = Math.min(num1,num2);
        
        if(max % min == 0){
            return min;
        }
        
        return gcd(min,max % min);
    }
}
