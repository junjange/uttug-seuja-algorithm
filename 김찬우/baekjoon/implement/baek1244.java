package com.example.codingtest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1244 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine()," ");
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        int m = Integer.parseInt(st.nextToken());


        int[][] input = new int[m][2];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            input[i][0] =  Integer.parseInt(st.nextToken());
            input[i][1] =  Integer.parseInt(st.nextToken());

        }

        for (int i=0; i<m; i++) {

            int gender = input[i][0];
            int buttonNum = input[i][1];

            if (gender == 1) {

                for (int j=1; j <= n; j++) {

                    if (j / buttonNum > 0 && j % buttonNum == 0) {

                        if (arr[j] == 0) {
                            arr[j] = 1;
                        }else {
                            arr[j] = 0;
                        }

                    }

                }

            }else {

                if (arr[buttonNum] == 1) {
                    arr[buttonNum] = 0;
                }else {
                    arr[buttonNum] = 1;
                }

                int x = 1;

                while ((buttonNum - x) > 0 && (buttonNum + x) <= n) {

                    if (arr[buttonNum - x] == arr[buttonNum + x] ) {


                        if (arr[buttonNum-x]==0) {
                            arr[buttonNum-x] = 1;
                            arr[buttonNum + x] =1;
                        }else {
                            arr[buttonNum-x] = 0;
                            arr[buttonNum + x] =0;
                        }

                        x++;
                    }else {
                        break;
                    }

                }



            }

        }



        for (int i=1; i<=n; i++) {

            System.out.print(arr[i]+" ");

            if (i % 20 == 0) {
                System.out.println();
            }

        }


    }
}
