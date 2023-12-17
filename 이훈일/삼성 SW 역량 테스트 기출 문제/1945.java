import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int[] nums = new int[]{2, 3, 5, 7, 11};
 	
		for(int test_case = 1; test_case <= T; test_case++) {
            String result = "#"+test_case;
			int N = sc.nextInt();
            for(int i = 0; i < nums.length; i++) {
                int count = 0;
            	while(N % nums[i] == 0) {
                	N = N / nums[i];
                    count++;
                }
                result += " " + count;
            }
            System.out.println(result);
		}
	}
}
