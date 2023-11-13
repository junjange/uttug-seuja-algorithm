import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    public static int n;
    public static int m;
    public static int[] parkingWeight;
    public static int[] carWeight;
    public static int[] seats;
    public static Queue<Integer> waiting;
    public static int sum;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
            m = sc.nextInt();
           
            parkingWeight = new int[n];
            for(int i = 0; i < n; i++) {
            	parkingWeight[i] = sc.nextInt();
            }
            
            carWeight = new int[m];
            for(int i = 0; i < m; i++) {
            	carWeight[i] = sc.nextInt();
            }
            
            seats = new int[n];
            waiting = new LinkedList<>();
            sum = 0;
            for(int i = 0; i < 2 * m; i++) {
            	int carNum = sc.nextInt();
                if(carNum < 0) {
                    exit(Math.abs(carNum));
                    if(waiting.size() > 0) {
                    	parking(waiting.poll());
                    }
                } else {
                    if(isFull()) {
                    	waiting.add(carNum);
                    } else {
              			parking(carNum);
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + sum);
		}
	}
    
    public static void parking(int carNum) {
    	for(int i = 0; i < n; i++) {
        	if(seats[i] == 0) {
            	seats[i] = carNum;
                sum += parkingWeight[i] * carWeight[carNum - 1];
                break;
            }
        }
    }
    
    public static void exit(int carNum) {
    	for(int i = 0; i < n; i++) {
        	if(carNum == seats[i]) {
            	seats[i] = 0;
                break;
            }
        }
    }
    
    public static Boolean isFull() {
    	for(int i = 0; i < n; i++) {
        	if(seats[i] == 0) {
            	return false;
            }
        }
        return true;
    }
}
