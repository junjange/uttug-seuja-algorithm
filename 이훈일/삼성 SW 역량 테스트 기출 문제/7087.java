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
            sc.nextLine();
            List<String> words = new ArrayList<>();
            char cur = 'A';
            int count = 0;
            
            for(int i = 0; i < N; i++) {
            	words.add(sc.nextLine());
            }
            words.sort((o1, o2) -> o1.charAt(0) - o2.charAt(0));
            
            for(String word : words) {
            	if(word.charAt(0) == cur) {
                	cur++;
                    count++;
                }else {
                	if(word.charAt(0) != cur-1) {
                    	break;
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
}
