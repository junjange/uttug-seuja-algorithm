package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek9663 {
    static int[] arr;
    static int n;

    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        cnt = 0;

        dfs(0);

        System.out.println(cnt);




    }

    public static void dfs(int depth){

        if(depth == n){
            cnt++;
            return;
        }

        for(int i=0; i<n; i++){
            arr[depth] = i;
            if(possible(depth)){
                dfs(depth+1);
            }
        }


    }

    public static boolean possible(int col){

        for(int i=0; i < col; i++){

            if(arr[i] == arr[col]){
                return false;
            }

            else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
                return false;
            }

        }
        return true;

    }




}
