package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1182 {

    static int[] arr;
    static int n,s;
    static int count=0;


    public static void main(String[] args) throws IOException {
        // 1 ~ n 까지 에서 1부터 n개를 뽑으면서 합을 구하고 (중복을 허용하지 않는다)
        // sum이 5이면

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr= new int[n];

        st =  new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        if(s==0){
            System.out.println(count-1);
        }else{
            System.out.println(count);
        }


    }

    public static void dfs(int depth, int sum){

        if(depth == n){
            if (sum == s){
                count++;
            }
            return;
        }

        dfs(depth+1,sum+arr[depth]);
        dfs(depth+1,sum);

    }

}
