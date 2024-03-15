package com.example.codingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1003 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[41][2];
        int n =Integer.parseInt(br.readLine());
        int[] result = new int[n];

        for(int i=0; i<n; i++){
            result[i] = Integer.parseInt(br.readLine());
        }

        arr[0][0] =1;
        arr[0][1] =0;
        arr[1][0] =0;
        arr[1][1] =1;

        for(int i=2; i<41; i++){

            arr[i][0] = arr[i-2][0] + arr[i-1][0];
            arr[i][1] = arr[i-2][1] + arr[i-1][1];
        }

        for(int a : result){
            System.out.println(arr[a][0]+" "+arr[a][1]);
        }

    }
}


