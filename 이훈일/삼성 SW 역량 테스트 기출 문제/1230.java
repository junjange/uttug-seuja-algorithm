import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++) {
            StringBuffer sb = new StringBuffer();
			int N = sc.nextInt();
            List<Integer> list = new LinkedList<>();
           	for(int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }
            
            int M = sc.nextInt();
            
            for(int i = 0; i < M; i++) {
            	String str = sc.next();
                if(str.equals("I")) {
                	int location = sc.nextInt();
                    int count = sc.nextInt();
                    for(int j = location; j < count+location; j++) {
                        list.add(j, sc.nextInt());
                    }
                }else if(str.equals("D")) {
                    int location = sc.nextInt();
                    int count = sc.nextInt();
                    for(int j = location; j < count+location; j++) {
                        list.remove(location);
                    }
                }else if(str.equals("A")) {
                	int count = sc.nextInt();
                    for(int j = 0; j < count; j++) {
                    	int value = sc.nextInt();
                        list.add(value);
                    }
                }
            }
            
           	sb.append("#").append(test_case).append(" ");
            for(int i = 0; i < 10; i++) {
            	sb.append(list.get(i)).append(" ");
            }
            System.out.println(sb);
		}
	}
}
