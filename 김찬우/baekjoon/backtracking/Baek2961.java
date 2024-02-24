package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2961 {

    static int n;
    static int min = Integer.MAX_VALUE;


    static int[][] arr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());

        arr =new int[n][2];

        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine()," ");

            for(int j=0; j<2; j++){

                arr[i][j] = Integer.parseInt(st.nextToken());
            }


        }


        backTracking(0,0,1,0);

        System.out.println(min);
    }

    public static void backTracking(int input_cnt, int depth, int s_mul, int b_hap) {
        if (depth == n) {
            if(input_cnt != 0) {
                min = Math.min(min, Math.abs(s_mul - b_hap));
            }
            return;
        }
        backTracking(input_cnt, depth + 1, s_mul, b_hap); 
        backTracking(input_cnt + 1, depth + 1, s_mul * arr[depth][0], b_hap + arr[depth][1]); // 재료를 넣은 것
    }
}
