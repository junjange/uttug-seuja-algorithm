import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=1;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			boolean[] nums = new boolean[1000001];
            StringBuilder sb = new StringBuilder();
            for(int i = 2; i <= 1000000; i++) {
            	if(!nums[i]) {
                	sb.append(i + " ");
                }
                for(int j = i; j <= 1000000; j += i) {
                	nums[j] = true;
                }
            }
            
            System.out.println(sb.toString());
		}
	}
}
