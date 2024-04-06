package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek16922 {

    static int n,cnt;

    static boolean[] result = new boolean[20*50+1];

    static int[] arr = new int[]{1,5,10,50};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());

        backTracking(0,0,0);


        System.out.println(cnt);


    }

    static void backTracking(int depth,int sum,int start){

        if(depth == n){
            if (!result[sum]){
                result[sum] = true;
                cnt++;
            }
            return;
        }

        for(int i=start; i<4; i++){
            backTracking(depth+1,sum+arr[i],i);

        }
    }
}
