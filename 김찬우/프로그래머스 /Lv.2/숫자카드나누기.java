import java.util.*;
import java.lang.Math;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int result1 = 0;
        int result2 = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int a = getGcd(arrayA);
        int b = getGcd(arrayB);
   
          
        for(int i=0; i<arrayA.length; i++){
            
            if(arrayB[i] % a == 0){
                result1 = 0;
                break;
            }else{
                result1 = a;
            }
            
        }
        
        
        
        for(int i=0; i<arrayA.length; i++){
            
            if(arrayA[i] % b == 0){
                result2 = 0;
                break;
            }else{
                result2 = b;
            }
            
        }
        
 
        return Math.max(result1,result2);
    }
    
    public static int gcd(int num1 , int num2){
        
        if(num2 % num1 == 0){
            return num1;
        }
        
        return gcd(num2 % num1, num1);
        
        
    }
    
    public static int getGcd(int[] arr){
        
        if(arr.length == 1){
            return arr[0];
        }
        
        int gcd = gcd(arr[0], arr[1]);
        
        for(int i=2; i<arr.length; i++){
            gcd = gcd(gcd, arr[i]);
        }
        
        return gcd;
        
        
        
    }
}
