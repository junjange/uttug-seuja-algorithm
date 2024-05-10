import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int X1 = sc.nextInt();
            int Y1 = sc.nextInt();
            int X2 = sc.nextInt();
            int Y2 = sc.nextInt();
            int N = sc.nextInt();
            
            int inCount = 0;
            int lineCount = 0;
            int outCount = 0;
            for(int i = 0; i < N; i++) {
            	int x = sc.nextInt();
                int y = sc.nextInt();
                if(X1 <= x && x <= X2 && Y1 <= y && y <= Y2) {
                	if(X1 == x || X2 == x || Y1 == y || Y2 == y) {
                    	lineCount++;
                    } else {
                    	inCount++;
                    }
                } else {
                	outCount++;
                }
            }
            
            System.out.println("#" + test_case + " " + inCount + " " + lineCount + " " + outCount); 
		}
	}
}
