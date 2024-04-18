import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            
            st =  new StringTokenizer(br.readLine()," ");
            
            int n = Integer.parseInt(st.nextToken());
            
            if (n==1){
                System.out.println("#"+test_case);
                System.out.println(1);
                continue;
            }
            
            int[][] arr =  new int[n][n];
            
            int k = 1;
            
            int startX = 0;
            int startY = 0;
            
            while (k <= n*n) {
                
                
                while (true) {
                    
                    if (arr[startX][startY] == 0) {
                        
                        if(startY == n-1){
                            arr[startX][startY] = k++;
                            startX++;
                            break;
                   		}else {
                             arr[startX][startY] = k++;
                   	         startY++;
                        }
                        
                        
                    }else {
                        
                        startY--;
                        startX++;
        
                        break;
                    }
                    
                }
                
                 while (true) {
                    
                    if (arr[startX][startY] == 0) {
                        
                        if(startX == n-1){
                       		 arr[startX][startY] = k++;
                       		 startY--;
                        break;
                   		}else {
                            
                             arr[startX][startY] = k++;
                   	   		 startX++;
                        }
                        
                       
                        
                        
                    }else {
                     
                        startX--;
                        startY--;

                          break;
                    }
                    
                }
                
                 while (true) {
                    
                    if (arr[startX][startY] == 0) {
                        
                        if(startY == 0){
                        	 arr[startX][startY] = k++;
                       		 startX--;
                       		 break;
                   		}else{
                            
                             arr[startX][startY] = k++;
                   	         startY--;
                        }
                        
                       
                        
                        
                    }else {
                        
                        startY++;
                        startX--;
                
                          break;
                    }
                    
                }
                
                 while (true) {
                    
                    if (arr[startX][startY] == 0) {
                      
                        arr[startX][startY] = k++;
                   	    startX--;
                        
                        
                    }else {
                         startX++;
                         startY++;
         
                        break;
                    }
                    
                }
              
               
                
            }
            
            System.out.println("#"+test_case);
            
            for (int i=0; i<n ;i++){
                
                for(int j=0; j<n; j++){
                    System.out.print(arr[i][j]+" ");
                }
                
                   System.out.println();
            }

        }
    }
}

