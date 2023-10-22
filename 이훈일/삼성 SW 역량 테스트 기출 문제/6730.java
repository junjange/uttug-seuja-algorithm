import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int upMax = 0;
            int downMax = 0;
            
            int[] buildings = new int[N];
            for(int i = 0; i < N; i++) {
            	buildings[i] = sc.nextInt();
            }
            
            for(int i = 1; i < buildings.length; i++) {
            	if(buildings[i] >= buildings[i-1]) {
                	upMax = Math.max(buildings[i] - buildings[i-1], upMax);
                }else {
                	downMax = Math.max(buildings[i-1] - buildings[i], downMax);
                }
            }
            
            System.out.println("#" + test_case + " " + upMax + " " + downMax);
		}
	}
}
