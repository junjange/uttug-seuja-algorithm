import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
           	int[] happy = new int[N];
            for(int i = 0; i < N; i++) {
            	happy[i] = sc.nextInt();
            }
            
            int count = 0;
            for(int i = 1; i < N; i++) {
                if(happy[i] != 0) {
                	count++;
                    int period = happy[i] - 1; 
                    
                    for(int j = i+1; j < N; j++) {
                    	if((happy[j]-1) % period == 0) {
                        	happy[j] = 0;
                        }
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
}
