import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
            String X = sc.next();
            
			HashSet<String> set = new HashSet<>();
            String[] arrX = X.split("");
            for(String word : arrX) {
            	set.add(word);
            }
			
            System.out.println("#" + test_case + " " + set.size());
		}
	}
}
