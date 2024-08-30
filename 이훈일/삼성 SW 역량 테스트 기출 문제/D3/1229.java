import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            ArrayList<Integer> secrets = new ArrayList<>();
            for(int i = 0; i < N; i++) {
            	secrets.add(sc.nextInt());
            }
            
            int commandCount = sc.nextInt();
            for(int i = 0; i < commandCount; i++) {
            	String command = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                for(int j = 0; j < y; j++) {
                    if(command.equals("I")) {
                    	secrets.add(x+j, sc.nextInt());
                    } else if(command.equals("D")) {
                   	 	secrets.remove(x);
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 10; i++) {
            	sb.append(" " + secrets.get(i));
            }
            
            System.out.println("#" + test_case + sb.toString());
		}
	}
}
