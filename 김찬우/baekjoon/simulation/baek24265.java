package com.example.codingtest.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek24265 {
    public static void main(String[] args) throws IOException {

        // 아이디어
        // 2중 for문

        // 시간 복잡도
        // o(n);
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        long sum = 0;

        for(long i = 1; i<n; i++){
            sum+=i;

        }

        System.out.println(sum);
        System.out.println("2");

    }
}
