import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();
        
		for(int test_case = 1; test_case <= T; test_case++) {
            String line = sc.nextLine();
            String replace = line.replaceAll("[aeiou]","");
            System.out.println("#" + test_case + " " + replace);
		}
	}
}
