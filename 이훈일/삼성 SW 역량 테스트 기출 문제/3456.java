import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
            int[] sides = new int[3];
			for(int i = 0; i < 3; i++) {
           		sides[i] = sc.nextInt();
            }
            
            int answer = 0;
            if(sides[0] == sides[1]) {
            	answer = sides[2];
            } else if(sides[0] == sides[2]) {
            	answer = sides[1];
            } else {
            	answer = sides[0];
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
