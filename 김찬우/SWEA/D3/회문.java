
import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
 
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt();
            char[][] arr = new char[8][8];
            int count =0;
            String test = "";
 
            for(int i =0; i<8; i++){
                 String str  = sc.next();
                 for(int j =0; j<8; j++){
                     arr[i][j] = str.charAt(j);
                }
            }
        
            for(int i =0; i<8; i++){
                 StringBuilder sb =   new StringBuilder();
                 
                 for(int j = 0; j<8; j++){
                     sb.append(arr[i][j]);
 
                     if(n==sb.length()){
                          test = sb.toString();
                           if(test.equals(sb.reverse().toString())){               
                               count++;
                            }
                            sb.setLength(0);
                            j=j+1-n;
                     }
                     
                }
            }
             
             for(int i =0; i<8; i++){
                 StringBuilder sb =   new StringBuilder();
                 
                 for(int j = 0; j<8; j++){
                     sb.append(arr[j][i]);
 
                     if(n==sb.length()){
                          test = sb.toString();
                           if(test.equals(sb.reverse().toString())){                 
                               count++;
                            }
                            sb.setLength(0);
                            j=j+1-n;
                     }
                     
                }
            }
             
           System.out.println("#"+test_case+" "+count);
 
 
        }
    }
}
