package com.example.codingtest.dp;

import java.util.Scanner;

public class Baek9095 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for(int i=5; i<=11; i++){
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }

        for(int i=0; i<n; i++){
            int num =sc.nextInt();
            System.out.println(dp[num]);
        }



    }
}
