package com.example.codingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1149 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][n];
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine()," ");

            for(int j=0; j<3; j++){

                arr[i][j] = Integer.parseInt(st.nextToken());

                if(i==0){
                    dp[i][j] = arr[i][j];
                }

            }

        }

        for(int i=1; i<n; i++){

            for(int j=0 ;j<3; j++){

                for(int k=0; k<3; k++){

                    if(j == k){
                        continue;
                    }

                    if(dp[i][j] == 0){
                        dp[i][j] = arr[i][j]+dp[i-1][k];
                    }else{
                        dp[i][j] = Math.min(arr[i][j]+dp[i-1][k],dp[i][j]);
                    }



                }


            }

        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<3;i++){

            if(min > dp[n-1][i]){
                min = dp[n-1][i];
            }
        }


        System.out.println(min);



    }
}
