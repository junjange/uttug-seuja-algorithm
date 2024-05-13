import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int M = sc.nextInt();
            String[] s = new String[N];
            for(int i = 0; i < N; i++) {
            	s[i] = sc.next();
            }
            
            String[] t = new String[M];
            for(int i = 0; i < M; i++) {
            	t[i] = sc.next();
            }
            
            int Q = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < Q; i++) {
            	int Y = sc.nextInt();
                sb.append(s[(Y-1)%N]);
                sb.append(t[(Y-1)%M] + " ");
            }
            
            System.out.println("#" + test_case + " " + sb.toString());
		}
	}
}
