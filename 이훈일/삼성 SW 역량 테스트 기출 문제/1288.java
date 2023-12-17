import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < 10; i++) {
                set.add(i);
            }
            HashSet<Integer> space = new HashSet<>();
            int i = 1;
            while(set.size() != space.size()) {
            	int num = N * i;
                String str = Integer.toString(num);
                for(String word : str.split("")) {
                	space.add( Integer.parseInt(word));
                }
                i++;
            }
			System.out.println("#" + test_case + " " + N*(i-1));
		}
	}
}
