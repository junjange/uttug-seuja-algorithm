import java.io.*;
import java.util.*;
 
public class Solution {
 
    static int[] result;
    static ArrayList<int[]> person;
    static ArrayList<int[]> stairs;
    static ArrayList<Integer> waitOne;
    static ArrayList<Integer> waitTwo;
    static Queue<Integer> stairOne;
    static Queue<Integer> stairTwo;
    static int min;
    static int timeOne,timeTwo,n,len;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
 
        for (int test_case =1; test_case<=T; test_case++) {
 
            person = new ArrayList<>();
            stairs = new ArrayList<>();
            waitOne = new ArrayList<>();
            waitTwo = new ArrayList<>();
            stairOne = new ArrayDeque<>();
            stairTwo = new ArrayDeque<>();
            min = Integer.MAX_VALUE;
 
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
 
 
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j < n; j++) {
                    int a = Integer.parseInt(st.nextToken());
                    if (a == 1 ) {
                        person.add(new int[]{i,j});
                    }else if (a > 1) {
                        stairs.add(new int[]{i,j,a});
                    }
                }
 
            }
 
            len = person.size();
            result = new int[len];
 
            back(0);
 
            System.out.println("#"+test_case+" "+min);
 
        }
 
 
    }
 
    static void back(int depth) {
 
        if (depth == len) {
            waitOne.clear();
            waitTwo.clear();
            stairOne.clear();
            stairTwo.clear();
 
 
            for (int i=0; i<len; i++) {
 
                int[] personPosition = person.get(i);
                int[] stairPosition = stairs.get(result[i]);
 
                if (result[i] == 0) {
                    waitOne.add(Math.abs(personPosition[0] - stairPosition[0])+ Math.abs(personPosition[1] - stairPosition[1]) + 1);
                }else {
                    waitTwo.add(Math.abs(personPosition[0] - stairPosition[0])+ Math.abs(personPosition[1] - stairPosition[1]) + 1);
                }
            }
 
            timeOne = 0;
            timeTwo = 0;
 
            if (!waitOne.isEmpty()) {
                Collections.sort(waitOne);
                timeOne = waitOne.get(0);
            }
 
            if (!waitTwo.isEmpty()) {
                Collections.sort(waitTwo);
                timeTwo = waitTwo.get(0);
            }
 
            // 1번 계단
 
            while (true) {
 
                if (stairOne.isEmpty() && waitOne.isEmpty()) {
                    break;
                }
 
                if (!stairOne.isEmpty()) {
 
                    int k = stairOne.size();
 
                    for (int i = 0; i < k; i++) {
                        Integer poll = stairOne.poll();
 
                        if (timeOne - poll < stairs.get(0)[2]) {
                            stairOne.offer(poll);
                        }
                    }
 
                }
 
                if (!waitOne.isEmpty()) {
 
                    int k = waitOne.size();
 
                    for (int i=0; i<k; i++) {
 
                        if (stairOne.size() < 3 &&  waitOne.get(0) <= timeOne ) {
                            stairOne.offer(timeOne);
                            waitOne.remove(0);
                        }
 
                    }
 
                }
 
                timeOne++;
 
            }
 
            // 2번 계단
 
            while (true) {
 
                if (stairTwo.isEmpty() && waitTwo.isEmpty()) {
                    break;
                }
 
                if (!stairTwo.isEmpty()) {
 
                    int k = stairTwo.size();
 
                    for (int i = 0; i < k; i++) {
                        Integer poll = stairTwo.poll();
 
                        if (timeTwo - poll < stairs.get(1)[2]) {
                            stairTwo.offer(poll);
                        }
                    }
 
                }
 
                if (!waitTwo.isEmpty()) {
 
                    int k = waitTwo.size();
 
                    for (int i=0; i<k; i++) {
 
                        if (stairTwo.size() < 3 &&  waitTwo.get(0) <= timeTwo ) {
                            stairTwo.offer(timeTwo);
                            waitTwo.remove(0);
                        }
 
                    }
 
                }
 
                timeTwo++;
 
            }
 
 
            int max = Math.max(timeOne,timeTwo) - 1;
 
            min = Math.min(max,min);
 
            return;
        }
 
 
        result[depth] = 0;
        back(depth+1);
        result[depth] = 1;
        back(depth+1);
    }
}
