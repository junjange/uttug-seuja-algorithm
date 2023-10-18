import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
    int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] iArr = new int[N];
            for (int i = 0; i < N; i++) {
                iArr[i] = sc.nextInt();
            }
            int sum = 0;
            for(int i = 2; i < N-2; i++) {
                int max = Math.max(iArr[i-2], Math.max (iArr[i-1], Math.max(iArr[i+1], iArr[i+2])));
                if(iArr[i] > max) {
                	sum += iArr[i] - max;
                }
            }
			      System.out.printf("#%d %d%n", test_case, sum);
		}
	}
}
