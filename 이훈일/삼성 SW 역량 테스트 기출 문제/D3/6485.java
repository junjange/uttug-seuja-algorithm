import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] station = new int[5000];
            int N = sc.nextInt();
            for(int i = 0; i < N; i++) {
            	int A = sc.nextInt();
                int B = sc.nextInt();
                for(int j = A-1; j < B; j++) {
                	station[j]++;
                }
            }
            
            int P = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < P; i++) {
            	int C = sc.nextInt();
                sb.append(" " + station[C-1]);
            }
            
            System.out.println("#" + test_case + sb.toString());
		}
	}
}
