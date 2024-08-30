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
            int m = Integer.parseInt(st.nextToken());
            int result = 0;
            
            HashMap<String,Integer> map =  new HashMap<>();
            String[] arr = new String[m];
            
            for (int i=0; i<n; i++) {
                st =  new StringTokenizer(br.readLine()," ");
                
                String luckLottery = st.nextToken(); 
                int money = Integer.parseInt(st.nextToken());
                map.put(luckLottery,money);
            }
            
            for (int i=0; i<m; i++) {
                st =  new StringTokenizer(br.readLine()," ");
                
                String luckLottery = st.nextToken(); 
                arr[i] = luckLottery;
               
            }
            
            for (int i=0; i <m; i++) {
                
                for (String str : map.keySet()) {
                    
                    boolean check =true;
                    
                    for (int j=0; j < 8; j++) {
                        
                        if (str.charAt(j) =='*') {
                            continue;
                        }
                        
                        if (str.charAt(j) != arr[i].charAt(j)) {
                            check = false;
                            break;
                        }
                    }
                    
                    if (check) {
                        result+= map.get(str);
                    }
                    
                    
                    
                }
                
            }
            
            System.out.println("#"+test_case+" "+result);




        }
    }
}
