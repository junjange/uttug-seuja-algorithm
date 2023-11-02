import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		 
		for(int test_case = 1; test_case <= T; test_case++) {
			List<String> weekend = new ArrayList<String>(){{
            	add("MON");
                add("TUE");
                add("WED");
                add("THU");
                add("FRI");
                add("SAT");
                add("SUN");
            }};
            String today = sc.next();
            int answer = 0;
            if(today.equals("SUN")) {
            	answer = 7;
            }else {
            	answer = 7 - weekend.indexOf(today) - 1;
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
