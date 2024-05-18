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
            int M = sc.nextInt();
            int K = sc.nextInt();
            
            int[] reservations = new int[N];
            for(int i = 0; i < N; i++) {
            	reservations[i] = sc.nextInt();
            }
            
            Arrays.sort(reservations);
            
            int bread = 0;
            int index = 0;
            String answer = "Possible";
            if(reservations[0] != 0) {
                for(int time = 1; time <= reservations[N-1]; time++) {
                    if(time % M == 0 && time != 0) {
                        bread += K;
                    }

                    if(index < N) {
                        if(time == reservations[index]) {
                            if(bread > 0) {
                            	bread--;
                            	index++;
                            } else {
                            	answer = "Impossible";
                                break;
                            }
                        } 
                    }
                    
                    if(answer.equals("Impossible")) {
                    	break;
                    }
                }
            } else {
            	answer = "Impossible";
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
