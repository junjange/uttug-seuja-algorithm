import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int B = sc.nextInt();
            int E = sc.nextInt();
            
            int[] clock = new int[N];
            for(int i = 0; i < N; i++) {
            	clock[i] = sc.nextInt();
            }
            
            int answer = 0;
            for(int i = 0; i < N; i++) {
                boolean isPossible = false;
            	for(int j = B-E; j <= B+E; j++) {
                	if(j % clock[i] == 0) {
                    	isPossible = true;
                        break;
                    }
                }
                
                if(isPossible) {
                	answer++;
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
