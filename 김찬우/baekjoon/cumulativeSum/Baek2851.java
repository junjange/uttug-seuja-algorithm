

import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.lang.Math;


public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[11];

        for (int i=1; i<=10; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;
        int result =0;

        for (int i=10; i>=1; i--) {

            if (Math.abs(arr[i] - 100) < min) {

                min = Math.abs(arr[i] - 100);
                result = arr[i];

            }


        }
        
        System.out.println(result);

    }
}
