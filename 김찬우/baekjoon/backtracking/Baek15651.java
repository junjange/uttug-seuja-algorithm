package com.example.codingtest.backTracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15651 {

    static int[] arr;
    static int n,m;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        // 아이디어
        // 모든 경우의 수를 돈다
        // for을 돌면서 n을 선택
        // depth가 m일 때 종료

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        rec(0);
        System.out.println(sb);


    }

    public static void rec(int depth){

        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=1; i<=n; i++){

            arr[depth] = i;
            rec(depth+1);

        }
    }
}
