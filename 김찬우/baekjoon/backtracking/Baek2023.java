package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek2023 {
    static int n;
    static int[] first = {2,3,5,7};
    static int[] any = {1,3,7,9};
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n];

        back(0,"");

        System.out.print(sb.toString());

    }

    static void back(int depth, String sum){

        if (depth == n) {
            sb.append(sum).append('\n');
            return;
        }

        for (int i=0; i<4; i++) {

            if (depth == 0) {

                if(!isPrime(Integer.parseInt(sum+first[i]))) {
                    continue;

                }

                back(depth+1,sum+first[i]);

            }else {
                if(!isPrime(Integer.parseInt(sum+any[i]))) {
                    continue;

                }
                back(depth+1,sum+any[i]);
            }
        }

    }

    static boolean isPrime(int num) {

        if (num == 1) {
            return false;
        }

        for (int i = 2; i*i<=num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }


}




