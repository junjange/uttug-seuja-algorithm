package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek14650 {
    static int[] arr;
    static boolean[] visited;
    static int count =0;
    static int n;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[3];

        for (int i=0; i<3; i++) {
            arr[i] = i;
        }

        back(0,"");
        System.out.println(count);

    }
    static void back(int depth, String str) {



        if (depth == n) {

            if (str.charAt(0) =='0') {
                return;
            }

            if (Integer.parseInt(str) % 3 == 0) {
                count++;
                return;
            }

            return;
        }


        for (int i=0; i<3; i++) {

            back(depth+1,str + arr[i]);
        }
    }
}
