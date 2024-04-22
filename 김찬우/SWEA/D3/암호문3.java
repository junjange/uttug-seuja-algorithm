import java.io.*;
import java.util.*;

class Solution
{
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int test_case = 1; test_case <= 10; test_case++) {
            
           ArrayList<Integer> list = new ArrayList<>();
            
            StringTokenizer st =  new StringTokenizer(br.readLine()," ");

            int n = Integer.parseInt(st.nextToken());
            
            st =  new StringTokenizer(br.readLine()," ");
            
            for (int i=0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            
            st =  new StringTokenizer(br.readLine()," ");
            
            int m = Integer.parseInt(st.nextToken());
            
            st =  new StringTokenizer(br.readLine()," ");
            
            int k = 0;
            while (k < m) {
                
                String com = st.nextToken();
                
                if (com.equals("I")) {

                     int index =  Integer.parseInt(st.nextToken());
                     int cnt =  Integer.parseInt(st.nextToken());
                     int number = 0; 
                    
                    for (int i=0; i<cnt; i++) {
                        
                        number =  Integer.parseInt(st.nextToken());
                        list.add( index++, number);
                       
                        
                    }
                    
                    k++;
                    
                } else if (com.equals("A")) {
                    
                     int cnt =  Integer.parseInt(st.nextToken());
                     int number = 0; 
                    
                    for (int i=0; i<cnt; i++) {
                        
                        number =  Integer.parseInt(st.nextToken());
                        list.add(number);
           
                        
                    }
                    
                    k++;
                    
                    
                }else {
                    
                      int startIdex =  Integer.parseInt(st.nextToken());
                      int endIdex =  Integer.parseInt(st.nextToken());
                    
                    for (int i=0; i< endIdex; i++) {
                        list.remove(startIdex);
                    }
                    
                    k++;
                    
                }
                
                
                
                
            }
            
            sb.setLength(0);
            sb.append("#").append(test_case).append(" ");
            for (int i=0; i<10; i++) {      
                sb.append(list.get(i)).append(" "); 
            }
            
            System.out.println(sb.toString());
            

        }
    }
}


