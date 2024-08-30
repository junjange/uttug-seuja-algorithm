import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String line1 = sc.next();
            String line2 = sc.next();
            
            String[] cur = line1.split(":");
            String[] appoint = line2.split(":");
            
            boolean isNext = false;
            for(int i = 0; i < 3; i++) {
                int curTime = Integer.parseInt(cur[i]);
                int appointTime = Integer.parseInt(appoint[i]);
            	if(curTime > appointTime) {
                	isNext = true;
                    break;
                } else if(curTime < appointTime) {
                	break;
                }
            }
            
            int curSum = 0;
            int appointSum = 0;
            if(isNext) {
            	appointSum += 86400;
            } 
            
            for(int i = 0; i < 3; i++) {
            	int curTime = Integer.parseInt(cur[i]);
                int appointTime = Integer.parseInt(appoint[i]);
                curSum += (int)(curTime * Math.pow(60, 2-i));
                appointSum += (int)(appointTime * Math.pow(60, 2-i));
            }
            
            int remain = appointSum - curSum;
            StringBuilder sb = new StringBuilder();
            for(int i = 2; i >= 0; i--) {
            	int time = (int) (remain / Math.pow(60, i));
                remain -= time * Math.pow(60, i);
                if(time < 10) {
                	sb.append("0");
                }
                sb.append(String.valueOf(time) + ":");
            }
            sb.deleteCharAt(8);
            
            System.out.println("#" + test_case + " " + sb.toString());
		}
	}
}
