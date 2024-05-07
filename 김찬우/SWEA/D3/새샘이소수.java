import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int p=2; p<=1000; p++) {
            
            if (isPrime(p)) {
                list.add(p);
            }
            
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            
            st =  new StringTokenizer(br.readLine()," ");    

        	int n = Integer.parseInt(st.nextToken());
            
            int len = list.size();
            int cnt=0;
            
            for (int i=0; i <len; i++ ) {
                
                for (int j=i; j <len; j++ ) {
                    
                    if (list.get(i)+list.get(j) > n) {
                        break;
                    }
                    
                    for (int z=j; z <len; z++ ) {
                        
                        if ((list.get(i)+list.get(j)+list.get(z)) == n) {
                            cnt++;
                        }
                        
                    }
                }
            }
            
            System.out.println("#"+test_case+" "+cnt);




        }
    }
    
    public static boolean isPrime(int num) { 
        
        for (int k=2; k*k<=num; k++) {
            if (num % k ==0) {
                return false;
            }
        }
        
        return true;
    }
}
